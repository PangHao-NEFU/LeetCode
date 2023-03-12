package HOT100;

import java.util.HashSet;
import java.util.Set;

public class 一二八_最长连续序列 {
	public int longestConsecutive(int[] nums) {
		//On则不能用排序算法
		Set<Integer> num_set = new HashSet<Integer>();
		for (int num : nums) {
			num_set.add(num);
		}

		int longestStreak = 0;

		for (int num : num_set) {
			if (!num_set.contains(num - 1)) {
				int currentNum = num;
				int currentStreak = 1;

				while (num_set.contains(currentNum + 1)) {
					currentNum += 1;
					currentStreak += 1;
				}

				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}

		return longestStreak;

	}
}
