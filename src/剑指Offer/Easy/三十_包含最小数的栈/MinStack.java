package 剑指Offer.Easy.三十_包含最小数的栈;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
	/** initialize your data structure here. */
	Deque<Integer> stack1;
	Deque<Integer> minStack;
	public MinStack() {
		stack1=new LinkedList<>();
		minStack=new LinkedList<>();
	}

	public void push(int x) {
		stack1.push(x);
		if (minStack.isEmpty()) {
			minStack.push(x);
		} else {
			if (x < minStack.peek()) {
				minStack.push(x);
			} else {
				minStack.push(minStack.peek());
			}
		}
	}

	public void pop() {
		if (stack1 != null && minStack != null) {
			stack1.pop();
			minStack.pop();

		}
	}

	public int top() {
		if (!stack1.isEmpty()) {
			return stack1.peek();
		}
		return -1;
	}

	public int min() {
		if (!minStack .isEmpty()) {
			return minStack.peek();
		}
		return -1;
	}
}
