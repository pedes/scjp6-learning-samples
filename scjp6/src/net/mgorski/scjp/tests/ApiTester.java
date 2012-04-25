package net.mgorski.scjp.tests;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class ApiTester<E extends Object>{
    
    <T> E method(E e, T t){
        return e;
    }
    
    
    class Gen<T>{
        private T t; 
        public Gen(T obj){
            this.t = obj;   
        }
        
        public T getObj(){
            return this.t;
        }
    }

    public static void main(String[] args) throws ParseException {

        Object o = new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("finalize!");
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

        };

        o.hashCode();
        o = null;
        System.out.println(o);

        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(nf.parse("12L").getClass());

        Calendar c = Calendar.getInstance();
        System.out.println(c.getClass());
        c.setTime(new Date());
        c.getTime();

        // DateFormat df = DateFormat.getDateInstance();
        // df.parse("12313");

        String csv = "Sue , 5 , true , 3";
        Scanner scanner = new Scanner(csv);
        scanner.useDelimiter(",");
        System.out.println(scanner.hasNext());
        String age = scanner.next();
        System.out.println(age);
        
        
        Super[] s = new Sub[1];
        s[0] = new Sub();

        List<? extends Super> sl = new ArrayList<Sub>();
        List<? super Sub> s2 = new ArrayList<Sub>();
        s2.add(0, new Sub());
        s2.add(1, new Sub());
        s2.add(2, new Sub());
        
        System.out.printf("Pi: %f", Math.PI);
    }
    
    
    protected static class Super {
        
    }
    
    static class Sub extends Super {
        
    }

}
