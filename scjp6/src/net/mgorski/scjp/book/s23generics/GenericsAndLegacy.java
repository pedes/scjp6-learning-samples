package net.mgorski.scjp.book.s23generics;

import java.util.LinkedList;
import java.util.List;

public class GenericsAndLegacy {

    public static void main(String[] args) {

        List<Integer> intList = new LinkedList<Integer>();
        for(int i=0; i<10; i++ ) { intList.add(i); }
        
        System.out.println(intList.toString());
        
        LegacyCode lc = new LegacyCode();
        lc.read(intList);
        System.out.println(intList.toString());
        
        lc.readAndModifyWithInts(intList);
        System.out.println(intList.toString());
        
        lc.readAndModifyUnsafe(intList);
        System.out.println(intList.toString());
        
        int index=0;
        try {
            for (Integer integer : intList) {
                System.out.println("INTEGER=" + integer);
                index++;
            }
        } catch(Exception e){
            System.out.println("exeception catchec at index " + index + ", " + e.getMessage());// catched @ 11
        }
        
        
        for (Object object : intList) {
            if(object instanceof Integer){
                System.out.println("Instance (Int)=" + ((Integer)object));
            } else {
                System.out.println("Instance (Unknown) =" + object);
            }
            
            index++;
        }
        
        

    }

    static class LegacyCode {
        public void read(List l) {
            System.out.println("read = " + ((Integer)l.get(0)));
        }

        public void readAndModifyWithInts(List l) {
            System.out.println("readAndModify= " + ((Integer)l.get(0)));
            l.add(new Integer(10)); // warning, because of modify

        }

        public void readAndModifyUnsafe(List l) {
            System.out.println("read AndAddString = " + ((Integer)l.get(0)));
            l.add("dupa");// warning, because of modify
        }
    }
}
