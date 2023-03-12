package 剑指Offer.Easy.十一_旋转数组最小数字;

import java.util.Arrays;

public class Solution {
	//不是..
	public int minArray(int[] numbers) {
		Arrays.sort(numbers);
		return numbers[0];
	}

	//正经二分查找,最小值左侧的都>=numbers[right],而最小值右侧的都小于等于numbers[right]
	public int minArray2(int[] numbers) {
		int min = numbers[0];
		int left=0;
		int right=numbers.length-1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (numbers[mid] < numbers[right]) {	//numbers[right]始终在最小值右边,且比最小值大
				right=mid;
			} else if (numbers[mid] > numbers[right]) {//如果此条件满足,则mid一定在最小值左边
				left = mid+1;
			} else {
				//如果numbers[mid]==numbers[right],坏了,没法判断mid在最小值左边还是右边
				right--;
			}
		}
		return numbers[left];

	}
}
