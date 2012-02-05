package net.mgorski.scjp.book.s22collections;

import java.util.Arrays;
import java.util.List;

public class Conversions {
    
    public static void main(String[] args) {
        
        String[] arr = {"aaa","bbb", "fff","ddd","xxx","kkk", "lll"};
        System.out.println("normal   " + SortAndSearch.printArr(arr));
        
        List<String> asList = Arrays.asList(arr);
        System.out.print("{");
        for (String str : asList) {
            System.out.print(" " + str);
        }
        System.out.println(" }");
        
        System.out.println("modify original array ---->");
        arr[0] = "new zero value";
        System.out.print("{");
        for (String str : asList) {
            System.out.print(" " + str);
        }
        System.out.println("\nchanged zero " + SortAndSearch.printArr(arr));
        System.out.println("both changed!");
        
        String[] streched = Arrays.copyOf(arr, arr.length-1);
        System.out.println("streched " + SortAndSearch.printArr(streched));
        
        String[] expanded = Arrays.copyOf(arr, arr.length+1);
        System.out.println("expanded " + SortAndSearch.printArr(expanded));
        
        asList.set(2, "chaned");
        String[] arrayBackFromList = asList.toArray(arr);
        System.out.println("back   " + SortAndSearch.printArr(arrayBackFromList));
        
        asList.set(3, "this modification is made to list");
//        asList.add("something more in the end"); // not allowed !
//        asList.remove(5); // not allowed !
        System.out.println("\noriginal array once again " + SortAndSearch.printArr(arr));
        
    }
}
