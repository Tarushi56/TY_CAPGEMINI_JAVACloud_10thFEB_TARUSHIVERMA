package com.tyss.cg.threads;

public class ComputerSystem2  extends Thread {
PrintingApplication printingApplication;
public ComputerSystem2(PrintingApplication localPrintingApplication) {
	this.printingApplication =localPrintingApplication;
}
@Override
	public void run() {
	System.err.println(">> printing from computersystem2");
	printingApplication.printingDocuments("some other doc.pdf", 10);
	}
}
