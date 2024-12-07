package dev.harsh.virtual_thread;

public class VirtualThreadsBasics {
    public static class CreateVirtualThread {
        public static void main(String[] args) {
            Thread thread = Thread
                    .ofVirtual()
                    .name("VirtualThread")
                    .unstarted(()->{
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(Thread.currentThread().getName());
            });

            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Main thread");


        }
    }

    public static class CreateManyVirtualThreads {
        public static void main(String[] args) {
            for(int i = 0 ; i < 10000000 ; ++i){
                int k = i;
                Thread.ofVirtual().start(()-> System.out.println(k));
            }

        }
    }
}
