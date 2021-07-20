package Stack;

import java.util.Stack;

public class MinStack {
    private final Stack<Integer> mainStack;
    private final Stack<Integer> minStack;

    public MinStack() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int num) {
        // first time we have to push element on min stack..
        // minStack.peek() >= num ---> Equality is required if there are more than 1 minimum elements
        if (minStack.isEmpty() || minStack.peek() >= num) {
            minStack.push(num);
        }
        mainStack.push(num);
    }

    public void pop() {
        int i = mainStack.peek();
        if (minStack.peek() == i) {
            minStack.pop();
        }
        mainStack.pop();
    }

    public int peek() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    @Override
    public String toString() {
        return "MinStack{" +
                "mainStack=" + mainStack +
                ", minStack=" + minStack +
                '}';
    }
}
