package HOT100;

public class 三十三_搜索旋转排序数组 {
	//局部有序
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		if (nums.length == 0) return -1;

		if (nums.length == 1) return nums[0] == target ? 0 : -1;

		while (left <= right) {

			int mid = (left + right) >> 1;
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[0] <= nums[mid]) {
				if (nums[0] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[nums.length - 1]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

		}
		return -1;
	}
}
