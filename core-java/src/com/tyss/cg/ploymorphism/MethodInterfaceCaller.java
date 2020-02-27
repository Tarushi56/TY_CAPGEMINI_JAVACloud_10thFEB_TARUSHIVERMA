package com.tyss.cg.ploymorphism;

public class MethodInterfaceCaller {
	public static void main(String[] args) {
		MethodOverridingClass1 methodOverridingClass1=new MethodOverridingClass1();
		MethodOverridingClass2 methodOverridingClass2=new MethodOverridingClass2();
		System.out.println(methodOverridingClass1.DispalyMessage());
		System.out.println(methodOverridingClass1.PrintMessage());
		
		System.out.println("--------------------------");
		System.out.println(methodOverridingClass2.DispalyMessage());
		System.out.println(methodOverridingClass2.PrintMessage());

	}

}
