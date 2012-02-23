package net.mgorski.scjp.book.s18boxing;

public class BoxingTest {
    
    public static void main(String[] args) {
        
        Long l = new Long(1000);
        Long l1 = new Long("1000");
        
        Float f = new Float("10.1");
//        Float f1 = new Float("10,1"); // not legal!
        Float f2 = new Float("10.1F");
        Float f3 = new Float(10.1F);
        Float f4 = new Float(10.1);
        
        Boolean b = new Boolean("foo"); // !"true".equalsIgoneCase() --> false
        
        if(!b){ // <-- unboxing !
            
            System.out.println("you'll see me !");
        }
        
        
        Integer valueOf = Integer.valueOf("0101", 2);
        System.out.println("Value = " + valueOf); // 5

        valueOf.shortValue(); 
        
        System.out.println("Hex value = " + Long.valueOf("666",16));
        
        
        Integer x = Integer.valueOf("666");
        x++; // unboxing
        
        
        Integer seven = new Integer(7);
        Integer sei = new Integer(7);
        
        System.out.println("7==7? = " + (seven==sei));

        
        // chekc this out!
        Integer eight = 8;
        Integer osiem = 8;
        
        System.out.println("8==8? = " + (eight==osiem));
        
        
        // chekc this out!
        Integer eightThousands = 8000;
        Integer osiemTysiecy = 8000;
        
        System.out.println("8000==8000? = " + (eightThousands==osiemTysiecy));
        
        /* - Boolean
           - Byte
           - Character from \u0000 to \u007f (7f is 127 in decimal)
           - Short and Integer from -128 to 127 */
        
        int w = 10;
        String go = go(w);
        System.out.println("wide".equals(go)); // ihaaa, widening over boxing !
        
        
        String aEmpty = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String bEmpty = "a";
        bEmpty = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println("-----" + (aEmpty==bEmpty) + " and " +(aEmpty.equals(bEmpty)));
        
        
        System.out.println(shorttt(8));
    }
    
    
    private static String shorttt(int x){ return "short"; };
    private static String go(long x){ return "wide"; };
    private static String go(Integer x){ return "box"; };
}
