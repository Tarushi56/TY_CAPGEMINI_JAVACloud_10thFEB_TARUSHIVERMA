  package com.tyss.cg.Methods;

public class Method_Overriding  extends Methods{
	@Override
	public String printMessage() {
		return "non-static MethodOverloadingClass.printMessage()";
	}
	//@Override // static method cant be overridden coz its overloaded 
//	only once so ambiquity is there which method to load
	public static String displayMessage() {
		return"Static  MethodOverloadingClass.displayMessage()";
	}
	@Override
	protected String WelcomeMessage() {
		return super.WelcomeMessage();
	}
	@Override
	int addingTwoIntegers(int j, int i) {
		return super.addingTwoIntegers(j, i);
	}
	
public static void main(String[] args) {
	Method_Overriding mo = new Method_Overriding ()	;
	System.out.println(mo.printMessage());
	System.out.println(mo.WelcomeMessage());
	System.out.println(mo.addingTwoIntegers(5,9));
	System.out.println(new Method_Overriding().printMessage());
	System.out.println(Methods.displayMessage());
	System.out.println(displayMessage());
}
}
