package com.tyss.cg.Inheritance;

public class SubClassL2 extends SubClassL1{
	@Override
	public void display() {
		super.display();
		//super.i=12;
		System.out.println("Overriden display() in SubClassL2");
		
	}
@Override
public String print() {
	System.out.println("Override print() of SuperClass in SbuClass2");
	return super.print();
	}

public static void main(String[] args) {
	SubClassL2 subClassL2 =new SubClassL2();
	subClassL2.display();
	System.out.println(subClassL2.print());
	System.out.println("ont i of super class: "+ subClassL2.i);
	
}
}
