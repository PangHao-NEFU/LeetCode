package HOT100;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 二一五_数组中第k个最大元素 {
	//1.暴力解法:时间Onlogn,空间ologn,默认的sort是快排
	public int findKthLargest(int[] nums, int k) {
		int len = nums.length;
		Arrays.sort(nums);
		return nums[len - k];
	}

	//2.维护一个有k个元素的小顶堆,堆顶元素就是我们想要的元素,PriorityQueue,默认是小顶堆
	public int findKthLargest2(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, ((o1, o2) -> o1 - o2));
		int len = nums.length;
		//初始化堆
		for (int i = 0; i < k; i++) {
			minHeap.offer(nums[i]);
		}

		//开始正是调整堆
		for (int i = k; i < len; i++) {
			// 看一眼，不拿出，因为有可能没有必要替换
			Integer topElement = minHeap.peek();
			// 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
			if (nums[i] > topElement) {
				// Java 没有 replace()，所以得先 poll() 出来，然后再放回去
				minHeap.poll();
				minHeap.offer(nums[i]);
			}
		}
		return minHeap.peek();

	}
}
