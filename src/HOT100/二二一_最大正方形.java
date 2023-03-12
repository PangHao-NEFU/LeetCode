package HOT100;

public class 二二一_最大正方形 {
	/*最大正方形:动态规划
		dp[i][j]=min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1])+1
		其中dp[i][j]表示以矩阵中以i-1和j-1为左下角的正方形的边长
	 */
	public int maximalSquare(char[][] matrix) {
		int rowNum = matrix.length + 1;
		int colNum = matrix[0].length + 1;
		int[][] dp = new int[rowNum][colNum];
		int max=0;
		for (int i = 1; i < rowNum; i++) {
			for (int j = 1; j < colNum; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j],dp[i - 1][j - 1])) + 1;
					max = Math.max(dp[i][j], max);
				}
			}
		}
		return (int) Math.pow(max, 2);
	}
}
