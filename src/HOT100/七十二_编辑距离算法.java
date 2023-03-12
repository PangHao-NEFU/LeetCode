package HOT100;

public class 七十二_编辑距离算法 {
	/*动态规划
	* 本质上操作之分三种:在单词 A 中插入一个字符；在单词 B 中插入一个字符；修改单词 A 的一个字符。
	* dp[i][j]表示A的前i个字母与b的前j个字母的编辑距离
	* 注意:在修改时,如果最后一个字母相同,则无需修改,不用+1,比如hors到ro操作距离是c,则horse到roe不会超过c
	* dp方程:dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1)
	* 当最后一个字母相同时dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1])
	* 时间Omn双层for循环,空间Omn dp数组*/
	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();
		// 有一个字符串为空串
		if (n * m == 0) {
			return n + m;
		}
		int[][] dp= new int[n + 1][m + 1];		//因为会考虑空串的情况

		// 边界状态初始化
		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j < m + 1; j++) {
			dp[0][j] = j;
		}
		//开始计算dp数组
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				int left = dp[i][j - 1] + 1;
				int up = dp[i - 1][j] + 1;
				int leftup = dp[i - 1][j - 1];
				if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
					leftup = dp[i - 1][j - 1] + 1;
				}
				dp[i][j]=Math.min(left, Math.min(up,leftup));

			}
		}
		return dp[n][m];

	}
}
