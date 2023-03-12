package HOT100;

import java.util.LinkedHashMap;
import java.util.List;

public class 一三九_单词拆分 {
	//此问题是典型的背包问题,可以重复拿
	//动态规划dp[i]=dp[j]&&list.has(substr(j,i)),dp[i]代表s(0,i-1)能否可以由单词表组成
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length()+1];
		dp[0]=true;
		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = i-1; j >=0; j--) {
				String substring = s.substring(j, i);
				if (dp[j] && wordDict.contains(substring)) {
					dp[i] = true;
					break;
				}
			}
		}
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();


		return dp[s.length()];
	}
}
