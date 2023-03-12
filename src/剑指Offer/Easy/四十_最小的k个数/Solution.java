package 剑指Offer.Easy.四十_最小的k个数;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	//解法1,面试肯定不能这么写,时间O(nlogn),空间O(logn)
	public int[] getLeastNumbers(int[] arr, int k) {
		Arrays.sort(arr);
		int[] ints = Arrays.copyOf(arr, k);
		return ints;
	}

	//解法2,堆排序,java默认为小根堆,将所有元素加入小根堆,然后依次弹出小根堆前k个元素
	public int[] getLeastNumbers2(int[] arr, int k) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		int[] ans = new int[k];
		for (int i : arr) {
			priorityQueue.add(i);
		}
		for (int i = 0; i < k; i++) {
			ans[i]=priorityQueue.poll();
		}
		return ans;
	}

	//优化的堆排序,不需要对arr所有元素都加入堆中,只需维护一个含有k个元素的大根堆,如果arr出现一个元素小于堆顶元素
	//就把堆顶元素出堆,当前元素进堆,这样只需要维护一个具有k个元素的堆即可
	//时间O(nlogk) 空间O(k),而k<=n,是要更优秀的
	// 注意,java默认维护小顶堆
	public int[] getLeastNumbers3(int[] arr, int k) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(
				(Integer o1, Integer o2) ->{
			return o2-o1;	//当o2>o1时,java中的堆会认为o1>o2,o2会更靠近堆顶,从而实现大顶堆;
		});
		int[] ans = new int[k];
		if (k == 0) { // 排除 0 的情况
			return ans;
		}
		for (int i = 0; i < k; i++) {	//初始化大顶堆
			priorityQueue.add(arr[i]);
		}
		for (int i = k; i < arr.length; i++) {	//如果出现比堆顶更小的元素,出堆,将当前元素进堆
			if (arr[i] < priorityQueue.peek()) {
				priorityQueue.poll();
				priorityQueue.add(arr[i]);
			}
		}

		for (int i = 0; i < k; i++) {	//将堆添加进ans并返回
			ans[i]=priorityQueue.poll();
		}

		return ans;
	}
}
