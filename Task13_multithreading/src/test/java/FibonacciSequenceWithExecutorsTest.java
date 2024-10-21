import model.FibonacciSequenceWithExecutors;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FibonacciSequenceWithExecutorsTest {

    private FibonacciSequenceWithExecutors fibonacciSequenceWithExecutors;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @Test
    public void testFibonacciSequenceWithExecutorsConsoleOutput(){

        fibonacciSequenceWithExecutors = new FibonacciSequenceWithExecutors(14);

        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        fibonacciSequenceWithExecutors.run();

        String consoleOutput = outContent.toString();

        assertTrue(consoleOutput.contains("Start calculate fibonacci sequence with length: "));
        assertTrue(consoleOutput.contains("[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233]"));

        System.setOut(originalOut);
    }
}
