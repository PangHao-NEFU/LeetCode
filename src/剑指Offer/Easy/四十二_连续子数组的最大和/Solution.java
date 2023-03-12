package 剑指Offer.Easy.四十二_连续子数组的最大和;

public class Solution {
	//方法1,动态规划,递推方程dp[i]=max(dp(i-1)+nums[i],nums[i]),时间On,空间On
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		int max=nums[0];
		dp[0]=nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			max= Math.max(dp[i], max);
		}

		return max;
	}

	//方法1的优化,dp[i]只与dp[i-1],有关,用一个pre变量来维护dp[i-1]的值,时间On,空间O1
	public int maxSubArray2(int[] nums) {
		int[] dp = new int[nums.length];
		int max=nums[0];
		int pre = nums[0];
		for (int i = 1; i < nums.length; i++) {
			pre = Math.max(pre + nums[i], nums[i]);
			max= Math.max(pre, max);
		}

		return max;
	}
}
