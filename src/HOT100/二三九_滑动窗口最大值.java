package HOT100;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 二三九_滑动窗口最大值 {
	//方法1:第一个想法是维护一个大根堆,堆中维护的是一个val和index的二元组
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 1) {
			return nums;
		}
		ArrayList<Integer> result = new ArrayList<>();
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(((o1, o2) -> o2[0] - o1[0]));
		//初始化堆
		for (int i = 0; i < k; i++) {
			maxHeap.add(new int[]{nums[i], i});		//二元组的第一位是当前值,第二位是索引
		}
		result.add(maxHeap.peek()[0]);
		for (int i = k; i < nums.length; i++) {		//窗口是[i-k+1,i]
			maxHeap.add(new int[]{nums[i], i});
			while (!maxHeap.isEmpty()&&maxHeap.peek()[1] < i - k + 1) {	//每次移动窗口都检查一下堆顶元素是否还在窗口中
				maxHeap.poll();						//不在窗口中就移除
			}
			result.add(maxHeap.peek()[0]);

		}
		return result.stream().mapToInt(Integer::valueOf).toArray();
	}

	//方法2:单调的双端队列,只需要维护一个最大值就行,让队列中的元素都是逐渐递减的,队头元素就是当前窗口最大值,一旦出现较大值就将
	//队尾全部弹出,直到满足队列是单调递减的后,将较大值加入队列
}
