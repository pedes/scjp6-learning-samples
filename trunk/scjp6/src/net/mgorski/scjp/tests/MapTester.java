package net.mgorski.scjp.tests;

import java.util.*;

public class MapTester {

    public static void main(String[] args) {
        
        final MapTester ct = new MapTester();

        // Mapsssss

        Map<Integer, Integer> map = new Hashtable<Integer, Integer>();
        Set<Integer> keySet = map.keySet();
        System.out.println("Keyset = " + keySet.getClass()); // java.util.Collections$SynchronizedSet
        // keySet.add(1); cannot add !!!, unsupported operation
        
        Collection<Integer> values = map.values();
        System.out.println("Values = " + values.getClass()); // java.util.Collections$SynchronizedCollection
        // values.add(1); cannot add!!!

        TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
        tree.put(1, 1);
        Set<Integer> keySet2 = tree.keySet();
        System.out.println("Keyset2 = " + keySet2.getClass());
//        keySet2.add(null); cannot add
        
        NavigableMap<Integer,Integer> descendingMap = tree.descendingMap();
        System.out.println("Descending map size" + descendingMap.size()+", tree size="+tree.size() +" before");
        
        descendingMap.put(4,4);
        System.out.println("Descending map size" + descendingMap.size()+", tree size="+tree.size()+" after");
        
        System.out.println("Hash map ----------");
        
        // does not metter if comparable or not
        NotComparable notComparable = ct.new NotComparable(1);
        Map<NotComparable, Integer> notComparableKeyMap = new HashMap<NotComparable, Integer>();
        notComparableKeyMap.put(null,null);
        notComparableKeyMap.put(null,null);
        notComparableKeyMap.put(null,null);
        notComparableKeyMap.put(notComparable,1);
        notComparableKeyMap.put(ct.new NotComparable(2),2);
        notComparableKeyMap.put(ct.new NotComparable(2),2);
        notComparableKeyMap.put(ct.new NotComparable(2),2);
        notComparableKeyMap.put(ct.new NotComparable(2),2);
        System.out.println(notComparableKeyMap.size());
        System.out.println("Contains? "+notComparableKeyMap.containsKey(notComparable));
        
        /// tree map
        System.out.println("tree map w/o comparable element----------");
        NotComparable treeNotComparable = ct.new NotComparable(1);
        Map<NotComparable, Integer> treeNotComparableKeyMap = new TreeMap<NotComparable, Integer>();
//        treeNotComparableKeyMap.put(null,1); // not allowed !!, null pointer
//        treeNotComparableKeyMap.put(treeNotComparable,1); // not allowed! classcastexception
        System.out.println(treeNotComparableKeyMap.size());
//        System.out.println("tree Contains? "+treeNotComparableKeyMap.containsKey(treeNotComparable));
        

        System.out.println("tree map w/comparable element ----------");
        ///
        YesComparable yesComparable = ct.new YesComparable(1);
        Map<YesComparable, Integer> yesComparableKeyMap = new HashMap<YesComparable, Integer>();
        yesComparableKeyMap.put(null,null);
        yesComparableKeyMap.put(null,null);
        yesComparableKeyMap.put(null,null);
        yesComparableKeyMap.put(ct.new YesComparable(5),5);
        yesComparableKeyMap.put(ct.new YesComparable(2),2);
        yesComparableKeyMap.put(ct.new YesComparable(2),2);
        yesComparableKeyMap.put(ct.new YesComparable(2),2);
        System.out.println(yesComparableKeyMap.size());
        
        System.out.println("Contains? "+yesComparableKeyMap.containsKey(ct.new YesComparable(5)));
        
        
    
        
        System.out.println("tree map w/o comparable but with comparator ----------");
        /// not comparable with comparator
        System.out.println("tree map ----------");
        NotComparable treeNotComparableWithComparator = ct.new NotComparable(1);
        Map<NotComparable, Integer> treeNotComparableKeyMapWithComparator = new TreeMap<NotComparable, Integer>(ct.new NotComparableComparator());
        treeNotComparableKeyMapWithComparator.put(treeNotComparableWithComparator,1); 
        System.out.println(treeNotComparableKeyMapWithComparator.size());
        
        
   
        
        
        
//        Map<YesComparable, Integer> yesComparableMap = new HashMap<CollectionTester.YesComparable, Integer>();
//        yesComparableMap.put(new YesComparable(1),1);

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
    }

    class NotComparableComparator implements Comparator<NotComparable> {

        @Override
        public int compare(NotComparable o1, NotComparable o2) {
            return o1.x.compareTo(o2.x);
        }
    }

}
