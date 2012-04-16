package net.mgorski.scjp.book.s25threads.waitnotify;

public class MasterOfWaiters {

    public static void main(String[] args) {

        // those thread must wait for action to finish
        Waiter w1 = new Waiter();
        Waiter w2 = new Waiter();
        w1.start();
        w2.start();

        System.out.println(Thread.currentThread().getName() + " will sleep ");
        try {
            // busy
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " will notify ");

        synchronized (System.out) {
            System.out.notifyAll();// notify() will release only one wait
        }
        System.out.println(Thread.currentThread().getName() + " will wait for joins");

        try {
            w1.join();
            w2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " done");
    }
}
