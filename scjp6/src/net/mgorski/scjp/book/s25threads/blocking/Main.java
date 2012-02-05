package net.mgorski.scjp.book.s25threads.blocking;

import static net.mgorski.scjp.book.s25threads.blocking.Semaphore.semaphore;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        new Thread(new InputThread()).start();
        
        int i = 0;
        while(i++<5){
            new Thread(new ReaderThread(""+i)).start();
        }

    }
}

class ReaderThread implements Runnable {
    private String name;
    public ReaderThread(String name){
        this.name = name;
    }

    private void execute() throws InterruptedException {
        
        int wait = new Random().nextInt(15);

        synchronized (semaphore) {
            System.out.println(name + " will wiat max " + wait +" sec.");
            semaphore.wait(wait*1000);
            System.out.println(name + "released!");
        }

    }

    @Override
    public void run() {
        try {
            execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}



class InputThread implements Runnable {

    @Override
    public void run() {
        
        int wait = new Random().nextInt(5);
        System.out.println("Wait for input " + wait + " sec.");
        
        try {
            Thread.sleep(wait*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Unlocking...");
        synchronized (semaphore) {
            //Semaphore.semaphore.notifyAll();
            semaphore.notify();   // will wait for the thread which first taken the lock
            System.out.println("this should show before semaphore unlock ( inside synchronized )");
        }
        
        
       
        
    }
    
    
    
}
