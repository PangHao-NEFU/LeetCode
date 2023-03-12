package HOT100;

public class 一九八_打家劫舍 {
	public int rob(int[] nums) {
		/*
		动态规划,dp[i]=max(dp[i-2]+nums[i],dp[i-1]),表示偷前i家房子能拿的累计最多的钱
		你有两个选择,偷当前的或者不偷当前的
		dp[i]表示到了下标为i的房子时能偷的累计最大金额
		 */
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int length = nums.length;
		if (length == 1) {
			return nums[0];
		}
		int[] dp = new int[length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[length - 1];

	}

	//优化:当前状态只与dp[i-1]和dp[i-2]有关,用两个变量代替,并不断更新变量值
	public int rob2(int[] nums) {
		int prev = 0;
		int curr = 0;

		// 每次循环，计算“偷到当前房子为止的最大金额”
		for (int i : nums) {
			// 循环开始时，curr 表示 dp[k-1]，prev 表示 dp[k-2]
			// dp[k] = max{ dp[k-1], dp[k-2] + i }
			int temp = Math.max(curr, prev + i);
			prev = curr;
			curr = temp;
			// 循环结束时，curr 表示 dp[k]，prev 表示 dp[k-1]
		}

		return curr;
	}

}
