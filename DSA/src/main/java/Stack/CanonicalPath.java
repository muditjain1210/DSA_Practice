package Stack;

import java.util.Stack;

public class CanonicalPath {
    private static void handleDot(int dotCount, Stack<Character> st) {
        if (dotCount == 2) {
            st.pop();
            st.pop();
            if (st.size() != 1) {
                st.pop();
                char c = st.peek();
                while (c != '/') {
                    st.pop();
                    c = st.peek();
                }
            }
        }
        if (dotCount == 1) {
            st.pop();
        }
    }

    public String simplifyPath(String path) {
        Stack<Character> st = new Stack<>();
        char[] chars = path.toCharArray();
        st.push(chars[0]);
        int dotCount = 0;
        for (int i = 1; i < chars.length; i++) {
            char top = st.peek();
            char curr = chars[i];

            if ((top == '.' && curr == '/' && dotCount > 0)) {
                handleDot(dotCount, st);
                dotCount = 0;
                continue;
            }

            if (curr != '.' && curr != '/') {
                st.push(curr);
                dotCount = 0;
                continue;
            }

            if (top == '/' && curr == '/') {
                continue;
            }

            if (top == '/' || dotCount > 0) {
                st.push(curr);
                dotCount++;
                continue;
            }
            st.push(curr);
        }
        handleDot(dotCount, st);
        if (st.peek() == '/' && st.size() != 1) {
            st.pop();
        }
        char[] resultArray = new char[st.size()];
        int i = resultArray.length - 1;
        while (!st.isEmpty()) {
            resultArray[i] = st.pop();
            i--;
        }
        System.out.println(new String(resultArray));
        return new String(resultArray);
    }
}
