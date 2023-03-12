package HOT100;

import java.util.ArrayList;
import java.util.List;

public class 七十八_子集 {
	//排列组合问题,首选回溯法
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		if (nums.length == 0) {
			return result;
		}
		List<Integer> path = new ArrayList<>();


		backTracing(result, path, 0, nums);
		return result;
	}

	public void backTracing(List<List<Integer>> result, List<Integer> path, int depth,int[] nums) {
		if (depth == nums.length+1) {
			return;
		}

		result.add(new ArrayList<>(path));
		for (int i = depth; i < nums.length; i++) {
			path.add(nums[i]);
			backTracing(result, path, i + 1, nums);
			path.remove(path.size() - 1);
		}
	}
}
