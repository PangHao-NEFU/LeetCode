package HOT100;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 八十四_柱状图中最大矩形 {

	//方法1:暴力枚举高度,时间On,过不了
	public int largestRectangleArea(int[] heights) {
		//此方法枚举高度:求以当前高度为高度的矩形的面积 暴力解法过不了!
		int answer=-1;
		for(int i=0;i<heights.length;i++){
			int currentHeight=heights[i];
			int left=i,right=i;
			while(left-1>=0&&heights[left-1]>=currentHeight){
				left--;
			}
			while(right+1<heights.length&&heights[right+1]>=currentHeight){
				right++;
			}
			int currentMianji=currentHeight*(right-left+1);
			answer=Math.max(currentMianji,answer);
		}
		return answer;

	}

	//方法2:单调栈
	//本题的解决要点是,判定以当前高度为高度的矩形的左右边界,即找到左边界和右边界,使得左边界的高度与右边界的高度均小于当前高度
	//具体执行步骤为:栈中存放元素下标,用两个数组来记录当前元素的左右边界,遇到大于等于栈顶的就进栈,遇到小于栈顶的就出栈
	//每次进栈确定当前元素的左边界,每次出栈确定当前元素的右边界,保证栈中每个元素都是比其下面的元素大
	public int largestRectangleArea2(int[] heights) {
		int len = heights.length;
		//一些特殊情况
		if (len == 0) {
			return 0;
		}
		if (len == 1) {
			return heights[0];
		}


		int[] left = new int[len];	//记录每个元素的左边界,默认是-1
		int[] right = new int[len];	//记录每个元素的右边界,默认是len
		Arrays.fill(right, len);
		int ans=-1;		//记录最大矩形面积
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < heights.length; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				right[stack.peek()]=i;		//如果当前元素比栈顶元素大,就已经知道了栈顶元素的右边界就是i了
				stack.pop();
			}
			if (stack.isEmpty()) {			//因为栈是单调的,所以每个栈的左边界都是其下一个元素,特殊情况是第一个元素
				left[i] = -1;
			} else {
				left[i]=stack.peek();
			}
			stack.push(i);
		}
		for (int i = 0; i < len; i++) {
			int current = (right[i] - left[i] - 1) * heights[i];
			ans = Math.max(ans, current);
		}

		return ans;
	}

}
