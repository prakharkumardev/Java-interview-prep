package dev.harsh.create_thread;

public class ThreadCreation {
    //Directly running a thread
    public static class RunThread{
        public static void main(String[] args) {
            Thread thread = new Thread();
            thread.start();
            Thread thread2 = new Thread("Thread-1");
            thread2.start();
        }
    }

    //Creating a thread extension
    public static class ThreadExtension{
        public static class MyThread extends Thread{
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Current thread is " + Thread.currentThread().getName() + " is Daemon: " + Thread.currentThread().isDaemon());
            }
        }

        public static void main(String[] args) {
            Thread thread = new MyThread();
            Thread thread1 = new Thread(){
                @Override
                public void run(){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Current thread is " + Thread.currentThread().getName() + " is Daemon: " + Thread.currentThread().isDaemon());

                }
            };
            thread.setName("My Thread 1");
            thread.setDaemon(true);
            thread.start();
            thread1.start();
            System.out.println("Main thread is " + Thread.currentThread().getName());
        }
    }

    //Creating through runnable
    public static class ThroughRunnable{
        public static class MyThread implements Runnable{
            @Override
            public void run() {
                System.out.println("Current thread is " + Thread.currentThread().getName() + " is Daemon: " + Thread.currentThread().isDaemon());
            }

            public static void main(String[] args) {
                Runnable runnable = new MyThread();
                Thread thread = new Thread(runnable);
                thread.start();
                System.out.println("Main thread is " + Thread.currentThread().getName());

            }
        }
        public static class UsingAnonmyous{
            public static void main(String[] args) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Current thread is " + Thread.currentThread().getName() + " is Daemon: " + Thread.currentThread().isDaemon());
                    }
                };
                Thread thread = new Thread(runnable, "My Thread 1");
                thread.start();
                System.out.println("Main thread is " + Thread.currentThread().getName());
            }
        }

        public static class UsingLambda{
            public static void main(String[] args) {
                Runnable runnable = () -> System.out.println("Current thread is " + Thread.currentThread().getName() + " is Daemon: " + Thread.currentThread().isDaemon());
                Thread thread = new Thread(runnable, "My Thread 1");
                thread.start();
                System.out.println("Main thread is " + Thread.currentThread().getName());
            }
        }

    }

    //Stopping a thread
    public static class ThreadStopping{
        public static class ThreadStoppingTask implements Runnable{
            private boolean isStopped = false;
            public void doStop(){
                System.out.println("Do stop is invoked " + Thread.currentThread().getName());
                this.isStopped = true;
            }
            public boolean getStop(){
                return this.isStopped;
            }
            @Override
            public void run() {
                while (!this.getStop()){
                }
                System.out.println("Computation stopped");
            }
        }
        public static class Client{
            public static void main(String[] args) {
                ThreadStoppingTask runnable = new ThreadStoppingTask();
                Thread thread = new Thread(runnable);
                thread.start();
                System.out.println("Main thread is " + Thread.currentThread().getName());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runnable.doStop();
            }
        }
    }
}
