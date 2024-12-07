package dev.harsh;

public class OddEvenPrinter implements Runnable {
    private static int currentNumber = 1;
    private static final int maxNumber = 30;
    private final boolean isEvenThread;  // Flag to differentiate odd/even thread
    private static final Object lock = new Object(); // shared lock object

    public OddEvenPrinter(boolean isEvenThread) {
        this.isEvenThread = isEvenThread;
    }

    private void printNumber() {
        while (currentNumber <= maxNumber) {
            synchronized (lock) {
                // Check if it's the turn of this thread (odd or even)
                while ((currentNumber % 2 == 0) != isEvenThread) {
                    try {
                        lock.wait();  // Wait if it's not this thread's turn
                        System.out.println("Waiting");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // If still within the limit, print the current number
                if (currentNumber <= maxNumber) {
                    System.out.println(Thread.currentThread().getName() + " prints: " + currentNumber++);
                }
                // Notify all threads to wake up (so the other thread can proceed)
                lock.notifyAll();
            }
        }
    }

    // Implementing the run() method from Runnable
    @Override
    public void run() {
        printNumber();  // Each thread will call the printNumber method
    }
}