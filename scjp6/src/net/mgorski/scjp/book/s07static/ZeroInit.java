package net.mgorski.scjp.book.s07static;

import java.math.BigDecimal;

public class ZeroInit {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        
        BigDecimal a = BigDecimal.ZERO;
        BigDecimal b = BigDecimal.ZERO;
        
        BigDecimal c = new BigDecimal("2.00");
        
        System.out.println(" Values a="+a.toPlainString() +" b=" + b.toPlainString());
        
        
        a = a.add( c ) ;
        b = b.add( c ) ;
        b = b.add( c ) ;
        b = b.add( c ) ;
        
        
        System.out.println(" Values a="+a.toPlainString() +" b=" + b.toPlainString());

    }

}
