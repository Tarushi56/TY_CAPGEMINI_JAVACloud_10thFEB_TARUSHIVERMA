package com.tyss.cg.Inheritance;

import com.tyss.cg.Methods.Methods;

public class DifferentPackageMethodOverridingClass extends Methods {
	@Override
	public String printMessage() {
		return "Overriden diffferentPackageMethodOverridingClass.printMessage()";
	}

	@Override
	protected String WelcomeMessage() {
		return "Hello World from diffferentPackageMethodOverriding.WelcomeMessage()";
	}
	public static void main(String[] args) {
		 DifferentPackageMethodOverridingClass g=new  DifferentPackageMethodOverridingClass();
		 System.out.println(g.printMessage());
		 System.out.println(g.WelcomeMessage());
		
	}
}
