package com.tyss.cg.exception;

import java.util.Scanner;

public class TrywithResource1 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int i = 10;
			int j = sc.nextInt();
			if (j == 0)
				System.out.println("should not divide number by zero");
			else
				System.out.println(i / j);
		}
	}
}
