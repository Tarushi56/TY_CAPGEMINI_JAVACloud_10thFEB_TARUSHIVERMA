package com.tyss.cg.Inheritance;

public class MethodInterfaceJ8Impl  implements MethodsInterface{

	@Override
	public void displayMessage() {
		System.out.println("@Override displayMessage() MethodInterface");
	}

	@Override
	public void print() {
		System.out.println("@Override print() MethodInterface");
	}
public static void main(String[] args) {
	MethodInterfaceJ8Impl  methodInterfaceJ8Impl= new MethodInterfaceJ8Impl();	
	methodInterfaceJ8Impl.displayMessage();
	methodInterfaceJ8Impl.print();
	methodInterfaceJ8Impl.defaultMethodMessage();
	MethodsInterface.showMessage();//static method
}
}
