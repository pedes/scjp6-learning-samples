package net.mgorski.scjp.book.s21api;

import java.io.*;

public class Serialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /**
         * bang
         */

        FileOutputStream out = new FileOutputStream("serialized.dat");
        ObjectOutputStream oos = new ObjectOutputStream(out);

        // Serializeme sm = new Serializeme("AAA","BBB");
        // oos.writeObject( sm );

        CannotSerializeMe csm = new CannotSerializeMe(7);
        SerializeMe sw = new SerializeMe(csm, "CCC", "DDD");
        oos.writeObject(sw);
        oos.flush();
        oos.close();
        System.out.println("Saved!");
        csm = null;
        sw = null;

        FileInputStream in = new FileInputStream("serialized.dat");
        ObjectInputStream iis = new ObjectInputStream(in);
        SerializeMe readObject = (SerializeMe) iis.readObject(); // thorws ClassNotFoundException
        CannotSerializeMe csm2 = readObject.getCsm();
        System.out.println("Object read = " + readObject.getName() + ", " + readObject.getSurname()
                + ", " + ((csm2==null)?"NULL":"CSM ID="+csm2.getId()));
        in.close();
    }

}

class CannotSerializeMe {
    int id = 0;

    public CannotSerializeMe(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class SerializeMe implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient CannotSerializeMe csm; // workaround this
    private String name;
    private transient String surname;        // abandon this
    transient int forgetMe = 200;             // this will be reset to 0 after deserialization
    
    static int staticVariable = 616;          // this will not be touched during serialization

    public SerializeMe() {
        System.out.println("Empty constructor");
    }

    public SerializeMe(CannotSerializeMe csm, String name, String surname) {
        this.csm = csm;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCsm(CannotSerializeMe csm) {
        this.csm = csm;
    }

    public CannotSerializeMe getCsm() {
        return csm;
    }

    private void writeObject(ObjectOutputStream os) {       // method is private !!
        // throws IOException {                              // 1
        try {
            os.defaultWriteObject();                         // defaultWriteObject (1)
            os.writeInt(csm.getId());                        // write int, byte, char, etc....
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream is) {
//         throws IOException, ClassNotFoundException {      // 4
        try {
            is.defaultReadObject(); // 5
            this.csm = new CannotSerializeMe(is.readInt());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
