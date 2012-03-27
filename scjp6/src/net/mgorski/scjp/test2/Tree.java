package net.mgorski.scjp.test2;

class Tree {
    static int i[];

    public static void main(String... args) {
        int eye[] = new int[0];
        try {
            try {
                System.out.println(i.length);
//                method();
                
            } finally {
                i = eye;
            }
        } catch (RuntimeException e) {
            System.out.println("Null pointer exception!");
            System.err.println(i.length);
        }
    }
    
    static void method() throws Exception{
        throw new Exception("");
    }
}
