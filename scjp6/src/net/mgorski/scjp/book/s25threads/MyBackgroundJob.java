package net.mgorski.scjp.book.s25threads;

public class MyBackgroundJob implements Runnable {

    private String name;
    public MyBackgroundJob(String name) {
        this.name = name;
        System.out.println("created "+name);
    }
    
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        
        
        System.out.println("started " +name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done" + name);
        
    }
    
    
}
