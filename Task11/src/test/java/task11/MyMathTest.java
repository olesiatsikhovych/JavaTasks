package task11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathTest {
     static MyMath math;

    @BeforeAll
    public static void init() {
        math = new MyMath();
    }

    @Test
    void testSum(){
        int result = math.sum(10, 12);
        assertEquals(22, result);
    }

    @Test
    void testMinus(){
        int result = math.minus(12, 10);
        assertEquals(2, result);
    }
}
