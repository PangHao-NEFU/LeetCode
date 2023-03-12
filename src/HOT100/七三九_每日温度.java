package HOT100;

import java.util.ArrayDeque;

public class 七三九_每日温度 {

	public int[] dailyTemperatures2(int[] temperatures) {
		//方法1.暴力搜索,时间On2,空间o1,超时
		int len = temperatures.length;
		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (temperatures[j] > temperatures[i]) {
					result[i] = j-i;
					break;
				}
			}
		}
		return result;
	}

	/*方法2,单调栈,找比当前高的第一个元素下标,维护一个单调递减的单调栈
	* */
	public int[] dailyTemperatures(int[] temperatures) {
		int len = temperatures.length;
		int[] result = new int[len];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < len; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				Integer currentIndex = stack.pop();
				result[currentIndex] = i-currentIndex;
			}
			stack.push(i);
		}
		return result;
	}


}
