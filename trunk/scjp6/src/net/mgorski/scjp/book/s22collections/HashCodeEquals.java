package net.mgorski.scjp.book.s22collections;

import java.io.Serializable;

public class HashCodeEquals {
    public static void main(String[] args) {
        
        Car one = new Car();
        one.setVin("SASAS");
        
        Car two = new Car();
        two.setVin("DDASA");
        
        Car three = new Car();
        three.setVin("DDASA");
        
        String dupa = "DDASA";
        
        System.out.println( " obj equal?="+dupa.equals(two) + " #code equal?=" +(dupa.hashCode()==two.hashCode()));
        System.out.println( " obj equal?="+two.equals(dupa) + " #code equal?="+(two.hashCode()==dupa.hashCode()));
        System.out.println( " obj equal?="+one.equals(two) + " #code equal?="+(one.hashCode()==two.hashCode()));
        System.out.println( " obj equal?="+three.equals(two) + " #code equal?="+(three.hashCode()==two.hashCode()));
        System.out.println( " obj equal?="+three.equals(null) + " #code equal?= N/A ");
        
        
    }
}




class Car implements Serializable {
    
    private static final long serialVersionUID = 1;
    
    String vin;
    transient int doNotUseMeToCalcluateHashcodes;
    
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car && ((Car)obj).getVin().equals(this.getVin())){
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return vin.hashCode();
    }
    
}
