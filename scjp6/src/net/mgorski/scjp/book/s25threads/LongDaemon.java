package net.mgorski.scjp.book.s25threads;

public class LongDaemon implements Runnable {
    
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
