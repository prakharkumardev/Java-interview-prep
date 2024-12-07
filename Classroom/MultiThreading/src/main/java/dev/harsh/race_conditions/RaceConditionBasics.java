package dev.harsh.race_conditions;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class RaceConditionBasics {
    public static class ReadModifyWrite{
        private int counter = 0;
        private final Object lock = new Object();
        public void increaseCounter(){
            synchronized (lock){
                counter++; //rmw2 rmw
            }
        }
        public int getCounter(){
            return counter;
        }
        public static void main(String[] args) {
            ReadModifyWrite rmw = new ReadModifyWrite();
            List<Thread> threads = new ArrayList<>();
            for(int i = 0; i < 2000; i++){
                threads.add(Thread.ofPlatform().start(rmw::increaseCounter));
            }

            try {
                threads.forEach((thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(rmw.getCounter());
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static class CheckThenAct{
        private final Set<Integer> set = new HashSet<>(Set.of(1,2,3,4,5,6,7,8,9));
        public void remove(int key) throws InterruptedException {
            synchronized (this) {
                if (set.contains(key)) {
                    Thread.sleep(1000);
                    set.remove(key);
                    System.out.println("Inside remove");
                }
            }
        }

        public static void main(String[] args) {
            CheckThenAct ct = new CheckThenAct();
            List<Thread> threads = new ArrayList<>();
            for(int i = 1; i <= 1000; i++){
                threads.add(Thread.ofPlatform().start(()-> {
                    try {
                        ct.remove(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }));
            }
            try {
                threads.forEach((thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());

        }
    }

    @Getter
    public static class SyncBlockIncr{
        public int a;
        public int b;
        private final Object lock1 = new Object();
        private final Object lock2 = new Object();
        public static int sharedCounter = 0;
        public static final Object sharedLock1 = new Object();
        public void sum(int a, int b){
            synchronized ("abc"){
                this.a += a;
            }
            synchronized (lock2){
                this.b += b;
            }
            synchronized (SyncBlockIncr.class){
                sharedCounter++;
            }
            synchronized (SyncBlockIncr.class){
                sharedCounter++;
            }
        }

        public static void main(String[] args) {
            SyncBlockIncr syncBlockIncr = new SyncBlockIncr();
            List<Thread> threads = new ArrayList<>();
            IntStream.range(0,100000).forEach((_)->{
                threads.add(Thread.ofVirtual().start(()->{
                    syncBlockIncr.sum(1,1);
                    synchronized ("abc"){
                        syncBlockIncr.a++;
                    }
                }));
            });
            threads.forEach((thread -> {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));

            System.out.println(syncBlockIncr.getA());
            System.out.println(syncBlockIncr.getB());
            System.out.println(SyncBlockIncr.sharedCounter);
            System.out.println(Thread.currentThread().getName());

        }
    }


}
