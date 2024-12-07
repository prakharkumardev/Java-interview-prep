package seq;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new EvenOddPrinter(0);
        Runnable r2 = new EvenOddPrinter(1);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Main thread");
    }
}
