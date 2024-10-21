
import model.MyPipe;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyPipeTest {

    private MyPipe myPipe;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @Test
    public void testMyPipe(){

        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        myPipe = new MyPipe();

        String consoleOutput = outContent.toString();

        assertTrue(consoleOutput.contains("Hello!"));

        System.setOut(originalOut);
        System.out.println(consoleOutput);
    }
}
