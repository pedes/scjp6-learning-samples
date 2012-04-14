package net.mgorski.scjp.book.s22collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class NavigableMapsAndSets {
    
    public static void main(String[] args) {
        
        TreeSet<Integer> times = new TreeSet<Integer>();
        times.add(1205); // add some departure times
        times.add(1505);
        times.add(1545);
        times.add(1830);
        times.add(2010);
        times.add(2100);
        
        // Java 5 version
        TreeSet<Integer> subset = new TreeSet<Integer>();
        subset = (TreeSet<Integer>) times.headSet(1600);
        System.out.println("J5 - last before 4pm is: " + subset.last());
        
        TreeSet<Integer> sub2 = new TreeSet<Integer>();
        sub2 = (TreeSet<Integer>) times.tailSet(2000);
        System.out.println("J5 - first after 8pm is: " + sub2.first());
        // Java 6 version using the new lower() and higher() methods
        System.out.println("J6 - last before 4pm is: " + times.lower(1600));
        
        System.out.println("J6 - first after 8pm is: " + times.higher(2000));
        
        System.out.println("lower = " + times.lower(1205));
        System.out.println("floor = " + times.floor(1205));
        System.out.println("higher = " + times.higher(2100));
        System.out.println("ceiling = " + times.ceiling(2100));
        
        System.out.println("poll(get and remove)First ="+times.pollFirst());
        
        NavigableSet<Integer> descendingSet = times.descendingSet();
        for (Integer hour : descendingSet) {
            System.out.println("desc="+hour);
        }
        System.out.println("size is = " + times.size());
        SortedSet<Integer> subSet2 = times.subSet(0, times.size());
        for (Integer hour : subSet2) {
            System.out.println("asc="+hour);
        }
        
        
        
        /*************************************/
        
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("a", "ant"); 
        map.put("d", "dog"); 
        map.put("h", "horse");
        
        SortedMap<String, String> submap = map.subMap("b", "g");
        
        map.put("z", "zorro");
        
        System.out.println(map + " " + submap); // #2 show contents
        
        map.put("b", "bat"); // #3 add to original
        submap.put("f", "fish"); // #4 add to copy
        submap.put("br", "bóbr"); // #4 add to copy\
//        submap.put("w", "waz"); // #4 add to copy\
        submap.put("f", "fish"); // #4 add to copy
        
        map.put("r", "raccoon"); // #5 add to original - out of range
        map.put("l", "leminks"); // #5 add to original - out of range
//        submap.put("p", "pig"); // #6 add to copy - out of range
        
        System.out.println("original:"+map + "\n  submap:" + submap); // #7 show final contents
        
        
    }
    
    
    class Foo implements NavigableSet<Integer> {

        // holly shit 
        
        @Override
        public Integer ceiling(Integer e) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Iterator<Integer> descendingIterator() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public NavigableSet<Integer> descendingSet() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Integer floor(Integer e) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public SortedSet<Integer> headSet(Integer toElement) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public NavigableSet<Integer> headSet(Integer toElement, boolean inclusive) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Integer higher(Integer e) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Iterator<Integer> iterator() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Integer lower(Integer e) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Integer pollFirst() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Integer pollLast() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public SortedSet<Integer> subSet(Integer fromElement, Integer toElement) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public NavigableSet<Integer> subSet(Integer fromElement, boolean fromInclusive,
                Integer toElement, boolean toInclusive) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public SortedSet<Integer> tailSet(Integer fromElement) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public NavigableSet<Integer> tailSet(Integer fromElement, boolean inclusive) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Comparator<? super Integer> comparator() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Integer first() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Integer last() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean add(Integer e) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Integer> c) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void clear() {
            // TODO Auto-generated method stub
            
        }

        @Override
        public boolean contains(Object o) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isEmpty() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean remove(Object o) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public int size() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public Object[] toArray() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public <T> T[] toArray(T[] a) {
            // TODO Auto-generated method stub
            return null;
        }
        
    }
}
