package net.mgorski.scjp.book.s13sync;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new IdFetcher(0).start();
        new IdFetcher(1).start();
    }
}
