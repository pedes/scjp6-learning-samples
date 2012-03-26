package net.mgorski.scjp.test2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class D implements Comparator<D> {
    public int compare(D ob1, D ob2) {
        return 1;
    }

    public String toString() {
        return "W";
    }
}

public class TMap {
    public static void main(String argv[]) {
        Set<D> cs = new TreeSet<D>();
        cs.add(new D());    // cast to java.lang.Comparable fails
        cs.add(new D());
        cs.add(new D());
        for (D a : cs)
            System.out.print(a + ",");
    }
}
