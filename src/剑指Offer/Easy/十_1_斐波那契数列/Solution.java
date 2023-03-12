package 剑指Offer.Easy.十_1_斐波那契数列;

public class Solution {

	//方法1,dp动态规划;时间On,空间可用滑动变量pqr优化为O1
	public int fib1(int n) {
		if (n <= 1) {
			return n;
		}
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2])%MOD;
		}
		return dp[n];
	}

	//方法2,矩阵快速幂[f(n) f(n-1)]T={{1 1},{1 0}}^(n-1)×[f(1) f(0)]
	/*tips:
	* 1.我们在计算一个数的多次幂时，可以先判断其幂次的奇偶性，然后：
    	如果幂次为偶直接 base(底数) 作平方，power(幂次) 除以2
    	如果幂次为奇则底数平方，幂次整除于2然后再多乘一次底数

* 	2.对于以上涉及到 [判断奇偶性] 和 [除以2] 这样的操作。使用系统的位运算比普通运算的效率是高的，因此可以进一步优化：
    	把 power % 2 == 1 变为 (power & 1) == 1 用于判断power为奇数,也可以写成(power & 1) != 0
    	把 power = power / 2 变为 power = power >> 1	右移一位相当于除以2,左移一位相当于乘2

	* */
	static final int MOD = 1000000007;
	public int fib(int n) {
		if (n <= 1) return n;
		long[][] mat = new long[][]{
				{1, 1},
				{1, 0}
		};
		long[][] ans = new long[][]{
				{1},
				{0}
		};
		int x = n - 1;
		while (x != 0) {
			if ((x & 1) == 1){	 //(x & 1) == 1表示x为奇数,正数的二进制有个特性,最右边的数为1则必为奇数(因为2的0次方)
				ans = mul(mat, ans);	//这就是当幂为奇数时,要多乘出来的那个东西,当幂次为偶时,直接mat乘mat,幂次减半
			}
			mat = mul(mat, mat);
			x >>= 1;
		}
		return (int)(ans[0][0] % MOD);
	}

	//处理矩阵相乘的模板,注意,左矩阵的列必须等于右矩阵的行,两个矩阵才能相乘
	long[][] mul(long[][] martLeft, long[][] martRight) {
		int aHangSize = martLeft.length, bLieSize = martRight[0].length, bHangSize = martRight.length;
		//a的行数,b的列数,b的行数(也是a的列数)
		long[][] ans = new long[aHangSize][bLieSize];
		for (int i = 0; i < aHangSize; i++) {
			for (int j = 0; j < bLieSize; j++) {
				for (int k = 0; k < bHangSize; k++) {
					ans[i][j] += (long)martLeft[i][k] * (long)martRight[k][j];
					ans[i][j]%=MOD;
				}
			}
		}
		return ans;
	}


	//方法2的第二种解法,不用矩阵[f(1) f(0)],因为f(1)=1,f(0)=0,结果就是mat矩阵进行n-1次连乘后的[0][0]的值,还要对mod取余
	public int fib3(int n) {
		if (n < 2) {
			return n;
		}
		int[][] q = {{1, 1}, {1, 0}};
		int[][] res = pow(q, n - 1);
		return res[0][0];
	}

	public int[][] pow(int[][] a, int n) {
		int[][] ret = {{1, 0}, {0, 1}};
		while (n > 0) {
			if ((n & 1) == 1) {
				ret = multiply(ret, a);
			}
			n >>= 1;
			a = multiply(a, a);
		}
		return ret;
	}

	public int[][] multiply(int[][] a, int[][] b) {
		int[][] c = new int[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				//因为已经知道c矩阵是2乘2的矩阵了,所以可以简写成如下形式
				c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
			}
		}
		return c;
	}

}
