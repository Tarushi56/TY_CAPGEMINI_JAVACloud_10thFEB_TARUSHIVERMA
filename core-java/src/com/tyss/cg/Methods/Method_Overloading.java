package com.tyss.cg.Methods;

public class Method_Overloading {
	public static void dispalyMessage() {
		System.out.println("public static void dispalyMessage()...");
	}
	//overloadedmethod
	public static void dispalyMessage(String st) {
		System.out.println("public static void dispalyMessage(String st)..");
	}
	//overloadedmethod
	public  void dispalyMessage(String st, int n )  {
		System.out.println("public  void dispalyMessage(String st, int n)...");
		
	}
	//overloadedmethod
	public  void dispalyMessage( int n,String st)  {
		System.out.println("public  void dispalyMessage( int n,String st)...");
	}
		
	public static void main(String[] args) {
		Method_Overloading mo =new Method_Overloading(); //object creation
		Method_Overloading.dispalyMessage();  //static method
		dispalyMessage("Dora");//static method
		mo.dispalyMessage(5, "rtu"); //non static method
		mo.dispalyMessage(null, 58);//non static method
	}


}

