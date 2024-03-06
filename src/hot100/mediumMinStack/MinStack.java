package hot100.mediumMinStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 155. 最小栈
 *
 * @since 2024/3/6 15:28
 * @author by liangzj
 */
public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    Integer min;

    public static void main(String[] args) {
        MinStack minStk = new MinStack();
        minStk.push(-2);
        minStk.push(0);
        minStk.push(-3);

        System.out.println(minStk.getMin());
        minStk.pop();
        System.out.println(minStk.top());
        System.out.println(minStk.getMin());
    }

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack.push(val);
        min = Math.min(min, val);
        minStack.push(min);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        if (stack.isEmpty()) throw new NullPointerException("stack is empty");
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) throw new NullPointerException("minStack is empty");
        return minStack.peek();
    }
}
