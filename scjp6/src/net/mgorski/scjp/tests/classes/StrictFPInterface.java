package net.mgorski.scjp.tests.classes;

public interface StrictFPInterface {

	
	abstract void getSth();
	
//	protected void sth();
	
//	public static int sth3();
	
//	strictfp long getMeFloatAndDoubleOnly();
	
	
	
}
	

interface SecondInterface{
    
}

interface ThirdInterface extends SecondInterface,StrictFPInterface{
    // legal!
}
