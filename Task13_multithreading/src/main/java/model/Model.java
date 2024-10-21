package model;

public interface Model {
    void startPingPong();                           //1
    void produceFibonacciSequence();                //2
    void produceFibonacciSequenceWithExecutors();   //3
    void produceFibonacciSequenceWithCallable();    //4
    void createSleeper(int numberThread);           //5
    void createCommunicatedPipes();                 //6
}
