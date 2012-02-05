package net.mgorski.scjp.tests.extensions;

public class ClassB extends ClassA {
	
	
	static int vale;
	int valf;			// ok (even if final)
	
	// INCORRECT could not reduce visibility  ( default is PRIVATE )
//	float aMethod(float a, float b){ return 0;}

	// INCORRECT (must return the same type)
//	public int aMethod(int a, int b) throws Exception{ }
	
	
	// INCORRECT because 
	// IOException extends Exception ( it's possible in the reverse order)
//	public float aMethod(float a, float b) throws Exception{ return 0; }

	// OK  fine (could not throw anything or throw "smaller" exception
	public float aMethod(float p, float q){ 
		
//		this.vala; // INCORRECT
		this.vald = 0; // OK
		
		
		return 0;
	}
	
	
	
}
