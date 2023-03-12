package HOT100;

public class 六十二_不同路径 {

	/*动态规划,dp[i][j]=dp[i-1][j]+dp[i][j-1]
	边界条件:第一行和第一列都为1
	*/
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		//设定边界条件
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[m - 1][n - 1];

	}

}
