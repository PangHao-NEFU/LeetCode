package HOT100;

public class 五十五_跳跃游戏 {
	public boolean canJump(int[] nums) {
		if (nums == null) {
			return false;
		}
		int k = 0;		//记录可跳的最远距离
		for (int i = 0; i <= k; i++) {
			k = Math.max(k, i + nums[i]);
			if (k >= nums.length - 1) {
				return true;
			}
		}

		return false;
	}
}
