package net.mgorski.scjp.book.s08stock;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        
        Stock s = new Stock();
        Peach p = new Peach();
        
        System.out.println(s.apples + ", " + s.dupa +", " + s.peach.amount + ", " +p.amount);
        
        s.modify();
        
        System.out.println(s.apples + ", " + s.dupa +", " + s.peach.amount + ", " +p.amount);
        
        s.modifyAllObj();
        
        System.out.println(s.apples + ", " + s.dupa +", " + s.peach.amount + ", " +p.amount);
        
        
        
        

    }

}
