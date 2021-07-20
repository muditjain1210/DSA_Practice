package Stack;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ThreeStacksUsingArrayTest {

    @Test
    void testThreeStacksInOneArray() {
        ThreeStacksUsingArray st = new ThreeStacksUsingArray();
        assertThrows(EmptyStackException.class, () -> st.peek(1));
        assertThrows(EmptyStackException.class, () -> st.peek(2));
        assertThrows(EmptyStackException.class, () -> st.peek(3));
        assertThrows(IllegalArgumentException.class, () -> st.push(4, 3030));
        assertThrows(IllegalArgumentException.class, () -> st.pop(4));
        assertThrows(IllegalArgumentException.class, () -> st.peek(4));

        st.push(1, 100);
        st.push(1, 101);
        st.push(1, 102);

        st.push(2, 200);
        st.push(2, 201);
        st.push(2, 202);

        st.push(3, 300);
        st.push(3, 301);
        st.push(3, 302);

        assertEquals(102, st.peek(1));
        assertEquals(202, st.peek(2));
        assertEquals(302, st.peek(3));

        st.pop(1);
        assertEquals(101, st.peek(1));
        st.pop(1);
        st.pop(1);
        assertThrows(EmptyStackException.class, () -> st.pop(1));
        assertThrows(EmptyStackException.class, () -> st.pop(1));
        assertThrows(EmptyStackException.class, () -> st.pop(1));
        st.push(1, 420);
        assertEquals(420, st.peek(1));


        st.pop(2);
        assertEquals(201, st.peek(2));
        st.pop(2);
        st.pop(2);
        assertThrows(EmptyStackException.class, () -> st.pop(2));
        assertThrows(EmptyStackException.class, () -> st.pop(2));
        assertThrows(EmptyStackException.class, () -> st.pop(2));
        st.push(2, 786);
        assertEquals(786, st.peek(2));

        st.pop(3);
        assertEquals(301, st.peek(3));
        st.pop(3);
        st.pop(3);
        assertThrows(EmptyStackException.class, () -> st.pop(3));
        assertThrows(EmptyStackException.class, () -> st.pop(3));
        assertThrows(EmptyStackException.class, () -> st.pop(3));
        st.push(3, 9211);
        assertEquals(9211, st.peek(3));


        System.out.println(st);


    }

}