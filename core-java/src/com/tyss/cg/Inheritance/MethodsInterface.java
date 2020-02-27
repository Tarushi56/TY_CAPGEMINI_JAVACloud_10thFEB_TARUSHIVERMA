package com.tyss.cg.Inheritance;

public interface MethodsInterface {
	public void displayMessage();
	public void print();
	public static void showMessage() {
		System.out.println("public static void showMessage()  MethodsInterface...");
		}
	default  void defaultMethodMessage() {
		System.out.println("defaultMethodMessage() of MethodsInterface");
	}
}
