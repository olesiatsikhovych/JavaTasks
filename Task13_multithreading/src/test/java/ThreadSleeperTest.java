import model.ThreadSleeper;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThreadSleeperTest {

    private ThreadSleeper threadSleeper;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @Test
    public void testThreadSleeper(){

        threadSleeper = new ThreadSleeper();

        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Random random = new Random();
        random.setSeed(1);

        threadSleeper.run();

        String consoleOutput = outContent.toString();

        assertTrue(consoleOutput.contains("Thread will sleep for"));
        assertTrue(consoleOutput.contains("Thread has finished sleeping for "));

        System.setOut(originalOut);
    }

    @Test
    public void testThreadSleeper2(){

        threadSleeper = new ThreadSleeper();

        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        threadSleeper.run();

        String consoleOutput = outContent.toString();

        assertTrue(consoleOutput.contains("Thread will sleep for "));
        assertTrue(consoleOutput.contains("Thread has finished sleeping for "));

        System.setOut(originalOut);
    }
}
