package net.mgorski.scjp.book.s21api;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import junit.framework.TestCase;

import org.junit.Test;


public class Varia extends TestCase {
    
    
    String s1 = "one reference variable and one object   ";
    String s2 = new String("one reference variable BUT TWO OBJECTS");
    
    @Test
    public void testStringMethods() {
        
        String s = "winter";
        
        s.charAt(0);   //   w
        s.concat(" season"); // winter season
        String p = s + "season ";  // the same
        s.replace("w", "h");    // hinter
        
        s.length();     // method, not atribute !!
        
        System.out.println(s.substring(0,6));       // 6, not 5 ( last is not index )
        
    }
    
    @Test
    public void testBuilderBuffer(){
        
        StringBuffer sBuffer = new StringBuffer("nose");          // buffer - thread safe
        StringBuilder sBuilder = new StringBuilder();       // no synchronization
        sBuilder.append("- tail");  // nose - tail
        
        
       StringBuilder sb = new StringBuilder("cba");
       sb.reverse().append("def");
       System.out.println("sb="+ sb);
    }
    
    
    @Test
    public void testIO() {
        
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("file");
            pw.write("aaaa!");
            pw.flush();
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (pw!=null){
                pw.close();
            }
        }
        
        
        File f = new java.io.File("file");
        System.out.println("exists?=" + f.exists());
        
        FileInputStream fio  = null;
        try {
            fio = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        

        try {
            PrintWriter pwww = new PrintWriter(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    
    public void testIOChaining() throws IOException {
        
        File f = new File("file");
        FileWriter fw = new FileWriter(f);
//        PrintWriter pw = new PrintWriter(f, "UTF-8");
//        PrintWriter pw = new PrintWriter(fw);
        PrintWriter pw = new PrintWriter(f);
        pw.append("dupszczal");
        pw.flush();
        pw.close();
        System.out.println("finished append");
        
    }
    
    @Test
    public void testConsole(){
        
        Console c = System.console();
        if(c!=null){ // lol, it's really null through JUNIT
            System.out.println("??");
            String readLine = c.readLine();
            System.out.println("you wrote =" + readLine);
            
            char[] readPassword = c.readPassword();
            readPassword = null;
            
            
        }else {
            System.out.println("Console is null :(");   
        }
        
    }
    
    
    public static void main(String[] args) {
        
        Varia s = new Varia();
        s.testConsole();
    }
}
