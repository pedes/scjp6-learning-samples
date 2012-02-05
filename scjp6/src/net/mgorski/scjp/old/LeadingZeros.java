package net.mgorski.scjp.old;

public class LeadingZeros{
	
	public static void main(String[] args) {
		
		int number  = 17;
		
		String formatted = String.format("%07d", number);
		
		System.out.println("Number with leading zeros: " + formatted);

		
		int a = 33333;
        Integer ai = new Integer(a);
        String sa = ai.toString();
        
        String pat = "0000000";
        
        String res = pat.substring( 0,  7 - sa.length()) + sa;
		
		
		
	System.out.println(res);
		
	}

}
	