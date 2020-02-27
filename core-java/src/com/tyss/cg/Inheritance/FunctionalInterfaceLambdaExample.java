package com.tyss.cg.Inheritance;

public class FunctionalInterfaceLambdaExample {

	static String string = "lambda expression example for  FunctionalInterfaceLambdaExample";
	static FunctionalInterfaceEg functionalInterfaceEg = () -> {
		System.out.println(string);
		System.out.println("if we want another");
		System.out.println();

	};
	static FunctionalInterfaceExample2 functionalInterfaceExample2 = (i, j) -> i + j;

	public static void main(String[] args) {
		functionalInterfaceEg.dispalyMessage();
		functionalInterfaceEg.showMessage();
		FunctionalInterfaceEg.printMessage();

//int i= ;
		System.out.println(functionalInterfaceExample2.add(9, 5));
		functionalInterfaceExample2.messageDisplay();
		FunctionalInterfaceExample2.print();

	}
}
