package net.mgorski.scjp.test3;

import java.util.ArrayList;
import java.util.List;

public class ToArray {

    public static void main(String[] args) {

        List<String> t = new ArrayList<String>();
        t.add("White");
        t.add("Blue");
        String[] ss = new String[0];
        String[] sb = t.toArray(ss);
        for (int i = 0; i < 2; i++) {
            System.out.print(sb[i] += " Array ");
        }
        for (String s : t) {
            System.out.print(s + " ");
        }
    }

}
