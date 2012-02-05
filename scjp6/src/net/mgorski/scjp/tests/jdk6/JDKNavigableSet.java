package net.mgorski.scjp.tests.jdk6;

import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;


public class JDKNavigableSet {
    
    /**
     * 
     * NavigableSet - implementations : TreeSet, ConcurrentSkipListSet
     * 
     * 
     * 
     */
    

    private static ConcurrentSkipListSet<Integer> cs = new ConcurrentSkipListSet<Integer>();// extends NavigableSet

    public static void main(String[] args) {
        
        cs.add(10);
        cs.add(30);
        cs.add(-10);
        cs.add(-30);
        cs.add(0);
        cs.add(44);

        
        Integer[] array = new Integer[0];
        
        array = cs.toArray( array );
        for (Integer string : array) {
            System.out.println("Element : " +string);
        }
        
        Iterator<Integer> i = cs.iterator();
        while ( i.hasNext() ){
            Integer one = i.next();
            System.out.println("iterator >> " + one +" << higher=" + cs.higher(one) +" lower=" 
                    + cs.lower( one ) + " ceil = " + cs.ceiling( one) + " floor = " + cs.floor( one ));
        }
        
        System.out.println( cs.headSet( 0 ));           // do not contain 0 (default!)
        System.out.println( cs.headSet( 0, false ));    // do not contain 0 
        System.out.println( cs.headSet( 0, true ));     // contain 
        
        System.out.println( cs.subSet(0, true, 44, false));  // [0, 44)
        
        
        

    }
}



class IntComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}