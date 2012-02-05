package net.mgorski.scjp.old;

import java.util.ArrayList;
import java.util.List;

public class Blocks {

    private static List<Something> array = new ArrayList<Something>();

    public static void main(String[] args) {

        Something s0 = new Something(0);
        array.add(s0);
        Something s1 = new Something(1);
        array.add(s1);

        Something sth;
        sth = new Something(10);
        array.add(sth);

        sth = new Something(11);
        array.add(sth);
        
        /* this will obviously overwrite 11 */
        sth.setId( 12 );
        array.add( sth );
        
        Something sthElse;
        {
            sthElse = new Something(20);
            array.add(sthElse);
        }
        {
            sthElse = new Something(21);
            array.add(sthElse);
        }

        System.out.println("Array contents: ");
        for (Something item : array) {
            System.out.print("[ " + item.getId()+" ]");
        }
        System.out.println("");

        /**
         * result :
         * Array contents: 
         * [ 0 ][ 1 ][ 10 ][ 12 ][ 12 ][ 20 ][ 21 ]
         */
    }
}

class Something {
    public Something(int id) {
        this.id = id;
    }

    private int id;

    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
}