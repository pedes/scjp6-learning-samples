package net.mgorski.scjp.book.s16scoping;

import java.awt.Button;
import java.awt.Dimension;
import java.util.Date;

public class VariableScopingErrors {

    private int x = 0;

    private int defaultInt;
    private String defaultString;
    private Button defaultButton;

    // private final Button defaultButton; // not legal because of final

    public static void main(String[] args) {
        // x=3; // 1/ illegal, x is static

        VariableScopingErrors vs = new VariableScopingErrors();
        vs.go();
    }

    void go(){
        int y = 0;
        goAfter();
        y++;
        
        
        System.out.println("default value of int is = " + defaultInt);
        System.out.println("default value of String is = " + defaultString);
        System.out.println("default value of Button is = " + defaultButton);
        
        
        Integer [] year = new Integer[]{ new Integer(1), new Integer(2) };
        year = new Integer[100];
        for(int i=0;i<year.length;i++){
            System.out.println("year[" + i + "] = " + year[i]); // all set to null
        }
        
        int localVariable;
//        System.out.println(localVariable);        // not legal !!
        
        
        Date date ;
//        if (date == null){ // Not legal, also not initialized
            System.out.println("Dupszczal");
//        }
            
        referencesToObjects();
        
    }

    private void referencesToObjects() {
        
        Dimension x = new Dimension(1, 2);
        Dimension y = x;
        System.out.println("X="+x.height+"x"+x.width);
        y.height=4; 
        y.width=5;
        System.out.println("--change--");
        System.out.println("X="+x.height+"x"+x.width); // changes are made
        
        
        String foo = "foo";
        String bar = foo;
        
        System.out.println("foo="+foo+", bar="+bar);
        bar += " bar ";
        System.out.println("--change--");
        System.out.println("foo="+foo+", bar="+bar);
        
    }

    void goAfter() {
        // y--; // 2/ illegal, out-of-scope but still alive

        for (int i = 0; i < 10; i++) {

        }
        // System.out.println("i=" + i); // 3/ illegal, already removed
    }

}
