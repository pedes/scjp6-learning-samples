package net.mgorski.scjp.book.s25threads;



public class WaitNotifyMain {
    
    public static void main(String[] args) {
        
        String input = "lowercase!";
        ProcessText processText = new ProcessText(input);
        
        Thread process = new Thread(processText);
        process.start();
        try {
            synchronized (process){             // must be synchronized over process
                process.wait();                   // throws illegalmonitorstate ...
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        System.out.println("waiting for input...");
        
    }
}


class ProcessText implements Runnable {

    String txt = "";
    public ProcessText(String input){
        this.txt = input;
        
        System.console();
        
    }
    
    @Override
    public void run() {
        System.out.println("processign...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Processed, response=" + this.txt.toUpperCase());
        synchronized (this){
            notify();
        }
    }
}
