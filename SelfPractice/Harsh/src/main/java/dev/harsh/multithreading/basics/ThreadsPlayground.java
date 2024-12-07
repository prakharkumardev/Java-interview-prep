package dev.harsh.multithreading.basics;

public class ThreadsPlayground {
    public static class CreateAndStartThread{
        public static void main(String[] args) {
            Thread thread = new Thread(); //Why default constructor
            thread.start();
            Thread thread2 = Thread.ofPlatform().start(()-> System.out.println("Task"));
        }
    }

    public static class createThreadUsingExtension{
        public static class MyThread extends Thread{
            @Override
            public void run() {
                System.out.println("Thread started  " + Thread.currentThread().getName());
            }
        }

        public static void main(String[] args) {
            Thread thread = new MyThread();
            thread.setName("My thread1");
            thread.start();
        }
    }

    public static class CreatingThreadUsingRunnable{
        public static class MyRunnable implements Runnable{
            @Override
            public void run() {
                System.out.println("MyRunnable started  " + Thread.currentThread().getName());
            }
        }

        public static void main(String[] args) {
            Runnable runnable = new MyRunnable();
            Thread thread = new Thread(runnable,"My Runnable");
            thread.start();
        }
    }

    public static class CreatingThreadUsingAnonymousClass{
        public static void main(String[] args) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread started  " + Thread.currentThread().getName());
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();

        }
    }

    public static class CreatingThreadUsingLambdas{
        public static void main(String[] args) {
            Runnable runnable = ()-> System.out.println(Thread.currentThread().getName());
            Thread thread = new Thread(runnable);
            //Thread.currentThread gives ref of the caller thread
            System.out.println(Thread.currentThread());
            thread.start();
        }
    }

    public static class StopThread{
        public static class StopThreadRunnable implements Runnable{
            private boolean isStopped;
            public synchronized void stop(){
                this.isStopped = true;
            }
            public synchronized boolean keepRunning(){
                return !isStopped;
            }
            @Override
            public void run() {
                while(keepRunning()){
                    System.out.println("Running");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(".....");
                }
                System.out.println("Stopping the thread");
            }
        }
        public static void main(String[] args) {
            StopThreadRunnable runnable = new StopThreadRunnable();
            Thread thread = new Thread(runnable,"Start Stop Thread");
            thread.start();
            try{
                Thread.sleep(2000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            runnable.stop();
            System.out.println("Main thread " + Thread.currentThread().getName());
        }
    }

    public static class DaemonThreads{
        public static void main(String[] args) {
            Thread thread = new Thread(()->{
                while(true){
                    System.out.println("Hello World!");
                }
            });
            thread.setDaemon(true);
            thread.start();
//            try{
//                thread.join();
//            }
//            catch (InterruptedException e){
//                throw new RuntimeException(e);
//            }
            System.out.println("Main thread " + Thread.currentThread().getName());
        }
    }

}
