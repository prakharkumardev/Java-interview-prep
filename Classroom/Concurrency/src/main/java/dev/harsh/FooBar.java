package dev.harsh;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class FooBar {
    private final int n;
    private static boolean state = false;
    @SneakyThrows
    public void foo(){
        for(int i = 0; i < n; i++) {
            synchronized (this) {
                System.out.println("Foo");
                notifyAll();
            }
        }
    }
    public void bar(){
        for(int i = 0; i < n; i++) {
            synchronized (this) {
                try {
                    wait();
                    System.out.println("Test");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Bar");
            }
        }
    }

}
