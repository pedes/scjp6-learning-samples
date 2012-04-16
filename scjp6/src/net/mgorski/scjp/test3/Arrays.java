package net.mgorski.scjp.test3;

public class Arrays {

    public static void main(String[] args) {
        String[] sa[] = new String[2][];
        sa[0] = new String[] { "A", "B", "C", "D" };
        System.out.println(sa[1]);
        for (String[] s : sa) {
            System.out.println(s.length);
            System.out.print(s[1] + ", ");
            System.out.print(s[2] + ", ");
        }
    }

}
