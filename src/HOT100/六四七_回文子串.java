package HOT100;

public class 六四七_回文子串 {
	/*
	动态规划
	dp[i][j]=dp[i+1][j-1] 当s[i]==s[j]
	初始状态dp[i][i]=true dp[i][i+1]=true 当s[i]=s[i+1]
	 */
	public int countSubstrings(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		int count=0;


		//需要注意状态转移的方向,dp[i][j]依赖于其左下边的变量,所以必须从左到右从上到下进行计算
		for (int j = 0; j < s.length(); j++) {
			for (int i = 0; i <= j; i++) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
					count++;
				}
			}
		}
		return count;
	}
}
