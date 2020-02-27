package com.tyss.cg.Inheritance;

public class SubClassL1 extends SuperClass {
	
	@Override
	public String print() {
		return "some string ";
	}
	public void display() {
		System.out.println("display() of subclass");
	}
	public static void main(String[] args) {
		SuperClass sc=new SuperClass();
		SubClassL1 scl =new SubClassL1();
		SuperClass sc2=new SubClassL1 ();//up casting
		SubClassL1 scl2 = (SubClassL1) sc2;//down-casting
		System.out.println(scl.print()); 
		System.out.println(sc.print()); 
		scl.display();
		}

}
