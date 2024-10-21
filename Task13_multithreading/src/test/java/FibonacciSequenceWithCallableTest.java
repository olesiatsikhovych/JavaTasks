import model.FibonacciSequenceWithCallable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciSequenceWithCallableTest {

    private FibonacciSequenceWithCallable fibonacciSequenceWithCallable;

    @Test
    public void testFibonacciSequenceWithCallableConsoleOutput(){

        fibonacciSequenceWithCallable = new FibonacciSequenceWithCallable(3);

        List<Integer> arrayList = new ArrayList<>();

        try {
           arrayList = fibonacciSequenceWithCallable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Integer[] array = {0, 1, 1};

        List<Integer> expectedArrayList = Arrays.asList(array);

        assertEquals(expectedArrayList , arrayList);
    }
}
