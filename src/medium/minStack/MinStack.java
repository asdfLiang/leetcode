package medium.minStack;

import java.util.LinkedList;

/** 155. ×îÐ¡Õ» */
public class MinStack {

    private final LinkedList<Integer> data;
    private final LinkedList<Integer> minData;

    public MinStack() {
        data = new LinkedList<>();
        minData = new LinkedList<>();
    }

    public void push(int val) {
        data.push(val);
        minData.push(minData.isEmpty() ? val : Math.min(val, getMin()));
    }

    public void pop() {
        data.pop();
        minData.pop();
    }

    public int top() {
        return data.isEmpty() ? Integer.MIN_VALUE : data.peek();
    }

    public int getMin() {
        return minData.isEmpty() ? Integer.MIN_VALUE : minData.peek();
    }
}
