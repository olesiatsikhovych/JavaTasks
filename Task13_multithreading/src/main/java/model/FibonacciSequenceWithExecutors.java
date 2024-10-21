package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class FibonacciSequenceWithExecutors implements Runnable{

    private static final Logger logger = LogManager.getLogger(FibonacciSequenceWithExecutors.class);

    ArrayList<Integer> fibonacciSequence = new ArrayList<>();

    int length;
    int number = 0;
    int nextNumber = 1;
    int sum = number + nextNumber;

    public FibonacciSequenceWithExecutors(int length) {
        this.length = length;
    }

    @Override
    public void run() {
        System.out.println("Start calculate fibonacci sequence with length: " + length);

        logger.info("Thread started for Fibonacci calculation with Executor: Thread-" + Thread.currentThread().getName());

        for (int i = 0; i < length; i++){
            fibonacciSequence.add(number);
            number = nextNumber;
            nextNumber = sum;
            sum = number + nextNumber;
        }
        try {
            Thread.sleep(2000);
            System.out.println(fibonacciSequence);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Thread finished for Fibonacci calculation with Executor: Thread-" + Thread.currentThread().getName());
    }
}
