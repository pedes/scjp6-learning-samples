package net.mgorski.scjp.book.s23generics;

public class Circle extends Shape implements Draggable {

    @Override
    public void drag() {
        System.out.println("drag circle");
    }
    
    @Override
    public void greet() {
        System.out.println("circle!");
    }
}
