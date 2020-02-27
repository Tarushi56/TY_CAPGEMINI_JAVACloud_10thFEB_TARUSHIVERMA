package com.tyss.cg.threads;

public class Machine {
	public static void main(String[] args) {
		System.out.println("++++++++++Printng Machine Started+++++++");
		PrintingApplication printingApplication = new PrintingApplication();
		 ComputerSystem1 computerSystem1= new ComputerSystem1(printingApplication);
		ComputerSystem2 computerSystem2 = new ComputerSystem2(printingApplication);

		 computerSystem1.start();
		 try {
			computerSystem1.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		computerSystem2.start();
		try {
			computerSystem2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("++++++++++Printng Machine stoped+++++++");

	}

}
