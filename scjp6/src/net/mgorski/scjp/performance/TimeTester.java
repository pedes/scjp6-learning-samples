package net.mgorski.scjp.performance;

import java.util.Date;

public class TimeTester {
    
    private final static int MB = 1048576; // bytes
    
    Date d = null;
    String task;
    
    public TimeTester(String task, boolean printConstruct) {
        this.task = task;
        d = new Date();
        if(printConstruct){
            System.out.println("["+task+"] started, "+freeMemMb());
        }
    }
    
    public long time() {
        final long time = new Date().getTime() - d.getTime();
        System.out.println("["+task+"] [TIME: " + (time/1000D) +" sek] , "+freeMemMb());
        return time;
    }
    
    
    private String freeMemMb(){
        double memTotal = Runtime.getRuntime().maxMemory();
        double memUsed = Math.abs((Runtime.getRuntime().freeMemory() - Runtime.getRuntime().maxMemory()));
        return "[MEM " + (memUsed/MB) + " of " + memTotal/MB + " Mb]";
    }
}
