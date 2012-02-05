package net.mgorski.scjp.book.s15queue;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class Something {

    @Test
    public void testLinkedList() {

        List<Product> list = new LinkedList<Product>();

        list.add(new Product(0));
        list.add(new Product(4));
        list.add(new Product(3));
        list.add(new Product(3));
        list.add(new Product(1));

        for (Product product : list) {
            product.call();
        }

        Stack<Integer> s = new Stack<Integer>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);

        System.out.println(s.peek());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }

    class Product {

        private int id;

        public Product(int id) {
            this.id = id;
        }

        public void call() {
            System.out.println("Object #" + id);
        }

    }
    
    class Orders extends LinkedList<Product> implements Serializable {

        private static final long serialVersionUID = 1L;
        
    }

}
