package net.mgorski.scjp.book.s22collections;

import java.util.Arrays;
import java.util.Comparator;

public class SortAndSearch {
    
    public static void main(String[] args) {
        
        
        String[] arr = { "xxx", "ddd", "bbb", "fff", "zzz", "kkk", "jjj" };
        
        System.out.println("arr-beofre: " + printArr(arr));
        Arrays.sort(arr); // must be called before
        System.out.println("arr-after: " + printArr(arr));
        System.out.println( Arrays.binarySearch(arr, "bbb" ) );
        
        
        String[] arr2 = { "xxxxxx", "dddddd", "bdasdbb", "fff", "z", "kdsaskk", "asdasdasjjj" };
        System.out.println("arr2-before: " + printArr(arr2));
        Arrays.sort(arr2, new LenghtSort());
        
        int binarySearch = Arrays.binarySearch(arr2,"bdasdbb",new LenghtSort()); // mark, that it has to has the same sorting method
        
        System.out.println("binary search result = " + binarySearch +", " + ((binarySearch>0)?arr2[binarySearch]:"UNDEFINED"));
        System.out.println("arr2-after: " + printArr(arr2));
        
        
    }

    public static String printArr(String[] arr) {
        String s = "{";
        for (String str : arr) {
            s+= " "+str+",";
        }
        s = s.substring(0,s.length()-1) + "}";
        return s;
    }
}

// sort by lenght of the string comparator
class LenghtSort implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return new Integer(o1.length()).compareTo(o2.length());
    }

}