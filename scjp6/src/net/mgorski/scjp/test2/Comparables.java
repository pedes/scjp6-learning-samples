package net.mgorski.scjp.test2;

import java.util.Comparator;

public class Comparables {
    
    
    public static void main(String[] args) {
        
    }
    
    class Stuff implements Comparable<Stuff> /* disallowed , Comparable<Blup>*/{
        
        String x;

        @Override
        public int compareTo(Stuff o) {
            // TODO Auto-generated method stub
            return 0;
        }
       
        
        
    }
    
    class Bla implements Comparable<Bla>{

        @Override
        public int compareTo(Bla o) {
            return 0;
        }
        
    }
    
    class SthComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            // TODO Auto-generated method stub
            return 0;
        }
        
    }

}
