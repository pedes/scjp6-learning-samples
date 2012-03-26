package net.mgorski.scjp.test2;

public class Terrain extends Thread {
    public static void main(String args[]) throws Exception {
        Run1 r = new Run2();
        Run2 r2 = (Run2) r;
        Thread thread = new Thread(r);
        Thread thread2 = new Thread(r2);
        thread.start();
        thread2.start();
    }
}

class Run1 implements Runnable {
    int x;

    public synchronized void run() {
        try {
            System.out.println(++x);
        } finally {
            System.out.println(++x);
        }
    }
    
    private static synchronized void a(){
     
        synchronized (System.out.append("c")){
            
        };
    }
    
    
    
    
    
}

class Run2 extends Run1 {
}