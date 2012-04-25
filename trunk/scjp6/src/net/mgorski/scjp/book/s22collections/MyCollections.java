package net.mgorski.scjp.book.s22collections;

import java.util.*;


public class MyCollections {
    
    public static void main(String[] args) {
        
        
        { // emptyset
            
            Set<String> emptySet = Collections.emptySet();
            emptySet.clear();
        }
        

        {   // hastable, not iterable, synchronized version of HashMap, bad name, DO NOT ALLOW NULL VALUE / KEYS
            
            Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
            ht.put(1, "dupa");
            
            try {
                ht.put(null, "kn�r");
            } catch (NullPointerException npe){
                System.out.println("indeeed!");
            }
            
            try {
                ht.put(1, "kn�r");
            } catch (NullPointerException npe){
                System.out.println("even here !");
            }
            
            
            
        }
        
        
        { // list has index - add(index,"") etc.
            
            
            ArrayList<String> arrayList = new ArrayList<String>(5);
            arrayList.add("Zero");
            arrayList.add(0, "one");
            
//            arrayList.add(5, "five"); // not possible
            
            for (Iterator<String> iterator = arrayList.iterator(); iterator.hasNext();) {
                String string = (String) iterator.next();
                System.out.println(">>" + string);
            }
            
            
            
            // old, synchronized version of ArrayList
            Vector<String> v = new Vector<String>(1);
            System.out.println("I'm thread-safe-arraylist, and my capacity is ="+v.capacity());
            
        } // those two classes implement marker <code>RanodmAccess</code>
        
        {
            LinkedList<String> ll = new LinkedList<String>();
            
            ll.push("push-1");
            ll.push("push-2");
            ll.add("add-1");
            ll.add("add-2");
            ll.add("add-3");
            ll.add("add-4");
            ll.add("add-5");
            ll.add("add-6");
            
            System.out.println(ll.getFirst());
            iterate(ll);
            
            // head
            ll.peek();ll.peek();ll.peek();ll.peek();ll.peek();ll.peek();ll.peek();ll.peek();ll.peek();ll.peek();
            
            // remove
            System.out.println("removed = " + ll.remove());
            
            // equals to removeFirst();
            System.out.println("poped="+ll.pop());   
            
            // tail
            System.out.println("first element = " + ll.element());
            
            
        }
        
        {
            
            SortedSet<String> ss = new TreeSet<String>();
            ss.add("aaa");
            ss.add("ccc");
            ss.add("bbb");
            iterate(ss);
            
            
            HashMap<String, String> hm = new HashMap<String, String>();
            System.out.println(hm.size());
            hm.put(null, "knur");
            System.out.println(hm.size());
            hm.put(null, "b�br");
            System.out.println(hm.size());
            System.out.println("the survivor is = "+ hm.get(null));
            
            
        }

    }

    private static void iterate(Iterable<String> ll) {
        System.out.println("-------- iterate "+ll.getClass().getName()+" ------------");
        for (Iterator<String> iterator = ll.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            System.out.println("element" + string);
        }
        System.out.println("------------------------------------------");
        
    }
}
