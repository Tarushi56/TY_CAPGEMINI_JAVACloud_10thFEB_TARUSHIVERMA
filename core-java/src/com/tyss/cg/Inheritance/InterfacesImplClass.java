package com.tyss.cg.Inheritance;

public class InterfacesImplClass implements MethodsInterface, AnotherMethodsInterface {

	@Override
	public void displayMessage() {
		System.out.println("overridden dispalyMesssage() of MethodsInterface");
	}

	@Override
	public void print() {
		System.out.println("overridden printMesssage() of MethodsInterface");
	}

	@Override
	public void messageDisplay() {
		System.out.println("overridden messsagedispaly() of AnotherMethodsInterface");
	}

	public static void main(String[] args) {
//	 MethodsInterface methodsInterface =new InterfacesImplClass();
//	 AnotherMethodsInterface anotherMethodsInterface =new InterfacesImplClass();
//	 methodsInterface.print();
//	 methodsInterface.displayMessage();
//	anotherMethodsInterface.messageDisplay();

		InterfacesImplClass lic = new InterfacesImplClass();
		lic.print();
		lic.displayMessage();
		lic.messageDisplay();

	}
}