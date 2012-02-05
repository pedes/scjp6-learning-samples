package net.mgorski.scjp.book.s13sync;

public class IdFetcher extends Thread {
    
    private int threadId;
    
    public IdFetcher(int id) {
        this.threadId = id;
        System.out.println("initialized thread #"+ threadId);
    }
    
    @Override
    public void run() {
        int id = IdHolder.getProgressiveId();
        System.out.println("#"+threadId+" got id " + id );
    }
    
}
