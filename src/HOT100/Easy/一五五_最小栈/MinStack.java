package HOT100.Easy.一五五_最小栈;

import java.util.*;

public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();

    }

    public void push(int x) {
        if (xStack.isEmpty() && minStack.isEmpty()) {
            xStack.push(x);
            minStack.push(x);
        }else {
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }
    }

    public void pop() {

        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
