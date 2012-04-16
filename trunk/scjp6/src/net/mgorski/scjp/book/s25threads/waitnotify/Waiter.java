package net.mgorski.scjp.book.s25threads.waitnotify;

public class Waiter extends Thread {

    @Override
    public void run() {

        System.out.println(this.getName() + " waiting for signal");
        synchronized (System.out) {
            try {
                System.out.wait(5000);
            } catch (InterruptedException e) {
                System.out.println(this.getName() + " interrupted...");
            }
        }
        System.out.println(this.getName() + " got signal, executing...");
        try {
            // busy
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println(this.getName() + " got signal. Done!");
    }

}
