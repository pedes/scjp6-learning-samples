package net.mgorski.scjp.test2;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    static class GenA {
    }

    static class GenB extends GenA {
    }

    static class GenC extends GenB {
        public void main(String args[]) {
//            List<? super GenA> ty = new ArrayList<GenA>();
            List<GenA> ty = new ArrayList<GenA>();
            ty.add(new GenA());
            ty.add(new GenB());
            ty.add(new GenC());
            
            try {
                try {
                    this.wait();
                }catch (RuntimeException re){
                    System.out.println("Runtime exception"+re.getClass());
                }
                
                
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            
        }
    }

    public static void main(String[] args) {
        new Generics.GenC().main(new String[0]);
    }

}