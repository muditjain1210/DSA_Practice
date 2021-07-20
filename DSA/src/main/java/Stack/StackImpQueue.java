package Stack;

import java.util.Stack;

public class StackImpQueue<T> {

    public Stack<T> addStack;
    public Stack<T> removeStack;

    public StackImpQueue() {
        this.addStack = new Stack<>();
        this.removeStack = new Stack<>();
    }

    // Add
    public void add(T data) {
        addStack.push(data);
    }

    // Remove
    public T remove() {
        // POP until remove stack is not empty
        if (!removeStack.isEmpty()) {
            return removeStack.pop();
        }
        shiftElements();
        return removeStack.pop();
    }

    // Peek
    public T peek() {
        if (!removeStack.isEmpty()) {
            return removeStack.peek();
        }
        shiftElements();
        return removeStack.peek();
    }

    // Is Empty
    public boolean isEmpty() {
        return (addStack.isEmpty() && removeStack.isEmpty());
    }

    // Shift elements from addStack to removeStack
    private void shiftElements() {
        while (!addStack.isEmpty()) {
            removeStack.push(addStack.pop());
        }
    }

}

