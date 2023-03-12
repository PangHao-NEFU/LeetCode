package HOT100;

public class 六十四_最小路径和 {
	public int minPathSum(int[][] grid) {
		//动态规划,dp[i][j]=min(dp[i-1][j],dp[i][j-1]+grid[i][j]
		int hang = grid.length;
		int lie = grid[0].length;
		int[][] dp = new int[hang][lie];
		//设定初始条件
		dp[0][0] = grid[0][0];
		for (int i = 1; i < hang; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int j = 1; j < lie; j++) {
			dp[0][j] = dp[0][j - 1] + grid[0][j];
		}
		for (int i = 1; i < hang; i++) {
			for (int j = 1; j < lie; j++) {
				dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])  + grid[i][j];
			}
		}
		return dp[hang - 1][lie - 1];

	}
}
