package com.tyss.cg.Inheritance;

public class FunctionalInterfaceImpl implements FunctionalInterfaceEg, FunctionalInterfaceExample2 {

	@Override
	public void showMessage() {
		System.out.println("Overriden showMessage() ofFunctionalInterfaceEg");
	}

	@Override
	public int add(int i, int j) {
		return i + j;
	}

	public static void main(String[] args) {
		FunctionalInterfaceImpl functionalInterfaceImpl = new FunctionalInterfaceImpl();
		functionalInterfaceImpl.showMessage();
		functionalInterfaceImpl.dispalyMessage();

		FunctionalInterfaceEg.printMessage();
		System.out.println("add() of FunctionalInterfaceExamples2 is " + functionalInterfaceImpl.add(4, 5));
//		functionalInterfaceImpl.add(3, 7);
//		System.out.println(functionalInterfaceImpl.add(3, 7));
		functionalInterfaceImpl.messageDisplay();

		FunctionalInterfaceExample2.print();

	}

}
