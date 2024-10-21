package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PipedWriter;

public class TextGenerator extends Thread {

    private static final Logger logger = LogManager.getLogger(TextGenerator.class);

    private PipedWriter writer;

    public TextGenerator(PipedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void run() {

        logger.info("Parallel procecing started: " + Thread.currentThread().getName());
        try {
            writer.write("Hello!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error during writing to PipedWriter", e);
        }
        logger.info("Parallel processing finished: " + Thread.currentThread().getName());
    }
}
