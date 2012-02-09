package net.mgorski.scjp.book.s01varia;



class S0009BEnum {

    private enum DupaEnum { BIG } // 1
    private enum DupaEnum2 { NICE, GREEN;
    
    private DupaEnum2 getNiceDupa(){
        return NICE;
    }
        
    } // 1
    private int x; //2
    
    public void dupa(){
        System.out.println(S0009BEnum.DupaEnum.BIG); //3
        int y; //4
        System.out.println(x); //5 
//        System.out.println(y); // 6 // fail!
    }

}
