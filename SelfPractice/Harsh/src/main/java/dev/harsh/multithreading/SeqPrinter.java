package dev.harsh.multithreading;

import lombok.SneakyThrows;

public class SeqPrinter {
    public int counter = 0;
    public static final int MAX_COUNTER = 3;
    public void printFoo() {
        for (int i = 0 ; i < MAX_COUNTER ; ++i) {
            synchronized (this) {
                while (counter != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                counter = 1;
                System.out.println("Foo");
                notifyAll();
            }
        }
    }


    public void printBar(){
        for (int i = 0 ; i < MAX_COUNTER ; ++i) {
            synchronized (this) {
                while (counter != 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                counter = 2;
                System.out.println("Bar");
                notifyAll();
            }
        }
    }

    public void printDo(){
        for (int i = 0 ; i < MAX_COUNTER ; ++i) {
            synchronized (this) {
                while (counter != 2) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                counter = 0;
                System.out.println("Do");
                notifyAll();
            }
        }
    }
}
