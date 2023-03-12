package HOT100.Easy.四四八_消失的数字;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		int n = nums.length;
		int[] temp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			temp[nums[i]]=1;
		}
		for (int i = 1; i <= n; i++) {
			if (temp[i]==0) {
				ans.add(i);
			}
		}

		return  ans;

	}

}
