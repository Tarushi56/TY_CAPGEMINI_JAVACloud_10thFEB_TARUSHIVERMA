package com.tyss.cg.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArraylistEx {
	public static void main(String[] args) {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.add(9);
		arrayList.add(19);
		arrayList.add(90);
		arrayList.add(29);
		arrayList.add(99);
		arrayList.add(59);
		arrayList.add(23);
		arrayList.add(14);
		arrayList.add(5, 16);

		System.out.println("size of Arraylist " + arrayList.size());
//		System.out.println(arrayList.get(5));
//		System.out.println(arrayList.get(6));instead of this we used for each loop
		Collections.sort(arrayList); //if it contains a null value then it will give a null pointer exception
		System.out.println("#############################");

		for (Integer integer : arrayList) {
			System.out.print(integer +" ");
		}
		System.out.println("*******");
		// System.out.println(arrayList.get(0));
		// System.out.println(arrayList.get(7));
		System.out.println(arrayList);
		System.out.println("++++++++");

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
		System.out.println("++++");
		
		
		arrayList.remove(4);  // it tskes index valur and remove
		System.out.println("Size of arraylist after remove(index)"+ arrayList.size());
		System.out.println(arrayList);
		System.out.println("+++++++");
		
		
		Collections.rotate(arrayList, -(arrayList.size()-1));
		System.out.println("---------------");
		
		
		boolean isThere = arrayList.contains(90);
		boolean isThere2 = arrayList.contains(100);
		System.out.println("Output of  arrayList.contains(90): "+isThere );// we cant concate the boolean valueS
		System.out.println("Output of  arrayList.contains(100): "+isThere2 );
	}
	
	
}
