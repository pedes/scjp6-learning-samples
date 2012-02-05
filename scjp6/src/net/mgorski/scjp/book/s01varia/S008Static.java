package net.mgorski.scjp.book.s01varia;

public class S008Static {

    CoffeeSize cs;
    S008Static.CoffeeSize cs2;
    S008Static.Dupa.CoffeeSize cs3;

    public S008Static() {
        // TODO Auto-generated constructor stub
    }

    private void go() {

        // static class Uuuu { // not allowed within method, wrong !!
        //            
        // }

        // enum CoffeeSize { BIG, HUGE, OVERWHELMING }; // wrong, cannot be local!!

    }

    static class Dupa {

        enum CoffeeSize {
            BIG, HUGE, OVERWHELMING
        } // mark no semicolon, ok !!
    }

    enum CoffeeSize {
        BIG, HUGE, OVERWHELMING
    };
}

enum CoffeeSize {
    BIG, HUGE, OVERWHELMING
};



