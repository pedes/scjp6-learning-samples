package net.mgorski.scjp.test3;

public class Miner{

    int credit=0;

    public Miner(int d){
         credit=d;
    }

    public String toString(){
         return String.valueOf(credit);
    }

    public static void increase(Miner mn){
         mn.credit++;
    }

    public static void increase(int mn){
         mn++;
    }

    public static void increase(Integer mn){
         mn++;
    }

    public static void main(String args[]){
       
         Miner mi=new Miner(45);
         increase(mi);

         int in=45;
         increase(in);
   
         Integer IN=new Integer(45);
         System.out.println(IN);
         increase(IN);
         System.out.println(IN);
         System.out.println(IN);
   
         System.out.println("Values are :"+mi+","+in+","+IN);

    }

}