package net.mgorski.scjp.performance;

import java.util.LinkedList;
import java.util.List;


public class OutOfMem {

    public OutOfMem() {
        new OutOfMem();
    }

    public static void main(String[] args) {
        try {
            new OutOfMem();
        } catch (Throwable t) {
            System.out.println(t);
        }

        String string = "";
        List<String> strings = new LinkedList<String>();
        try{ 
        while(true){
            string += "X";
            strings.add(string);
        }
        } catch(Throwable t){
            t.printStackTrace();
            System.out.println("release mem");
            strings.clear();
            string = "";
        }
        
        System.out.println("mem released");
    }

}
