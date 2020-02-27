package com.tyss.cg.threads;

public class ComputerSystem1 extends Thread {
	PrintingApplication printingApplication;

	public ComputerSystem1(PrintingApplication localPrintingApplication) {
		this.printingApplication = localPrintingApplication;
		
	}

	@Override
	public void run() {
		System.err.println(">> printing from computersystem1");
		printingApplication.printingDocuments("any doc.pdf", 12);
	}
}
