import model.ModelLogic;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ModelLogicTest {

    private ModelLogic modelLogic;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @Test
    public void testStartPingPongConsoleOutput() {

        modelLogic = new ModelLogic();

        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        modelLogic.startPingPong();

        String consoleOutput = outContent.toString();

        assertTrue(consoleOutput.contains("Thread-"));
        assertTrue(consoleOutput.contains("Final field value: 2000"));

        System.setOut(originalOut);
    }
}
