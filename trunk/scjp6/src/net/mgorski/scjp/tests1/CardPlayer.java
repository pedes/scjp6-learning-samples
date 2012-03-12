package net.mgorski.scjp.tests1;

import java.io.*;


class AlmostObject {
    
    public AlmostObject() {
        System.out.println("o");
    }
    
}

class Player extends AlmostObject {
    Player() {
        System.out.println("p");
    }
    
}

class CardPlayer extends Player implements Serializable {
    CardPlayer() {
        System.out.println("c");
    }

    public static void main(String[] args) {
        CardPlayer c1 = new CardPlayer();
        try {
            FileOutputStream fos = new FileOutputStream("play.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(c1);
            os.close();
            FileInputStream fis = new FileInputStream("play.txt");
            ObjectInputStream is = new ObjectInputStream(fis);
            System.out.println("1");
            CardPlayer c2 = (CardPlayer) is.readObject();
            System.out.println("2");
            is.close();
            
//            Player p = new Player();
//            FileOutputStream fos2 = new FileOutputStream("play2.txt");
//            ObjectOutputStream os2 = new ObjectOutputStream(fos2);
//            os2.writeObject(p);
//            os2.close();
            
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
