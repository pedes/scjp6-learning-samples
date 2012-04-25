package net.mgorski.scjp.book.s20flowexceptions;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.SocketException;

public class Exceptions {
    
    
    @Test
    public void testFinally(){
        System.out.println("Executed, returned = " +returnBoolean());
    }

    /**
     * @return
     */
    private boolean returnBoolean()  {
        try {
            openSocketWithError();
        } 
        
        /*catch (Exception e){
            System.out.println("illegal here !"); // ILLEGAL HERE 
        } 
        */
          catch (SocketException e) {
            System.out.println("Socket failed");
        } catch (IOException e) {
            e.printStackTrace();
        
        
        try {
            openSocket();
            System.out.println("About to return true...");
            return true;
        } finally {
            System.out.println("close socket");
        }
        }
        return false;
        
    }
    
    @Test
    public void testMySocket() {
        try {
            System.out.println("testing socket for error");
            _testSocket();
        } catch (MyError my){
            System.out.println("MY error catched =" +my.getLocalizedMessage());
        }
        
//        _testSocket();  // not required to catch myError but it will crash the program
    }
    
    

    private void openSocketWithError() throws IOException,SocketException /* order doesn't matter */  {
        System.out.println("Opening socket!");
        throw new SocketException("ihaaa");
    }
    
    private void openSocket()  {
        System.out.println("Opening socket!");
        System.out.println("Success");
        int x=1;
        if ( x==2 ){
            throw new RuntimeException(); // must not catch/declare
        }
    }
    
    @Ignore
    private void _testSocket() {
        throw new MyError(); // must not declare, must not catch
        
    }
    
    class MyError extends Error{

        private static final long serialVersionUID = 1L;
        
    }
}
