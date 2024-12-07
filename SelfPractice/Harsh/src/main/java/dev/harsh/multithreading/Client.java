package dev.harsh.multithreading;

import lombok.SneakyThrows;

public class Client{
    public static void main(String[] args) throws InterruptedException {
        SeqPrinter printer = new SeqPrinter();
        Thread t1 = new Thread(printer::printFoo);
        Thread t2 = new Thread(printer::printBar);
        Thread t3 = new Thread(printer::printDo);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Main Thread");

    }
}
