package net.mgorski.scjp.book.s20flowexceptions;

import java.util.HashMap;

public class StackOverflow {
    public static void main(String[] args) {
        StackTester st = new StackTester();
        st.test();
    }
    
    
}


class StackTester {
    
    static int oCount = 0;
    void test(){
        
        HashMap<String, String> hm = new HashMap<String, String>(1024);
        
//        long totalMemory = Runtime.getRuntime().totalMemory()/ (1024);
        long freeMemory = Runtime.getRuntime().freeMemory()/ (1024);
//        long maxMemory = Runtime.getRuntime().maxMemory()/ (1024);
        
//        System.out.println("procesors="+Runtime.getRuntime().availableProcessors());
//        System.out.println("Objects ("+(++oCount)+"), free="+freeMemory+" max="+maxMemory +" total="+ totalMemory);
        System.out.println("Objects ("+(++oCount)+"), free="+freeMemory+" kb");
        
        
        while(oCount<3490){
            test();
        }
    }
    
}
