package com.tyss.cg.Inheritance;

@FunctionalInterface
public interface FunctionalInterfaceEg {
	public void showMessage();

	public static void printMessage() { // can create static method inside Functional interface
		System.out.println("public static void printMessage()---");
	}

	default void dispalyMessage() { // can create default method inside Functional interface
		System.out.println("default void dispalyMessage() of FunctionalInterface");
	}

}
