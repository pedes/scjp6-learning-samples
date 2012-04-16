package net.mgorski.scjp.book.s25threads;

public class WaitForJoin {
    
    public static void main(String[] args) {
        System.out.println("Start...");
        Thread t = new Thread(new Runnable() {
            
            @Override
            public void run() {
                System.out.println("executing thread");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("interrupt (sleep)");
                }
                System.out.println("Done!");
            }
        });
        t.setPriority(Thread.MAX_PRIORITY);
        t.setName("bla");
        t.start();
        
        
        Thread.yield();
        System.out.println("Wait for a thread...");
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted join()");
        }
        System.out.println("Thread done!");
        
        
        
        
    }

}
