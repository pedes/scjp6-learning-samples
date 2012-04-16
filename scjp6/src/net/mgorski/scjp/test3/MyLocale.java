package net.mgorski.scjp.test3;

import java.util.Locale;

public class MyLocale {
    public static void main(String[] args) {
        Locale l = new Locale("en", "uk");
        System.out.println(l.getCountry());
        System.out.println(l.getLanguage());
        
        Locale l2 = new Locale("en_UK");
        System.out.println(l2.getCountry());
        System.out.println(l2.getLanguage());
        
        Locale l4 = new Locale("new COUNTRY");
       System.out.println(l4.getCountry());
       System.out.println(l4.getLanguage());
    }

}
