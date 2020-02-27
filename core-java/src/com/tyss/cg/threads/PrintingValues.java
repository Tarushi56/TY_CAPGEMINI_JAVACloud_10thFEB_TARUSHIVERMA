package com.tyss.cg.threads;

public class PrintingValues {
	public static void main(String[] args) {
		System.out.println("====application starts=====");
		PrintingMethodClass1 printingMethodClass1 = new PrintingMethodClass1();
		try {
			printingMethodClass1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printingMethodClass1.start();
		Thread thread = new Thread(new PrintingMethodClass2());
		try {
			thread.join();
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		thread.start();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
System.out.println("===application ends====");
	}
}
