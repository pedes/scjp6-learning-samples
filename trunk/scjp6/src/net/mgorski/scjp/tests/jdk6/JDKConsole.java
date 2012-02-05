package net.mgorski.scjp.tests.jdk6;

import java.io.Console;
import java.io.PrintWriter;
import java.io.Reader;

public class JDKConsole {

    public static void main(String[] args) {

        Console con = System.console();

        if (con != null) {
            String user = con.readLine("Username: ");
            char[] password = con.readPassword("Password: ");
            
            
            Reader reader = con.reader();
            PrintWriter writer = con.writer();
            writer.write("DUPA!");
            
        } else {
            System.out.println("NULL!");
        }

    }

}
