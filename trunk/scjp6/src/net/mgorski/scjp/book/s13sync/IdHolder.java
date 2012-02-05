package net.mgorski.scjp.book.s13sync;

public class IdHolder {
    
    private static int id;
    
    static {
        id = 0;
    };
    
    public static synchronized int getProgressiveId(){
        ++id;
        System.out.println(">>");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("<<");
        return id;
    };
}
