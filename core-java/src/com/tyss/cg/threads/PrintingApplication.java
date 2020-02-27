package com.tyss.cg.threads;

public class PrintingApplication {

	public void printingDocuments(String document, int numOfCopies) {
		for (int i = 1; i <= numOfCopies; i++) {
			System.out.println(">> printing" + document + "#");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
