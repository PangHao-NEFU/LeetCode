package HOT100;

public class 九十六_不同的二叉搜索树 {
	//在数据结构一书中,二叉搜索树的个数是卡特兰数,卡特兰数的计算公式是Gn=[2(2n+1)/n+2] * G(n-1)
	//本题考的就是卡特兰数的递推公式
	/*动态规划:假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
	Gn=f(1)+...+f(n)
	f(i)=G(i-1)*G(n-i)	左子树个数×右子树个数
	综上得:G(n)=G(0)*G(n-1)+G(1)*G(n-2)+....+G(n-1)*G(0)		//从此公式看出Gn是依赖于G0到G(n-1)的
	 */

	public int numTrees(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;

		for(int i = 2; i <= n ; i++)	//外层控制Gn,内层控制累加
			for(int j = 0; j < i; j++)
				dp[i] += dp[j] * dp[i-j-1];

		return dp[n];
	}

}
