package com.tyss.cg.loops;

import java.util.Scanner;

public class Assignment1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number");
		int n = sc.nextInt();
		if (n % 2 == 0) {
			for (int i = 0; i < n; i++) {
				System.out.println("number is even");
			}
		}else {
			System.out.println("the number is odd");
			sc.close();
		}

	}
}
