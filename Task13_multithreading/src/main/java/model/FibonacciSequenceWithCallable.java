package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class FibonacciSequenceWithCallable implements Callable {

    private static final Logger logger = LogManager.getLogger(FibonacciSequenceWithCallable.class);

    ArrayList<Integer> arrayList = new ArrayList<>();

    int length;
    int number = 0;
    int nextNumber = 1;
    int sum = number + nextNumber;

    public FibonacciSequenceWithCallable(int length) {
        this.length = length;
    }

    @Override
    public  ArrayList<Integer> call() throws Exception {
        System.out.println("Start calculate fibonacci sequence with length: " + length);
        logger.info("Thread started for Fibonacci calculation with Callable: Thread-" + Thread.currentThread().getName());

        for (int i = 0; i < length; i++){
            arrayList.add(number);
            number = nextNumber;
            nextNumber = sum;
            sum = number + nextNumber;
        }
        logger.info("Thread finished for Fibonacci calculation with Callable: Thread-" + Thread.currentThread().getName());
        return arrayList;
    }
}
