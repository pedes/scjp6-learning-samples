package net.mgorski.scjp.book.s25threads.account;

public class AccountMain {
    
    public static void main(String[] args) {
        Account a = new Account();
        User one = new User("ONE", a);
        User two = new User("TWO", a);
        
        for (int i=0; i<10; i++){
            new Thread(one).start();
            new Thread(two).start();
        }
        
    }
   

}

class User implements Runnable {

    private String name;
    private Account a;

    public User(String name, Account a) {
        super();
        this.name = name;
        this.a = a;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        int balance = a.getBalance();
        System.out.println(name +" check balance : " + balance);
//        int amount = new Random().nextInt(50);
        int amount = 10;
        System.out.println( name + " trying to withdrawn " + amount);
        if ( amount > balance ){
            System.out.println("TOO MUCH");
        } else {
            a.withdraw(amount);
        }
    }

}
