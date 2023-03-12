package HOT100;

import java.util.ArrayDeque;

public class 三十二_最长有效括号 {
	public int longestValidParentheses(String s) {
		if (s.length() == 0) {
			return 0;
		}
		ArrayDeque<Integer> stack = new ArrayDeque<>();	//栈中维护左括号的下标,栈底维护最近一个没匹配上的')'
		stack.push(-1);		//栈底维护一个未匹配的')',表示最长子串从栈底元素+1的下标开始
		int maxSize=0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);		//记录上一个未匹配的')'
				} else {
					maxSize = Math.max(maxSize, i - stack.peek());
				}
			}

		}
		return maxSize;
	}

}
