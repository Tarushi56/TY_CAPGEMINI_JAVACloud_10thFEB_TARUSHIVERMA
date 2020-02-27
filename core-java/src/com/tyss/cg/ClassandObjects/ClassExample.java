package com.tyss.cg.ClassandObjects;
//constructor overloading
public class ClassExample {
	// zero argument constructor.. can have only 1
	public ClassExample() {
		System.out.println("zero argument constructor");
	}

	// parameterized constructor.. can have many
	public ClassExample(String st) {
		System.out.println("constructor with one string argument");
	}

	public ClassExample(String st, int i) {
		System.out.println("constructor with one string and one int argument");
	}

	public ClassExample(int i, String st) {
		System.out.println("constructor with  one int and one string  argument");
	}

	public static void main(String[] args) {
		ClassExample ce = new ClassExample();
		ClassExample ce1 = new ClassExample("tarushi");
		ClassExample ce2 = new ClassExample("tarushi", 90);
		ClassExample ce3 = new ClassExample(67, "tarushi");
	}
}
