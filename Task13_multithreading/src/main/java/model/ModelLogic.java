package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ModelLogic implements Model {

    private static final Logger logger = LogManager.getLogger(ModelLogic.class);
    private volatile long aLong = 0;
    private static Object syncronize;

    @Override
    public void startPingPong(){

        syncronize = new Object();
        Thread thread1 = new Thread(() -> {synchronized (syncronize){
            logger.info("Thread 1 started: " + Thread.currentThread().getName());
            try {
                for (int i = 0; i < 1000; i++){
                    syncronize.notify();
                    aLong++;
                    System.out.println(Thread.currentThread().getName() + " " + aLong);
                    syncronize.wait();
                }
                logger.info("Thread 1 finished: " + Thread.currentThread().getName());
                syncronize.notify();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        });

        Thread thread2 = new Thread(() -> {synchronized (syncronize){
            logger.info("Thread 2 started: " + Thread.currentThread().getName());
            try {
                for (int i = 0; i < 1000; i++){
                    syncronize.notify();
                    aLong++;
                    System.out.println(Thread.currentThread().getName() + " " + aLong);
                    syncronize.wait();
                }
                logger.info("Thread 2 finished: " + Thread.currentThread().getName());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            logger.info("Thread 1 joined to main thread: Thread-" + Thread.currentThread().getName());
            thread2.join();
            logger.info("Thread 2 joined to main thread: Thread-" + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final field value: " + aLong);
    }

    @Override
    public void produceFibonacciSequence() {

        ArrayList<FibonacciSequence> fibonacciSequenceArrayList = new ArrayList<>();
        logger.info("Starting Fibonaacci sequence calculation in parallel. Thread-" + Thread.currentThread().getName());

        for (int i = 10; i < 15; i++) {
            FibonacciSequence fibonacciResult = new FibonacciSequence(i);
            fibonacciSequenceArrayList.add(fibonacciResult);
            fibonacciResult.start();
        }
        for (FibonacciSequence f : fibonacciSequenceArrayList){
            try {
                f.join();
                logger.info (f.getName() + " has finished. Thread-" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logger.info("All Fibonacci sequence threads have completed. Thread-" + Thread.currentThread().getName());
    }

    @Override
    public void produceFibonacciSequenceWithExecutors() {

        ExecutorService service = Executors.newFixedThreadPool(5);
        logger.info("Starting Fibonacci sequence calculation with Executors. Thread-" + Thread.currentThread().getName());

        for (int i = 10; i < 15; i++){
            Runnable runnable = new FibonacciSequenceWithExecutors(i);
            service.execute(runnable);
        }

        service.shutdown();

        logger.info("All Fibonacci executor threads have completed. Thread-" + Thread.currentThread().getName());
    }

    @Override
    public void produceFibonacciSequenceWithCallable() {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ArrayList<Future> futureResult = new ArrayList<>();
        logger.info("Starting Fibonacci sequence calculation with Callable. Thread-" + Thread.currentThread().getName());

        for (int i = 10; i < 15; i++){
            Callable<ArrayList<Integer>> task = new FibonacciSequenceWithCallable(i);
            Future<ArrayList<Integer>> future = executorService.submit(task);
            futureResult.add(future);
        }
        try {
            for (Future<ArrayList<Integer>> future : futureResult){
                ArrayList<Integer> result = future.get();
                System.out.println(result);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        logger.info("All Callable tasks for Fibonacci sequence have completed. Thread-" + Thread.currentThread().getName());
    }

    @Override
    public void createSleeper(int numberThread) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < numberThread; i++) {
            Runnable runnable = new ThreadSleeper();
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }

    @Override
    public void createCommunicatedPipes() {
        new MyPipe();
    }
}
