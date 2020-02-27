package com.tyss.cg.Methods;

public class MethodCallingClass {
	public static void main(String[] args) {
		 AreaCalculator a=new  AreaCalculator();
		 System.out.println("area of square" + a.calculateAreaOfSquare(4));
		 System.out.println("area of rectangle" + a.calculateAreaOfRectangle(4,5));
		 System.out.println("area of circle" + a.calculateAreaOfCircle(3));
	}

}
