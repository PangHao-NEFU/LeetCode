package 剑指Offer.Easy.十七难_打印从1到最大的n位数;

public class Solution3 {
	//考虑大数：
	//思路：考虑采用全排列,此处不能用数组输出，因为 Math.pow 规定数组长度时会越界
	//1.难点在于如果求 digit 位数的全排列，首位不能为0，所以此处采用一开始一个 for 固定首位的方法
	//2.先遍历求出所有位数的全排列，每一个位数(比如3位数)的全排列求出后，加入结果
	StringBuilder ans;
	public String printNumbers(int n) {

		ans = new StringBuilder();

		//遍历各 位数 情况，每次加入结果数组
		for (int digit = 1; digit <= n; digit++) {
			//固定好首位，全排列其他位
			for (char first = '1'; first <= '9'; first++) {

				char[] num = new char[digit];

				//首位赋值
				num[0] = first;

				dfs(digit, num, 1);
			}
		}
		return ans.toString();
	}

	public void dfs(int digit, char[] num, int index) {

		//当指针指到 digit 的末尾，把该数加入结果
		if (index == digit) {
			//如 digit为 3 时构成 134 就加入
			//每次加完一个数时，需要用逗号分割
			ans.append(String.valueOf(num)).append(",");
			return;
		}
		//遍历1-9
		for (char i = '0'; i <= '9'; i++) {
			//遍历下标为 index 处的排列
			num[index] = i;
			//递归至下一个index
			dfs(digit, num, index + 1);
		}
	}
}
