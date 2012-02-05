package net.mgorski.scjp.tests.dzi;

public class A {
	
	public void a(){
		System.out.println("A::a, call b");
	}
	
	public void b() { 
		System.out.println("A::b");
		a();
	}
	

}
