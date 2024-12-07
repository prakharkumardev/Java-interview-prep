package dev.harsh;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FooBarDo {
    private final int n;
    private static int state = 0;
    public void foo(){
        for(int i = 0; i < n; i++) {
            synchronized (this) {
                while (state != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                state = (state + 1) % 3;
                System.out.println("Foo");
                notifyAll();
            }
        }
    }
    public void bar(){
        for(int i = 0; i < n; i++) {
            synchronized (this) {
                while (state != 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Bar");
                state = (state + 1) % 3;
                notifyAll();
            }
        }
    }

    public void doPrint(){
        for(int i = 0; i < n; i++) {
            synchronized (this) {
                while (state != 2) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Do");
                state = (state + 1) % 3;
                notifyAll();
            }
        }
    }
}
