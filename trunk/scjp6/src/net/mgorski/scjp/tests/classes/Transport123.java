package net.mgorski.scjp.tests.classes;

class Transport {
}

class Plane extends Transport {
}

class Car extends Transport {
}

public class Transport123 {
	public static void main(String... args) {
		Plane[] na = { new Plane(), new Plane(), };
		evilMethod(na);
	}

	public static void evilMethod(Transport[] ar) {
		ar[0] = new Car();
	}

}
