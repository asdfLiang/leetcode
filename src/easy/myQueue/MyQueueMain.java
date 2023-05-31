package easy.myQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232. 用栈实现队列
 *
 * @since 2023/5/31 22:14
 * @author by liangzj
 */
public class MyQueueMain {
    public static void main(String[] args) {}

    static class MyQueue {
        static Deque<Integer> stack1;
        static Deque<Integer> stack2;

        public MyQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                in2out();
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                in2out();
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack2.isEmpty() && stack1.isEmpty();
        }

        public void in2out() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
