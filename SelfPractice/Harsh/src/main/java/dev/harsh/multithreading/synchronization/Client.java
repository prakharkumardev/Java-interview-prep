package dev.harsh.multithreading.synchronization;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread [] threads = new Thread[1500];
        for(int i = 0 ; i < 500 ; ++i){
            threads[i] = new Thread(counter::increment);
        }
        for(int i = 500 ; i < 1000 ; ++i){
            threads[i] = new Thread(counter::decrement);
        }
        for(int i = 1000 ; i < 1500 ; ++i){
            threads[i] = new Thread(counter::addSyncBlock);
        }
        for(Thread thread : threads){
            thread.start();
        }
        for(Thread thread : threads){
            thread.join();
        }
        System.out.println(counter.getCount());
        System.out.println(Thread.currentThread().getName());
    }
}
