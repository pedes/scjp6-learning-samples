package net.mgorski.scjp.book.s21api;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class ScannerUse {

    public static void main(String[] args) {

        test1();
        testWithDelimiters();
    }

    private static void test1() {
        Scanner s = new Scanner("1 fish 2 fish red fish blue fish");
        String findInLine = s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
        System.out.println("FIND in line result: " + findInLine);
        MatchResult result = s.match();
        for (int i = 1; i <= result.groupCount(); i++)
            System.out.println("Next group:" + result.group(i));
        s.close();

    }

    private static void testWithDelimiters() {
        Scanner s = new Scanner("1,fish,2,fish,red,fish");
        s.useDelimiter(",");
        System.out.println("With delimiter: " + s.delimiter());
        while (s.hasNext()) {
            if (s.hasNextInt()) {
                System.out.println("Next int :" + s.nextInt());
            } else if (s.hasNext()) {
                System.out.println("Next not-int " + s.next());
            }
        }

        s.close();

    }
}
