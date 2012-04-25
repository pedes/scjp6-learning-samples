package net.mgorski.scjp.test2;

interface Min {
}

class MinD {
    String y = "blup";
}

class MinB extends MinD implements Min {
}

class MinC extends MinB {
    int x;
}

public class CCExp {
    public static void main(String args[]) {
        MinD a = new MinD();
        MinB b = new MinB();
        MinC c = new MinC();
        Min m = null;
        b = (MinC) m;
        m = (Min) b;
        MinD a2 = (MinD) m;
        MinB b2 = (MinB) a2;
        Min m2 = (MinC) b2;
        MinC c2 = (MinC) m2;
        
        MinD a1 = (MinC) null;
        System.out.println(a1 instanceof MinC);
        System.out.println(a1 instanceof Min);
        System.out.println(a1 instanceof MinD);

        //  -------------------------- //
        MinC oC = new MinC();
        MinD oA = (MinD) oC;
        MinD oA2 = oC;

        MinD onlyA = new MinD();
        try {
            MinC cFromA = (MinC) onlyA; // class castException
            System.out.println(cFromA.y);
            System.out.println(cFromA.x);

        } catch (java.lang.ClassCastException cce) {
            System.out.println("Class cast exception " + cce.getMessage());
        }

        MinC oC2 = (MinC) oA;
        System.out.println(oC2.x);
        System.out.println(oC2.y);

        System.out.println(oA2.y);

        System.out.println(oA2.y);
        
        // -------------------------- // 
        
        
        MinD ax = /*(A)*/ new MinB();
        MinB bx = (MinB) null;  // class cast
        MinB by = (MinB) new MinD(); 

    }
}