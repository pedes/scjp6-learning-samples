package net.mgorski.scjp.tests.classes;

public class OtherClass {
	
	private OtherClass() {
		this(1L); // must be first line !!
		// TODO Auto-generated constructor stub
	}
	
	public OtherClass(int i){
		this();
		
		
	}
	
	protected OtherClass(long j){
		
	}
	
	protected /* !!! PROTECTED OR PUBLIC !!! */ void finalize() throws Throwable {
		System.out.println("Finalize!");
		super.finalize();
		
		/**
		 * Those are protected 
		 */
//		clone();
//		finalize();
		
		
	}

	
}
