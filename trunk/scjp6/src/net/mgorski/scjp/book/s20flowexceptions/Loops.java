package net.mgorski.scjp.book.s20flowexceptions;

import junit.framework.TestCase;

import org.junit.Test;

public class Loops extends TestCase {

    @Test
    public void testFlow() {

        Boolean b = true;
        if (b = false) { // will not execute (has 'false' as the result of the expr)
            fail();
        }

        // Integer i = 1;
        // if (i=2){ // illegal ( int as the result
        //            
        // }

        Character c = 'a';// byte, short, enum, int
        Character d = 'd';
        final char f = 'f';
        switch (c) {
        case 'a':
            System.out.println("result A");
        case 'b':
            System.out.println("also this executes!");
            // case d:
            // System.out.println("This will not work!"); // compile error
        case f:
            System.out
                    .println("See f even it's variable (but final!). Will not work with Character instead");
        default:
            System.out.println("and this!");
        }

        switch (c) {
        default:
            System.out.println("This is fine!");
        }

        switch (c) {
        case 'a':/** <!----- must have colon **/
            System.out.println("See A again");
            break;
        }

        byte by = 2;
        switch (by) {
        case 2:
            System.out.println("ok!");
            // case 128 : System.out.println("too big, aaaa!"); // will not compile, 128 is too big
        }

        // fall-through logic example
        int x = 4;
        switch (x) {
        case 2:
        case 4:
        case 6:
        case 8:
        case 10: {
            System.out.println("x is an even number");
            break;
        }
        default:
            System.out.println("x is an odd number");
        }
        
        switch (x){
            default : System.out.println("always true!");  break;
            case 4 : System.out.println("this is also true!");
        }
        
    }
    
    
    public void testLoops(){
        
        int x = 0;
        while(x++<3){   // may not execute at all
            System.out.println("while=" + x);
        }
        
        x = 0 ;
        do {
            System.out.println("do="+x);
        } while(x++<3); // <!----- MUST have the semicolon !!
        
        
        for ( int w=0, y=3; w<y; w++, y--){
            System.out.println("check "+ w+"<"+y);
        }
        
        for (;;){
            System.out.println("ihaaa!");
            break;
        }
        
       int k = 0;
       for(;k<3;){
           System.out.println("for-while =" + k++);
       }
       
       int table[] = {0,2,3,4};
       for ( int element : table ){
           System.out.println("element="+element);
       }
       if (true){
           System.out.println("do one");
//           break; // only loop/switch
//           System.out.println("do not do this");
       }
       
       for (int p=0; p<3; p++){
           continue;   // not endless, continue -> increment -> condition
       }
       System.out.println("finished");
       
       int[][] table3D = {{0,1,2},{3,4,5},{6,7,8}};
       
       outer:
           for( int row[] : table3D ){
               inner : for ( int valueInner : row ){
                   System.out.println("Table3d= " + valueInner);
//                   break;           // 0 3 6
//                   break inner;      // 0 3 6
//                   break outer;      //  0 
                   continue outer;   // 0 3 6
//                   System.out.println("will never print me!");
               }
//           continue inner; // out of scope
           }
       
       
       int tab[] = {0,2,4};
       int it = 0;
//       for (it : tab ){ illegal !!! }
    }
}
