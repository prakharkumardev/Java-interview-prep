package dev.harsh;

import lombok.SneakyThrows;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       FooBar fooBar = new FooBar(30);
       Thread t1 = new Thread(fooBar::foo);
       Thread t2 = new Thread(fooBar::bar);
       t1.start();
       t2.start();
       t1.join();
       t2.join();
    }
}