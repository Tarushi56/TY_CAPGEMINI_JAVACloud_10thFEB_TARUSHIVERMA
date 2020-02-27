package com.tyss.cg.exception;

public class TryFinally {
	public static void main(String[] args) {
		try {
			System.out.println(10/0);
		} finally {
			System.out.println("code inside finally block");
		}
	}

}
// finally inside finally is not possible as try catch is possible inside finally