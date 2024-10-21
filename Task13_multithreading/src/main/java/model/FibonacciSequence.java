package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class FibonacciSequence extends Thread {

    private static final Logger logger = LogManager.getLogger(FibonacciSequence.class);

    ArrayList<Integer> fibonacciSequence = new ArrayList<>();

    int length;
    int number = 0;
    int nextNumber = 1;
    int sum = number + nextNumber;

    public FibonacciSequence(int length) {
        this.length = length;
    }

    @Override
    public void run() {
        System.out.println("Start calculate fibonacci sequence with length: " + length);

        logger.info("Thread started for Fibonacci calculation: " + Thread.currentThread().getName());

        try {
            for (int i = 0; i < length; i++){
                fibonacciSequence.add(number);
                number = nextNumber;
                nextNumber = sum;
                sum = number + nextNumber;
            }
            Thread.sleep(2000);
            System.out.println(fibonacciSequence);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Thread finished for Fibonacci calculation: " + Thread.currentThread().getName());
    }
}
