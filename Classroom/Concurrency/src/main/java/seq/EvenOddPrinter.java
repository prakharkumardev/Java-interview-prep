package seq;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EvenOddPrinter implements Runnable{
    private static final Object lock = new Object();
    private final int threadId;
    private static final int LIMIT = 100;
    private static int currentNo = 0;
    @Override
    public void run() {
        while (currentNo <= LIMIT) {
            synchronized (lock){
                while (currentNo%2 != threadId){
                    try{
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                //DCL
                if(currentNo <= LIMIT){
                    System.out.println("Thread " + threadId + ": " + currentNo);
                    currentNo++;
                }
                lock.notifyAll();
            }

        }
    }
}
