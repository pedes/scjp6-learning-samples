

package mg;

class ExampleProgram {
  public static void main(String[] args){
	StringBuffer ssf1 = new StringBuffer("java");
	StringBuffer ssf2 = new StringBuffer("java");
	StringBuilder sbl1 = new StringBuilder("java");
	StringBuilder sbl2 = new StringBuilder("java");
	String s1 = "java";
	String s2 = "java";
	String s3 = new String("java");
	
	// 200
	String s4 = "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789";
	String s5 = "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789";
	
	System.out.println("s1 eq s2 " +s1.equals(s2));
	System.out.println("s1 eq s3 " +s1.equals(s3));
	
	System.out.println("s1 == s2 " +(s1 == s2));
	System.out.println("s1 == s3 " +(s1 == s3));
	
	System.out.println("s4 == s5 " +(s4 == s5));
	
	System.out.println("1 shift 2 " + ( 1<<2));
	
	System.out.println(ssf1.equals(ssf2));
	System.out.println(ssf1.equals(sbl1));
	System.out.println(ssf1.equals(sbl2));
	System.out.println(sbl1.equals(sbl2));
  
    System.out.println("I'm a Simple Program");
  }
}