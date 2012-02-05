package net.mgorski.scjp.tests.enums;


enum Color {
	RED("Red Color"),
	GREEN("Blue Color"),
	BLUE("Blue Color");
	
	private String displayName;
	
	Color(String displayName){
		this.displayName = displayName;
	}
	public String toString(){
		return displayName;
	}
}

class ColorTest{
	public static void main(String[] args) {
		Color redColor = Color.RED;
		System.out.println(redColor);
		Color blueColor = Color.BLUE;
		System.out.println(blueColor);
		
		System.out.println(Color.RED);
	}
}
