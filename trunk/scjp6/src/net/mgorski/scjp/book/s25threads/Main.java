package net.mgorski.scjp.book.s25threads;

public class Main {
    
    public static void main(String[] args) {
        
        
        System.out.println("Normal execution");
        for(int i=0; i<5; i++){
            String name = "Thread -" + i;
            MyBackgroundJob bj = new MyBackgroundJob(name);
            Thread thread = new Thread(bj, name);
            thread.start();
        }
 
        for(int i=5; i<8; i++){
            String name = "Deamon" + i;
            MyBackgroundJob bj = new MyBackgroundJob(name);
            Thread thread = new Thread(bj, name);
            thread.setDaemon(true);
            thread.setPriority(i);
            thread.start();
        }
        
        System.out.println("Normal execution next step...");
        
        
        
        Thread d = new Thread(new LongDaemon());
        d.start();
    }
}
