package com.tyss.cg.ClassandObjects;

import com.tyss.cg.Methods.ArithmeticOperation;
//java.lang package is by default imported for every class

public class ObjectClassMethod {
	public static void main(String[] args) {
		ObjectClassMethod ocm = new ObjectClassMethod();
		ObjectClassMethod ocm1 = new ObjectClassMethod();

		System.out.println(ocm.getClass());
		int hashCode = ocm.hashCode();
		System.out.println(ocm.hashCode());
		System.out.println(ocm);//address
		System.out.println(ocm1);//address
		System.out.println("with tostring()  " + ocm.toString());// address
		System.out.println("with toString()  " + ocm1.toString());// address
		System.out.println(ocm1.hashCode());
		System.out.println(ocm.equals(ocm1));
		
		

	}

}
