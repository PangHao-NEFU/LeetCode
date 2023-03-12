package HOT100;

public class 一五二_乘积最大子序列 {
	public int maxProduct(int[] nums) {
		//动态规划,设dp[i]是以i为结尾的子序列最大乘积,则可写递推方程:dp[i]=Math.max(dp[i-1]*nums[i],nums[i])
		//注意!!!!我们不光要保存最小值乘积,也要保存最大乘积,因为万一当前nums[i]是负数,最小乘积乘上负数反而得到最大值
		//所以我们需要三个变量,一个是全局最大值,一个是记录max(dp[i-1])和min(dp[i-1]),一旦出现当前nums[i]为负数,我们就交换这两个值
		int max = Integer.MIN_VALUE;	//记录全局最大值
		int dpMax=1,dpMin=1;			//记录当前最大值
		for (int num : nums) {
			if (num<0){
				int temp=dpMax;
				dpMax=dpMin;
				dpMin=temp;
			}
			dpMax = Math.max(dpMax * num, num);
			dpMin = Math.min(dpMin * num, num);
			max = Math.max(dpMax, max);
		}

		return max;

	}
}
