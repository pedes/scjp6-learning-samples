package net.mgorski.scjp.test3;



public class Rootings {
    
    static enum Menum {
        A() {
            public void floor() {
                std = 5;
            }
        },
        B() {
            public void floor() {
                std = 30;
            }
        },
        C() {
            public void floor(int y) {
                std = 55;
            }
        };

        int std = 0;

        public void floor() {
            std = 1;
        }

        public String toString() {
            return "[" + std + "]";
        }

    }
    

    public static void main(String args[]) {

        Menum m1 = Menum.A;
        m1.floor();
        Menum m2 = Menum.B;
        m2.floor();
        Menum m3 = Menum.C;
        m3.floor();
        System.out.println(m1 + " " + m2 + " " + m3);

    }

}
