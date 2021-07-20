package Stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This a custom stack with extra method getMin() which will get minimum
 * value present in the stack. All the methods have O(1) time complexity..
 */

class MinStackTest {

    @DisplayName("test min stack")
    @Test
    void TestMinStack() {
        try {
            MinStack st = new MinStack();
            assertThrows(EmptyStackException.class, st::getMin);
            assertThrows(EmptyStackException.class, st::pop);
            assertThrows(EmptyStackException.class, st::peek);

            st.push(1);
            st.push(2);
            st.push(-1);
            st.push(5);
            st.push(10);

            System.out.println(st);
            assertEquals(-1, st.getMin());

            st.pop();
            st.pop();
            st.pop();
            System.out.println(st);
            assertEquals(1, st.getMin());

            st.push(1);
            System.out.println(st);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}