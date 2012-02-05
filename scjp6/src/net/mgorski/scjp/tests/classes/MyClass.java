package net.mgorski.scjp.tests.classes;

public class MyClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OtherClass oc = new OtherClass(2);
		try {
			oc.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Class1 class1 = new Class1();
		class1.thisIsTheOutherClassMember = "dupa";
		class1.method();
		
		
		Plain p = new Plain();
		
		
	}
}
	
	
	class Plain extends Object {
	    {
	    	System.out.println("Plain");
	    	
	    }
	    Plain(){};
	}
	
	
	

