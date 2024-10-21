package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class ThreadSleeper implements Runnable {

    private static final Logger logger = LogManager.getLogger(ThreadSleeper.class);

    @Override
    public void run() {

        Random random = new Random();

        int sleepTime = random.nextInt(11);
        System.out.println("Thread will sleep for " + sleepTime + " seconds.");

        try {
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread has finished sleeping for " + sleepTime + " seconds.");
    }
}
