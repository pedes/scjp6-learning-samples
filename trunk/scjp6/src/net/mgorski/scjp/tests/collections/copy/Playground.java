package net.mgorski.scjp.tests.collections.copy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Playground {

    public static void main(String[] args) {

        
        
        List<String> list = new ArrayList<String>();
        list.add("BBB");
        list.add("AAA");
        list.add("CCC");

        for (String string : list) {
            System.out.println("uuu" + string);
        }
        
        
        
        /**
         * Set interface
         * ------------
         *  - implements Collection
         *  - adds restriction for not holding duplicate elements
         *  - two sets are equal if they hold the same element(s)
         * 
         * implementations:
         * 
         * - HashSet - best performance, no guarantee on the order
         * - LinkedHashSet - hash set + insertion order
         * - TreeSet - red-black tree
         * 
         * - ( AbstractSet )
         * - ConcurrentSkipListSet 
         * - CopyOnWriteArraySet 
         * - EnumSet 
         * - JobStateReasons (javax.print....)
         * 
         * List interface
         * --------------
         * - sequence elements
         * - may contain duplicates
         * operations :
         * - Positional access ( access by index )
         * - Search — searches for a specified object in the list and returns its numerical position
         * - Iteration — extends Iterator semantics to take advantage of the list's sequential nature
         * - Range-view — subList( ... ) method
         * 
         * implementations
         * - ArrayList - best performing operation
         * - LinkedList - methods to get, insert, remove first and last element
         * - Vector - size can grow and shrink
         * 
         * algorithms :
         * - sort — sorts a List using a merge sort algorithm, which provides a fast, stable sort. 
         *   (A stable sort is one that does not reorder equal elements.)
         * - shuffle — randomly permutes the elements in a List.
         * - reverse — reverses the order of the elements in a List.
         * - rotate — rotates all the elements in a List by a specified distance.
         * - swap — swaps the elements at specified positions in a List.
         * - replaceAll — replaces all occurrences of one specified value with another.
         * - fill — overwrites every element in a List with the specified value.
         * - copy — copies the source List into the destination List.
         * - binarySearch — searches for an element in an ordered List using the binary search algorithm.
         * - indexOfSubList — returns the index of the first sublist of one List that is equal to another.
         * - lastIndexOfSubList — returns the index of the last sublist of one List that is equal to another.
         *  
         *    
         * LinkedList
         *    - peek - get, do not remove, first
         *    - pool - get and remove
         *    - pop - remove, last 
         *    - push - insert
         *    - remove - remove, first
         *    - offer
         * 
         * Queue interface
         * ---------------
         * elements prior to processing - add/peek/poll/remove/offer/pop/push
         * 
         * Deque interface
         * ---------------
         * 
         * 
         * 
         * 
         * 
         */
        
        

        UUU u = new UUU();

    }

}

class UUU implements Collection<UUU> {

    @Override
    public boolean add(UUU e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends UUU> c) {
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
    public Iterator<UUU> iterator() {
        // TODO Auto-generated method stub
        return null;
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
