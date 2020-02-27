package com.tyss.cg.exception;

public class TryCatchFinally {
	public static void main(String[] args) {
		try {
			System.out.println(10 / 0);
			System.exit(0);// it will terminate 
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Exception caught in code");
			System.exit(0);
		} catch (Exception e) {
			System.out.println("catch exception e");
		} finally {
			System.out.println("code to be executed be there any exception or not");
		}
		System.out.println("some code..");

	}

}
