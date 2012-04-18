package net.mgorski.scjp.book.s23generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ShapesTestGenerics {
    

    public static void main(String[] args) {
        
        LinkedList<Shape> shapes = new LinkedList<Shape>();
        shapes.addAll(Adder.getTriangles());
        shapes.addAll(Adder.getCircles());
        shapes.add(new Circle());
        shapes.add(new Triangle());
        
        for (Shape shape : shapes) {
            shape.greet();
        }
        
        Vector<Circle> circles22 = new Vector<Circle>();
        circles22.add(new Circle());
        circles22.add(new Circle());
        
        Walker.walk(circles22);
        
        LinkedList<? extends Shape> undeshapes = new LinkedList<Shape>(); // <? extends sth> not allowed on the right side
        
        LinkedList<? extends Shape> circles3 = new LinkedList<Circle>(); // ok but not allowed Circle
        
        
        
        LinkedList<? super Triangle> triangles = new LinkedList<Triangle>();
//        triangles.add(new Shape());   // still wrong !
        triangles.add(new Triangle());
        triangles.add(new Triangle());
        
        Walker.walkSuper(triangles);
        
        List<?> listOfAnything = Adder.getCircles();    // fine, but you cannot add anything here !
        for (Object object : listOfAnything) {
            System.out.println("iterate = " + object.getClass().getName());
        }
        
//        Walker.walk(triangles); // wrong !
        
        //undeshapes.add(new Shape());    // wrong
//      undeshapes.addAll(new LinkedList<Shape>());   // also wrong, 
        
//        LinkedList<? extends Shape> undeshapesNotEmpty = Adder.getCircles(); // wrong
//        
//        Shape shape = undeshapes.get(0); // legal but empty
        
        
    }
    
    static public class Walker {
        
        public static void walk(List<? extends Shape> shapes){
            System.out.println("walker..");
            for (Shape shape : shapes) {
                shape.greet();
            }
        }
        
        public static void walkSuper(List<? super Triangle> triangles){
            System.out.println("walkerSuper..");
            for (Object tr : triangles) {
                System.out.println("TR=" + tr);
            }
        }
        
        public static <E extends Number> List<E> process(List<E> nums){
            return nums;
        }
        
    }
    
    
    
    static public class Adder {
        
        
        public static List<Circle> getCircles() {
            List<Circle>circles = new ArrayList<Circle>();
            circles.add(new Circle());
            circles.add(new Circle());
            circles.add(new Circle());
            return circles;
        }
        
        public static List<Shape> getShapes() {
            List<Shape>shapes = new ArrayList<Shape>();
            shapes.add(new Shape());
            shapes.add(new Shape());
            shapes.add(new Shape());
            return shapes;
        }
        
        public static List<? extends Shape> getTriangles() {
            List<Triangle>circles = new ArrayList<Triangle>();
            circles.add(new Triangle());
            circles.add(new Triangle());
            circles.add(new Triangle());
            return circles;
        }
        
        public static List<? extends Draggable> getDraggables(){        // interface
            List<Draggable> draggables = new LinkedList<Draggable>();
            draggables.add(new Circle());
            draggables.add(new Triangle());
            return null;
        }
    }
    
}
