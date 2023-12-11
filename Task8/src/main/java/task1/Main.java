package task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static Logger logger = LogManager.getLogger(Main.class);
    private static final String filePath = "./src/main/java/task1/result_task1.txt";

    public static void main(String[] args) {
        try(FileWriter fileWriter = new FileWriter(filePath)){
            Addable addable = (one, two, three) -> Math.max(one, Math.max(two, three));
            fileWriter.write(addable.add(10, 20, 30) + " - Max result" + "\n");
            logger.info("Max result is written to file");
            addable = ((one, two, three) -> (one + two + three) / 3);
            fileWriter.write(addable.add(10, 20, 30) + " - Arifmetical mean" + "\n");
            logger.info("Arifmetical mean is written to file");
        } catch (IOException e) {
            logger.info("An error occurred while writing to the file");
            e.printStackTrace();
        }
    }
}
