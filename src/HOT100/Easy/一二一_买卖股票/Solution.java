package HOT100.Easy.一二一_买卖股票;

public class Solution {
    //方法1,暴力迭代,时间复杂度O(n2),空间复杂度O(1)
    public int maxProfit(int[] prices) {
        int maxPft=0;
        int day=-1;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit>0){
                    maxPft=profit>maxPft?profit:maxPft;
                }
            }
        }

        return  maxPft;
    }

    //方法2,动态规划,一次迭代
    public int maxProfit2(int[] prices){
        int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i-1],prices[i]);    //记录之前的买入最低点
            max = (prices[i] - dp[i]) > max ? prices[i] - dp[i] : max;
        }
        return max;
    }
}
