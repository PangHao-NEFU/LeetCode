package 剑指Offer.Easy.三_数组中重复的数字;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	//方法一,哈希map,时间On,空间On
	public int findRepeatNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int max=1;
		int maxfreqkey=nums[0];
		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				int freq = map.get(num) + 1;
				if (freq > max) {
					max=freq;
					maxfreqkey=num;
				}
				map.put(num,freq );
			}


		}

		return maxfreqkey;
	}

	//方法2,排序,时间On,空间O1
	public int findRepeatNumber2(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i] == nums[i + 1]) {
				return nums[i];
			}
		}
		return nums[0];
	}
}
