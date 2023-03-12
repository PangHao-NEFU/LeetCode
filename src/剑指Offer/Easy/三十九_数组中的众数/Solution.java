package 剑指Offer.Easy.三十九_数组中的众数;

public class Solution {
	//方法1:HashMap,时间On,空间On,此解法在HOT100中出现,不再赘述

	//方法2,排序,如果用java自带的sort,空间会达到Ologn,手写堆排序可以将空间复杂度降为O1

	//方法3:摩尔投票法,时间On,空间O1,此方法在腾讯后端面试中出现
	/*摩尔投票法,众数记为+1,其他记为-1,根据题意,最后投票结果肯定>0
	* 	推论:如果前a个数投票结果为0,那么后n-a个数的投票结果肯定>0,即后n-a个数的众数不会变*/
	public int majorityElement(int[] nums) {
		int maxNum = nums[0];
		int vote=0;
		for (int i = 0; i < nums.length; i++) {
			if (vote==0) {
				maxNum=nums[i];

			}
			if (nums[i] == maxNum) {
				vote++;
			} else {
				vote--;
			}
		}
		return maxNum;
	}

}
