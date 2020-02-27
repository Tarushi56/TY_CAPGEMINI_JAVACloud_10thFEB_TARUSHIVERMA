package com.tyss.cg.Methods;

public class MethodEg2 {
	public void displayMessage() {
		System.out.println("start of displayMessage()");
		System.out.println("hello world");
		System.out.println("end of displayMessage()");
		System.out.println("returning to calling method..");
		}
public static void main(String[] args) {
	MethodEg2 m= new MethodEg2();
	System.out.println("called displayMessage() via object");
	m.displayMessage();
	System.out.println("end of main method");
	
}
}
