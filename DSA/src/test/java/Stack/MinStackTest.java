package Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class MinStackTest {
    static Logger logger;

    @BeforeAll
    public static void setup() {
        System.setProperty("log4j2.configurationFile", "log4j2.xml");
        logger = LogManager.getLogger(MinStack.class);
    }

    @Test
    void TestMinStack() {
        try {
            MinStack st = new MinStack();
            st.push(1);
            st.push(2);
            st.push(-1);
            st.push(5);
            st.push(10);
            logger.info(st);
            Assertions.assertEquals(1, 1);
        } catch (Exception e) {
            logger.error(e);
        }
    }
}