package net.mgorski.scjp.book.s08stock;

public class Stock {
    
    int apples = 10;
    String dupa = "dupa-init";
    Peach peach = new Peach();
    
    protected void modifyPeach(Peach p) {
        p.amount = -100;
    }
    
    protected void modifyDupa(String d){
        d = "-100000";                          // bad !
    }
    
    protected void modify(){
        modifyPeach(this.peach);
        modifyDupa(this.dupa);
    }
    
    
    
    protected void modifyAllObj(){
        modifyPeachAllObj( this.peach );
        
    }
    
    protected void modifyPeachAllObj(Peach p){
        p = new Peach();
        p.amount = 666;
        System.out.println("Changed locally to p= " + p.amount);
    }
    
    
    

}
