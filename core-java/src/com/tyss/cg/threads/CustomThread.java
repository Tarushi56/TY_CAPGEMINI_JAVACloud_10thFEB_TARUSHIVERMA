package com.tyss.cg.threads;

public class CustomThread {
	public static void PrintingValues1() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Printing Values:" + i);
		}
	}

	public static void PrintingValues2() {
		for (int i = 0; i < 10; i++) {
			System.err.println("Printing Values:" + i);
		}
	}
	public static void main(String[] args) {
		PrintingValues1();
		PrintingValues2();
		
	}

}
