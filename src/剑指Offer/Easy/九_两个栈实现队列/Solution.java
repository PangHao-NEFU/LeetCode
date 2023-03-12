package 剑指Offer.Easy.九_两个栈实现队列;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	class CQueue {
		Deque<Integer> stack1;
		Deque<Integer> stack2;
		public CQueue() {
			stack1=new LinkedList<>();
			stack2=new LinkedList<>();
		}

		public void appendTail(int value) {
			stack1.push(value);

		}

		public int deleteHead() {
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
			int res=-1;
			if (!stack2.isEmpty()) {
				return stack2.pop();
			}
			return res;
		}
	}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
