package com.tyss.cg.abstraction;

public class Tester extends AbstractClass {

	@Override
	public String DispalyMessage() {
		return "DispalyMessage() of MethodInterfce";
	}

	@Override
	public String PrintMessage() {
		return "PrintMessage() of MethodInterfce";
	}

	@Override
	String dispaly() {
		return "dispaly() of AbstractClass";
	}

	@Override
	String Print() {
		return "print() of AbstractClass";
	}

	public static void main(String[] args) {
		Tester t = new Tester();
		System.out.println(t.DispalyMessage());
		System.out.println(t.PrintMessage());
		System.out.println(t.dispaly());
		System.out.println(t.Print());
	}
}
