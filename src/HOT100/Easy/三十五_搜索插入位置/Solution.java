package HOT100.Easy.三十五_搜索插入位置;

public class Solution {
    public static void main(String[] args) {

    }

    public static int searchInsert(int[] nums, int target) {

        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) /2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }


}
