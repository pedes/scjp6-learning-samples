package net.mgorski.scjp.tests;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ListAndArrayTester {
    public static void main(String[] args) {
        ListAndArrayTester lt = new ListAndArrayTester();
        
        List<NotComparable> notComparable = new ArrayList<NotComparable>();
        notComparable.add(lt.new NotComparable(1));
        notComparable.add(lt.new NotComparable(2));
        notComparable.add(lt.new NotComparable(2));
        notComparable.add(lt.new NotComparable(3));
        
        System.out.println(notComparable.contains(lt.new NotComparable(1)));
        
        for(NotComparable nc: notComparable.toArray(new NotComparable[1]) ){
            System.out.println(nc);
        }
        
        System.out.println("Arrray class"+ new NotComparable[1].getClass());
        
        List<NotComparable> subList = notComparable.subList(0, 2);
        System.out.println("aaaaa:"+subList.size());
        subList.add(lt.new NotComparable(2));
        subList.add(lt.new NotComparable(10));
        subList.add(lt.new NotComparable(10));
        subList.add(lt.new NotComparable(10));
        subList.add(lt.new NotComparable(10));
        
        System.out.println("Sublist size "+ subList.size());
        System.out.println("Arraylist size "+ notComparable.size());
        
        
        PriorityQueue pq = new PriorityQueue();
        pq.add("aa");
        pq.add("AA");
        pq.add("##");
        pq.add("000");
//        pq.add(1);// wrong!
        
        for (Object o : pq){
            System.out.println(o);
        }
        
        
        
        
        

    }

    class NotComparable {
        public NotComparable(int x) {
            this.x = x;
        }

        Integer x;

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof NotComparable) {
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
            if (obj instanceof YesComparable) {
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
