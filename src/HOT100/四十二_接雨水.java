package HOT100;

public class 四十二_接雨水 {
	public int trap(int[] height) {
		//双指针法,哪边低就先移动哪边,时间On,空间O1
		//计算公式为sum=sum+leftMax-height[left],sum=sum+rightMax-height[right],哪边小就先算哪边,先移动哪边
		int left = 0, right = height.length-1;
		int leftMax = height[0], rightMax = height[height.length - 1];
		int sum = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				leftMax = leftMax < height[left] ? height[left] : leftMax;
				sum = sum + leftMax - height[left];
				left++;
			}else {
				rightMax = rightMax < height[right] ? height[right] : rightMax;
				sum = sum + rightMax - height[right];
				right--;
			}

		}

		return sum;

	}
}
