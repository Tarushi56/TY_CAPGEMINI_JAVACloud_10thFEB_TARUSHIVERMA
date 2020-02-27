package com.tyss.cg.Inheritance;

public interface FunctionalInterfaceExample2 {
	public int add(int i, int j);

	public static void print() {

	}

	default void messageDisplay() {
		System.out.println("hi im messagedisplay");
	}
}
