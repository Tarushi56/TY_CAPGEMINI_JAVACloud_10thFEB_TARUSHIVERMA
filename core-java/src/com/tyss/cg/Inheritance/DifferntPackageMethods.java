package com.tyss.cg.Inheritance;

import com.tyss.cg.Methods.ArithmeticOperation;


public class DifferntPackageMethods extends ArithmeticOperation {
	public static void main(String[] args) {
		DifferntPackageMethods dfm=new DifferntPackageMethods();
		System.out.println(dfm.toString());
		System.out.println(dfm.hashCode());
		System.out.println("add method of Superclass "+add(5,7));
		System.out.println("add method of Superclass "+sub(50,7));
		System.out.println("add method of Superclass "+mul(9,7));
		System.out.println("add method of Superclass "+div(58,2));
		
	}

}
