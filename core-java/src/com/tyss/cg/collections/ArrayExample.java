package com.tyss.cg.collections;

public class ArrayExample {
	public static void main(String[] args) {
		int[] intArray = new int[6];
		int[] intArray2 = { 5, 7, 9, 4, 9, 0, 6, 78 };
		// int intArray2[] = new int [6]; not the proper way to create an array.

		intArray[0] = 1;
		intArray[1] = 16;
		intArray[2] = 78;
		intArray[3] = 123;
		intArray[4] = 56;
		intArray[5] = 't';
		
		// intArray[5]= Integer.parseInt("56");
		// intArray[5]= Integer.parseInt("56"); throws numberformat exception

		for (int i = 0; i < intArray.length; i++) {
			System.out.println("element at index" + i + " = " + intArray[i]);
		}
		System.out.println("+++++++++++++++++");
		for (int i = 0; i < intArray2.length; i++) {
			System.out.println("element at index" + i + " = " + intArray2[i]);
		}
//		for (int i : intArray2) {           //its a for-each loop it dost not maintain the index.
//			System.out.println(intArray2[i]);
//		}
	}
}
