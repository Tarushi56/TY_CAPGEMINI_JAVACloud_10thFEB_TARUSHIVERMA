package com.tyss.cg.Methods;

public class VaragsInputEx {// Varags is variable argument
	public int add(int... input) { //input is name of the array
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];//or sum = sum+input[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println("sum: " +new VaragsInputEx().add(1,9,2,5,6,8,5,3,5,7,9,4,3,2,9));
	}
}
