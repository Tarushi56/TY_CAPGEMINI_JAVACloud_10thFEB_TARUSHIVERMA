package com.tyss.cg.collections;

public class CustomListExecuter {
	public static void main(String[] args) {
		CustomList customList = new CustomList(4);
		customList.add("1");
		customList.add("2");
		customList.add("3");
		customList.add("12");
		customList.add("5");
		customList.add("6");

		System.out.println("Customlist size: " + customList.size());
		for (int i = 0; i < customList.size(); i++) {
			System.out.println("Element at " + i + "index: " + customList.get(i));
		}
		System.out.println("++++++");
		
		boolean isThere = customList.contains("12");
		System.out.println("customList.contains(12):" + isThere);
		System.out.println("++++++");

		System.out.println(customList.getIndex("56"));
		System.out.println("index value is: "+customList.getIndex("12"));
	}
}
