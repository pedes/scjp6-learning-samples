package net.mgorski.scjp.tests.classes;

class D {
	static int f1(int i) {
		System.out.print(i + ",");
		return 0;
	}

	public static void main(String[] args) {
		int i = 0;
		i = i++ + f1(i); // 0 + 0
		System.out.print(i);
	}

	
}


//class F {
//	static String m(int i) {
//		return "int";
//	}
//
//	static String m(float i) {
//		return "float";
//	}
//
//	public static void main(String[] args) {
//		long a1 = 1;
//		double b1 = 2;
//		System.out.print(m(a1) + "," + m(b1));
//	}
//}
