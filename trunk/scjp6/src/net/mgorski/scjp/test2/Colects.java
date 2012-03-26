package net.mgorski.scjp.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Colects{
    public static void main(String args[]){
         List<String> hydrocarbon=new ArrayList<String>();
         hydrocarbon.add("CH4");
         hydrocarbon.add("C2H6");
         hydrocarbon.add("C2H4");
         hydrocarbon.add("COOH");
         Collections.sort(hydrocarbon);
         for(Object ob:hydrocarbon)
              System.out.print(ob+",");
         
         
         System.out.println("");
         ArrayList<String> al = new ArrayList<String>(1);
         al.add("dfads");
         al.set(0, "dddd");
         al.remove(0);
         System.out.println(al.size());
    }
}
