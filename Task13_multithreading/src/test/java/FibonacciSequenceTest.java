import model.FibonacciSequence;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FibonacciSequenceTest {

    private FibonacciSequence fibonacciSequence;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @Test
    public void testFibonacciSequenceConsoleOutput(){

        fibonacciSequence = new FibonacciSequence(10);

        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        fibonacciSequence.run();

        String consoleOutput = outContent.toString();

       assertTrue(consoleOutput.contains("Start calculate fibonacci sequence with length"));
       assertTrue(consoleOutput.contains("[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"));

        System.setOut(originalOut);
    }
}
