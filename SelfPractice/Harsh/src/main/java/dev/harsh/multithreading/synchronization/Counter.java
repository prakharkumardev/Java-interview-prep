package dev.harsh.multithreading.synchronization;

public class Counter {
    private int count = 0;
    public synchronized void increment() {
        this.count += 1;
        decrement();
        addSyncBlock();
    }
    public synchronized void decrement() {
        this.count -= 1;
    }
    public int getCount(){
        return this.count;
    }

    public void addSyncBlock(){
        synchronized (this){
            this.count++;
        }
    }
}
