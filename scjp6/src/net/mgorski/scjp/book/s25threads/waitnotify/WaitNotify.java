package net.mgorski.scjp.book.s25threads.waitnotify;

public class WaitNotify {
    public static void main(String[] args) {

        WaitNotify wn = new WaitNotify();
        Thread t = new Thread(wn.new Master());
        t.start();

    }

    class Master implements Runnable {

        Slave slave = new Slave();

        @Override
        public void run() {

            System.out.println("Master run");

            Thread slaveThread = new Thread(slave);
            slaveThread.start();

            synchronized (slave) {
                try {
                    slave.wait();
                    System.out.println("Master release");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            System.out.println("Master done!");

        }

    }

    class Slave implements Runnable {
        @Override
        public void run() {
            System.out.println("Slave start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Slave 1");
            synchronized (this) {
                notify();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Slave done");
        }
    }

}
