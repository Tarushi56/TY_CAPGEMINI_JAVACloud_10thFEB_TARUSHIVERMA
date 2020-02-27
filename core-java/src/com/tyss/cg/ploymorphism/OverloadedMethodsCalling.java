package com.tyss.cg.ploymorphism;

public class OverloadedMethodsCalling {
	public static void main(String[] args) {
		OverloadedMethods overloadedMethods = new OverloadedMethods();
		System.out.println("add(int i, int j)" + overloadedMethods.add(4, 5));
		System.out.println("add(int i, int j, int k)" + overloadedMethods.add(4, 5, 6));
		System.out.println("add(int i, double d)" + overloadedMethods.add(4, 5.6));
		System.out.println("add(double d, int j)" + overloadedMethods.add(4.9, 5));

	}

}
