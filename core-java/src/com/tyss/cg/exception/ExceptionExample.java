package com.tyss.cg.exception;

public class ExceptionExample {
	public static void main(String[] args) {
		String string = "";
		try {
			int i = 10 / 0;
			System.out.println(string.charAt(3));

			System.out.println(i);
		} catch (StringIndexOutOfBoundsException e) {
			System.err.println("charAt(int index) should not be called on null string");
			System.out.println("charAt(int index) should not be called on null string");
			System.out.println(e.getClass());
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.err.println("should not divide by zero");
			System.out.println(e.getCause());
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("exception caugth in code");
			System.out.println(e.getClass());// gives type of exception
			System.out.println(e.getMessage());
		}

	}
}
