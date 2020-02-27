package com.tyss.cg.exception;

import java.util.Scanner;

public class TrywithResource {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int i = 10;
			int j = sc.nextInt();
			System.out.println(i / j);
		} catch (Exception e) {
			System.err.println("should not  divide number by zero");
			System.err.println(e.getMessage());
		}
	}

}
//this class is implementing closeable interace which inturn is implementing autoclosable()
//multiple try block are possible, finally inside finally is possible by having try-finally