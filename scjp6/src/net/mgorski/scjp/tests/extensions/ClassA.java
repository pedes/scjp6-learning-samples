package net.mgorski.scjp.tests.extensions;

import java.io.IOException;

public class ClassA {

	private int vala;
	protected int valb;
	public int valc;
	/* default: PUBLIC */ int vald;
	public static int vale;
	final protected static int valf = 0; // must be assigned
	public static int valg;
	
	transient int valh;
	transient int vali;
	
	
	 public float aMethod(float a, float b) throws IOException{

		 return 0;
     }
}
