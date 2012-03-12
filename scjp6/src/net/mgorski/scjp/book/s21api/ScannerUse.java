package net.mgorski.scjp.book.s21api;

import java.util.Scanner;

public class ScannerUse {

    public static void main(String[] args) {
        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
        System.out.println(s.nextInt());
        System.out.println(s.nextInt());
        System.out.println("has next? "+ s.hasNext());
        System.out.println("has next (\\w+ - word or more)? "+ s.hasNext("\\w+"));
        System.out.println("has next int? "+ s.hasNextInt());
        System.out.println(s.next());
        System.out.println(s.next());
        s.close(); 
    }
}
