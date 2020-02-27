package com.tyss.cg.exception;

import java.util.Scanner;

public class CustomExceptionTester {
	public static void main(String[] args) throws InvalidNumberCustomException {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number");
		int number = sc.nextInt();
		sc.close();
		if (number >= 0 && number <= 10) {
			System.out.println(number * 10);
		} else {
			throw new InvalidNumberCustomException("number must not be greater than 10");
		}
		System.out.println("ghtvbn");
	}
}
