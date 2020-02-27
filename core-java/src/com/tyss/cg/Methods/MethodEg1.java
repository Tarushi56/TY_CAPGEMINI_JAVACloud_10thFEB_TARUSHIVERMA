package com.tyss.cg.Methods;

public class MethodEg1 {
	// called method
	public static void displayMessage() {
		System.out.println("execution comes to called method");
		System.out.println("hello world");
		System.out.println("how r u guys!!!");
		System.out.println("end of dispalyMessage method");
	}

	// calling method
	public static void main(String[] args) {
		System.out.println("displayMethod method is called");
		displayMessage();
		System.out.println("end of main method");
	}

}
