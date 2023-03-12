package HOT100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三十九_组合总和 {
	//想到组合,首先是回溯法,回溯法的思想就是递归解决搜索深度,循环解决搜索宽度
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<List<Integer>> result = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<>();
		Arrays.sort(candidates);
		int candiLen = candidates.length;
		if (candiLen == 0) {
			return result;
		}
		backTracing(result, path, candidates, 0, target);
		return result;
	}

	/**
	 *
	 * @param result	结果收集器
	 * @param path		状态收集器,要添加到结果收集器中的
	 * @param candidates	候选数组
	 * @param begin			候选数组的开始搜索索引
	 * @param target		目标值,当为0时就是收集的时候
	 */

	private void backTracing(ArrayList<List<Integer>> result,ArrayList<Integer> path,int[] candidates,int begin,int target) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			result.add(new ArrayList<>(path));
			return;
		}


		for (int i = begin; i <candidates.length; i++) {
			//需要剪枝
			if (target - candidates[i] < 0) {
				break;
			}

			path.add(candidates[i]);
			backTracing(result, path, candidates, i, target - candidates[i]);
			path.remove(path.size() - 1);
		}

	}
}
