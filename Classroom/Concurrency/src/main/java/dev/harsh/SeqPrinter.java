package dev.harsh;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SeqPrinter implements Runnable{
    private static final Object lock = new Object();
    private static int counter = 0;
    private final int threadId;

    @Override
    public void run(){
        while(counter <= 20){
            synchronized(lock){
                while(counter % 3 != threadId){
                    try{
                        lock.wait();
                        System.out.println("Waiting" + Thread.currentThread().getName());
                    }
                    catch(InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }

                if(counter <= 20){
                    System.out.println("Thread " + threadId + ": " + counter++);
                }
                lock.notifyAll();
            }
        }
    }
}
