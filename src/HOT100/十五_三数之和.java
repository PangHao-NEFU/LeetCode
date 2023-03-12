package HOT100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 十五_三数之和 {
	public static void main(String[] args) {
		threeSum(new int[]{-1, 0, 1, 2, -1, -4});
	}
	static public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> anwser = new ArrayList<>();
		//特殊情况直接返回
		if (nums == null || nums.length < 3) {
			return new ArrayList<>();
		}
//		先排序
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0&&nums[i] == nums[i - 1]) {
					continue;
			}
			int left=i+1;
			int right=nums.length-1;

			//如果最小的都大于0,那就没法玩了
			if (nums[i] > 0) {
				break;
			}

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (sum > 0&&right>left) {
					right--;
				}
				if (sum < 0&&left<right) {
					left++;
				}
				if (sum == 0 && left < right) {
					ArrayList<Integer> item = new ArrayList<>();
					item.add(nums[i]);
					item.add(nums[left]);
					item.add(nums[right]);
					anwser.add(item);
					left++;
					right--;

					//下方代码以防有重复的进行干扰
					while (left<right&&nums[left] == nums[left - 1]) {
						left++;
					}
					while (left < right &&right+1<nums.length&& nums[right] == nums[right + 1]) {
						right--;
					}
				}

			}

		}
		return anwser;

	}
}
