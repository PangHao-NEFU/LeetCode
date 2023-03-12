package 剑指Offer.Easy.二十一_调整数组顺序;

public class Solution {
	public int[] exchange(int[] nums) {
		int left=0,right=nums.length-1;
		while (left < right) {
			while ((nums[left] & 1) == 1 && left < right) left++;        //选一个偶数,如果当前是奇数就下一个

			while ((nums[right] & 1) == 0 && left < right) right--;    //选一个奇数,如果当前是偶数就上一个

			int temp = nums[right];
			nums[right] = nums[left];
			nums[left]=temp;
			left++;
			right--;
		}
		return nums;
	}
}
