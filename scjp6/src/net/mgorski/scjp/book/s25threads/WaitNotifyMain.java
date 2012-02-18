package net.mgorski.scjp.book.s25threads;

public class WaitNotifyMain {

    public static void main(String[] args) {

        String input = "lowercase!";
        ProcessText processText = new ProcessText(input);

        Thread process = new Thread(processText);
        process.start();
        try {
            synchronized (process) { // must be synchronized over process
                process.wait(); // throws illegalmonitorstate ...
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("waiting for input...");

        Runnable runnable = new ThreadExt();
        Thread thread = new Thread(runnable);
        thread.start();
        // thread.start();//illegal state exception
        new Thread(runnable).start();

        Thread.yield();

    }
}

class ProcessText implements Runnable {

    String txt = "";

    public ProcessText(String input) {
        this.txt = input;

        System.console();

    }

    @Override
    public void run() {
        System.out.println("processign...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Processed, response=" + this.txt.toUpperCase());
        synchronized (this) {
            notify();
        }
        synchronized (Class.class) {
            synchronized (Object.class) {
                synchronized (new Integer(1)) {

                }

            }
        }

    }

}

class ThreadExt extends Thread {

    @Override
    public void run() {
        System.out.println("pre-run");
        super.run();
        System.out.println("post-run");
    }

    @Override
    public synchronized void start() {
        System.out.println("pre-start");
        super.start();
        System.out.println("post-start");
    }
}