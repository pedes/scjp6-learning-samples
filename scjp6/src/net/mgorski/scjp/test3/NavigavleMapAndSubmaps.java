package net.mgorski.scjp.test3;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class NavigavleMapAndSubmaps {
    
    public static void main(String[] args) {
        NavigableMap<Integer, String> nm = new TreeMap<Integer, String>();
        
        nm.put(1, "adin"); nm.put(2, "dwa"); nm.put(3, "tre");
        
        NavigableMap<Integer,String> subMap = nm.subMap(1, true, 2, true); // TreeMap$AscendingSubMap
        System.out.println(subMap);
        
        //SortedMap<Integer, String> subMap2 = subMap.subMap(0, 3); //  java.lang.IllegalArgumentException, key out of range
        //System.out.println(subMap2);
        
        
        SortedMap<Integer, String> subMap2 = subMap.subMap(1, true,1,true);
        System.out.println(subMap2);
    }

}
