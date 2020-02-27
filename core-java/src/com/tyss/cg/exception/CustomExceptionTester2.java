package com.tyss.cg.exception;

import java.util.Scanner;

public class CustomExceptionTester2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number");
		int number = sc.nextInt();
		sc.close();
		try {
			System.out.println(10 / number); 
		} catch (Exception e) {
			throw new InvalidNumberCustomException("any msg");
		}

	}

}
