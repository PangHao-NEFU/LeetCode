package HOT100;

public class 三十四_在排序数组中查找元素第一个和最后一个位置 {
	//本题要求时间复杂度为O(logN),二分
	public int[] searchRange(int[] nums, int target) {
		//一些特殊情况
		if(nums.length == 0) return new int[]{-1,-1};

//		本题在用二分法来划分区间时,当l=mid+1时和r=mid时,mid=(l + r) >> 1
		//当l=mid,r=mid-1时,mid=(l + r + 1) >> 1		因为当r=l+1时,mid仍然为l,会造成死循环

		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = (l + r+1) >> 1;
			if (nums[mid]<=target) l = mid;		//找大
			else r=mid-1;
		}
		if (nums[l] != target) {
			return new int[]{-1, -1};
		}
		int index1=l;
		l = 0; r = nums.length - 1;
		while (l < r) {
			int mid=(l + r) >> 1;
			if (nums[mid]>=target) r = mid;	//找小
			else l=mid+1;
		}
		return new int[]{l,index1};
	}
}
