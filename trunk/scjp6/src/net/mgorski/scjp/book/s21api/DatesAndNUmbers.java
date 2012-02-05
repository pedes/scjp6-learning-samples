package net.mgorski.scjp.book.s21api;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DatesAndNUmbers {
    
    public static void main(String[] args) {
        
        
        Date d = new Date();
        
        
        Calendar c = Calendar.getInstance( TimeZone.getTimeZone());
        System.out.println(c.getTime());
        c.add(Calendar.MONTH, 11);
        System.out.println(c.getTime());
        c.roll(Calendar.MONTH, 11);
        System.out.println(c.getTime());
        System.out.println(c.ZONE_OFFSET);
        
        
        
        Date d1 = new Date(1000000000000L);
        DateFormat[] dfa = new DateFormat[6];
        dfa[0] = DateFormat.getInstance();
        dfa[1] = DateFormat.getDateInstance();
        dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT);
        dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        dfa[4] = DateFormat.getDateInstance(DateFormat.LONG);
        dfa[5] = DateFormat.getDateInstance(DateFormat.FULL);
        for(DateFormat df : dfa)
        System.out.println(df.format(d1));
        
        
        
        
        
        
    }
}
