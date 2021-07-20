package Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ThreeStacksUsingArray {
    private int[] arr = new int[16];
    private int top_1 = -3;
    private int top_2 = -2;
    private int top_3 = -1;

    public void push(int stack, int number) {
        int top;
        if (stack == 1) {
            top = top_1 + 3;
            top_1 = top;
        } else if (stack == 2) {
            top = top_2 + 3;
            top_2 = top;
        } else if (stack == 3) {
            top = top_3 + 3;
            top_3 = top;
        } else {
            throw new IllegalArgumentException("Invalid stack number passed: " + stack);
        }

        if (top >= arr.length) {
            //perform expand
        }
        arr[top] = number;
    }

    public int pop(int stack) {
        int popVal;
        if (stack == 1) {
            if (top_1 < 0) {
                throw new EmptyStackException();
            }
            popVal = arr[top_1];
            top_1 = top_1 - 3;
            return popVal;
        }
        if (stack == 2) {
            if (top_2 < 0) {
                throw new EmptyStackException();
            }
            popVal = arr[top_2];
            top_2 = top_2 - 3;
            return popVal;
        }
        if (stack == 3) {
            if (top_3 < 0) {
                throw new EmptyStackException();
            }
            popVal = arr[top_3];
            top_3 = top_3 - 3;
            return popVal;
        }
        throw new IllegalArgumentException("Invalid stack number passed: " + stack);
    }

    public int peek(int stack) {
        int top;
        if (stack == 1) {
            top = top_1;
        } else if (stack == 2) {
            top = top_2;
        } else if (stack == 3) {
            top = top_3;
        } else {
            throw new IllegalArgumentException("Invalid stack number passed: " + stack);
        }
        if (top < 0) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    @Override
    public String toString() {
        return "ThreeStacksUsingArray{" +
                "arr=" + Arrays.toString(arr) +
                ", top_1=" + top_1 +
                ", top_2=" + top_2 +
                ", top_3=" + top_3 +
                '}';
    }
}
