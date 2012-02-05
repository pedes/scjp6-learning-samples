package net.mgorski.scjp.book.s25threads.account;

public class Account {
    
    private Integer balance = 50;
    
    public int getBalance(){
        return balance;
    }
    
    public boolean withdraw(int amount){
        int b = getBalance();
        if ( b >= amount ){
            
            System.out.println("Withdrawing " + amount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance-=amount;
            System.out.println("Done, balance now is " + getBalance());
            return true;
        } else {
            System.out.println("Cannot withdrawn, balance is to low : " + b);
            return false;
        }
    }
    
    
}
