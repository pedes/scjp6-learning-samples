package net.mgorski.scjp.book.s14concurency;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread {
    
    private static int idProgressive = 0;
    private int id = 0;
    
    private Semaphore sem = null;
    
    public MyThread(Semaphore s) {
        this.sem = s;
        this.id = (idProgressive++);
        System.out.println("Thread #" + id + " created.");
        start();
    }
    
    @Override
    public void run() {
        super.run();
        doTheJob();
    }
    
    void doTheJob(){
        try {
            sem.acquire();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("Thread " + id + ">>>");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + id + "<<<");
        sem.release();
    }
}
