package medium.minStack;
/**
 * 155. ×îÐ¡Õ»
 *
 * @since 2023/4/23 21:57
 * @author by liangzj
 */
public class MinStackMain {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
