package com.tyss.cg.threads;

public class PrintingMethodClass2 implements Runnable {

		public static void printvalues2() {
			for (int i = 0; i < 1000; i++) {
				System.err.println("Printing Values:" + i);
			}
		}

		public Runnable start() {
			return null;
		}

		@Override
		public void run() {
			
		}
	}


