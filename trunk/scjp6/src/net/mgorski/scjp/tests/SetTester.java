package net.mgorski.scjp.tests;

import java.util.*;

public class SetTester {
    public static void main(String[] args) {
        SetTester st = new SetTester();
        
        Set<NotComparable> set = new HashSet<NotComparable>();
        set.add(st.new NotComparable(2));
        set.add(st.new NotComparable(2));
        System.out.println("Set size? " +set.size());
        
        TreeSet<NotComparable> treeSet = new TreeSet<SetTester.NotComparable>(st.new NotComparableComparator());
//        treeSet.add(null); // null pointer 
//        treeSet.add(st.new NotComparable(1)); // class cast if no comparator
        treeSet.add(st.new NotComparable(5));
        treeSet.add(st.new NotComparable(1));
        treeSet.add(st.new NotComparable(3));
        treeSet.add(st.new NotComparable(1));
        treeSet.add(st.new NotComparable(7));
        System.out.println("Not comparable tree set size (w/comparator"+treeSet.size());
        
        treeSet.descendingSet().add(st.new NotComparable(0));
        for (NotComparable nc : treeSet.descendingSet()){
            System.out.println("interate over treeset (descending) " + nc);
        }
        
        NotComparable[] array = treeSet.toArray(new NotComparable[0]);
        for (NotComparable nc : array){
            System.out.println("interate over array (ascending) " + nc);
        }

        LinkedHashSet<YesComparable> lhs = new LinkedHashSet<YesComparable>();
        
        lhs.add(st.new YesComparable(1));
        lhs.add(st.new YesComparable(5));
        lhs.add(st.new YesComparable(2));
        lhs.add(st.new YesComparable(0));
        lhs.add(st.new YesComparable(0));
        lhs.add(st.new YesComparable(0));
        
        for (YesComparable nc : lhs){
            System.out.println("interate over LinkedHashSet " + nc);
        }
        
        
    }

    
    
    
    class NotComparable {
        public NotComparable(int x) {
            this.x = x;
        }
        Integer x;
        
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof NotComparable){
                return ((NotComparable) obj).x.equals(this.x);
            }
            return super.equals(obj);
        }
        
        @Override
        public int hashCode() {
            return this.x.hashCode();
        }
        
        @Override
        public String toString() {
            return x.toString();
        }
    }

    class YesComparable implements Comparable<YesComparable> {

        public YesComparable(int x) {
            this.x = x;
        }

        Integer x;

        @Override
        public int compareTo(YesComparable o) {
            return x.compareTo(o.x);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof YesComparable){
                return ((YesComparable) obj).x.equals(this.x);
            }
            return super.equals(obj);
        }
        
        @Override
        public int hashCode() {
            return this.x.hashCode();
        }
        
        @Override
        public String toString() {
            return x.toString();
        }
    }

    class NotComparableComparator implements Comparator<NotComparable> {

        @Override
        public int compare(NotComparable o1, NotComparable o2) {
            return o1.x.compareTo(o2.x);
        }
    }
}
