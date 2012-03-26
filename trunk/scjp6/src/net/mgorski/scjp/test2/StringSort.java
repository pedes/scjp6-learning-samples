package net.mgorski.scjp.test2;

import java.util.Arrays;

public class StringSort {
    
    public static void main(String[] args) {
        String[] arr = { "aZz ", "aaz ", "az  ", "a0z ", "a#z "};
        Arrays.sort(arr);
        
        for (String s:arr){
            System.out.println(s);
        }
        
    }

}
