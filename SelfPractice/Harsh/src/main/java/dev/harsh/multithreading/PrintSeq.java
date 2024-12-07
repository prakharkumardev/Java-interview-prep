package dev.harsh.multithreading;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PrintSeq implements Runnable{
    private static final Object lock = new Object();
    private final int threadId;
    private final static int maxCounter = 20;
    private static int counter = 0;
    @Override
    public void run() {
        while(counter <= maxCounter){
            synchronized (lock){
                while(threadId != counter % 3){
                    try{
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                //Double check locking
                if(counter <= maxCounter){
                    System.out.println("Thread " + threadId + ": " + counter);
                    counter++;
                }
                lock.notifyAll();

            }
        }
    }
}
