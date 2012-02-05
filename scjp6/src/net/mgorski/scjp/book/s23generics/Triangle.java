package net.mgorski.scjp.book.s23generics;

public class Triangle extends Shape implements Draggable, Rotarable {

    @Override
    public void drag() {
        System.out.println("Triangle drag");

    }

    @Override
    public void rotare() {
        System.out.println("Triangle rotare");
    }

    @Override
    public void greet() {
        System.out.println("triangle!");
    }
}
