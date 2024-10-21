package model;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyPipe {

    private static final Logger logger = LogManager.getLogger(MyPipe.class);


    public MyPipe() {

        try {
            PipedWriter writer = new PipedWriter();
            PipedReader reader = new PipedReader(writer);

            TextGenerator generator = new TextGenerator(writer);
            logger.info("Starting parallel processing in TextGenerator: Thread " + Thread.currentThread().getName());

            generator.start();

            int data;
            while ((data = reader.read()) != -1){
                System.out.print((char) data);
            }
            System.out.println();
            logger.info("Reading finished, waiting for thread to join: Thread " + Thread.currentThread().getName());
            try {
                generator.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("Parallel processing finished, thread joined to main: Thread " + Thread.currentThread().getName());

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
