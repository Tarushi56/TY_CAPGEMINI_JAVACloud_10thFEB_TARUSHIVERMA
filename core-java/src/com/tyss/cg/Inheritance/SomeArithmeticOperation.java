package com.tyss.cg.Inheritance;

import com.tyss.cg.Methods.ArithmeticOperation;

public class SomeArithmeticOperation extends ArithmeticOperation {
	public SomeArithmeticOperation() {
		super("A");
		
		System.out.println(" SomeArithmeticOperation constructor....");
		
	}
	
	
	public static void main(String[] args) {
		SomeArithmeticOperation ao =new SomeArithmeticOperation();
		
		
		System.out.println("add method of superclass "+add(4,8));
		System.out.println("sub method of superclass "+sub(4,8));
		System.out.println("mul method of superclass "+mul(4,8));
		System.out.println("div method of superclass "+div(48,8));
	}

}
