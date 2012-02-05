package net.mgorski.scjp.tests.generics;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Wildcards {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        
        List<Shape> listOfShapes = new LinkedList<Shape>();
        listOfShapes.add( new Circle() );
        listOfShapes.add( new Shape() );
        
        List<Circle> listOfCircles = new LinkedList<Circle>();
        listOfCircles.add( new Circle() );
        listOfCircles.add( new Circle() );
        listOfCircles.add( new Circle() );
        
        printNames(listOfShapes);
        printNames(listOfCircles);
        
        readCollection( listOfShapes );
        
        Circle c = getFirstItem( listOfCircles );
        System.out.println("First element Circle : " + c.getName() );
        
        Shape s = getFirstItem( listOfShapes );
        System.out.println("First element Shape : " + s.getName() );

    }
    
    
    public static void printNames(List<? extends Shape> list){
        System.out.println("____");
        list.add(null);
//        list.add(new Circle()); // not correct because of the ? unknown type!!!
        for (Shape shape : list) {
            System.out.println("Printing " + ((shape==null) ? "NULL" :  shape.getName()) );
        }
    }
    
    
    
    public static void readCollection(Collection<?> c){
        for (Object object : c) {
            System.out.println("Colleciton item = " + object.toString() );
        }
     
        // RISKY!!
//        for (Object object : c) {
//            System.out.println("Colleciton item = " + ((Shape) object).getName());
//        }
        
    }
    
    public static <T>T getFirstItem( Collection <T> c) {
        for (T t : c) {
            return t;
        }
        return null;
    }

}
