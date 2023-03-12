package HOT100;

import java.util.ArrayList;
import java.util.List;

public class 四十六_全排列 {
	public List<List<Integer>> permute(int[] nums) {
		int len = nums.length;
		ArrayList<List<Integer>> result = new ArrayList<>();
		if (len == 0) {
			return result;
		}
		List<Integer> path = new ArrayList<>();
		boolean[] used = new boolean[len];		//排列中不允许有重复的数,此数组记录已经使用过的数的数组下标
		backTracing(result,path,0, nums, used);

		return result;
	}

	public void backTracing(ArrayList<List<Integer>> result, List<Integer> path, int depth, int[] nums,boolean[] used) {
		if (depth == nums.length) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				used[i]=true;
				path.add(nums[i]);
				backTracing(result, path, depth + 1, nums, used);
				path.remove(path.size() - 1);
				used[i]=false;
			}
		}

	}
}
