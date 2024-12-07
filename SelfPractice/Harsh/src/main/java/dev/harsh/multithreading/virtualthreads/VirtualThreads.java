package dev.harsh.multithreading.virtualthreads;

public class VirtualThreads {
    public static class CreatingVirtualThread{
        public static void main(String[] args) throws InterruptedException {
            // Create a virtual thread
            Thread virtualThread = Thread.ofVirtual()
                    .name("Virtual Thread")
                    .start(() -> {
                System.out.println("Running in virtual thread: " + Thread.currentThread().getName());
            });

            // Wait for the virtual thread to finish
            virtualThread.join();

            // Get the name of the virtual thread
            System.out.println("Virtual Thread Name: " + virtualThread.getName());
        }
    }
    public static class CreatingManyVirtualThreads{
        public static void main(String[] args) throws InterruptedException {
            int i = 100_000;
            int j = 1______2;
            //Platform thread
//            Thread thread = Thread.ofPlatform().start(()->{
//                System.out.println("Hello World!");
//            });
            while (--i != 0){
                final int k = i;
                Thread.ofVirtual().name("Virtual Thread").start(() -> {
                    System.out.println("Running in virtual thread: " + Thread.currentThread().getName() + "  " + k);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            System.out.println("Main Thread Name: " + Thread.currentThread().getName());
        }
    }
}
