package net.mgorski.scjp.test2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaPackages {

    public static void main(String[] args) {

        // digits (all digits)
        patternTester("(\\d)+", "wht the 666 heck 667 sdfsdfs 0\\  # 123123  23 23 55L 0000 0.3 \n ");
        
        // all hexes (each separately)
        patternTester("[0-9a-f]", "wht the 666 heck 667 sdfsdfs 0\\  # 123123  23 23 55L 0000 0.3 \n ");
    }
    
    private static void patternTester(String pattern, String matcher){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(matcher);
        System.out.println("---------");
        System.out.println("pattern: " +pattern +"\nmatcher: " +matcher);
        while (m.find()) {
            System.out.println("Group : [" + m.start() + "," + m.end() + ")='" + m.group()+"'");
        }
    }

}
