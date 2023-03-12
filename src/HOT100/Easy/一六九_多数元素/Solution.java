package HOT100.Easy.一六九_多数元素;

import java.util.HashMap;

public class Solution {
	public int majorityElement(int[] nums) {
		int length = nums.length;
		int maxNumKey=nums[0];
		int maxNum=1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				if (maxNum < map.get(num) + 1) {
					maxNum=map.get(num) + 1;
					maxNumKey=num;
				}

				map.put(num,map.get(num) + 1 );
			}
		}

		return maxNumKey;
	}
}
