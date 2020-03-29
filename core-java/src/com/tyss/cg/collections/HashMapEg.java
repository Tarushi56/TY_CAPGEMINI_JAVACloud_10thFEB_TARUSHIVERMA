package com.tyss.cg.collections;

import java.util.HashMap;

public class HashMapEg {
	public static void main(String[] args) {

		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		System.out.println("size of Hashmap: " + hashMap.size());
		System.out.println("++++");
		hashMap.put("1st key",1);
		hashMap.put("2st key",2);
		hashMap.put("3st key",3);
		hashMap.put("4st key",4);
		
		System.out.println("size if hashmap after put(): " + hashMap.size());
		System.out.println("+++");
		
		System.out.println(hashMap);
		System.out.println("+++++");
		
		System.out.println("isEmpty() on hashmap: " + hashMap.isEmpty());
		System.out.println("++");
		
		System.out.println("remove() on hashmap: "+hashMap.remove("4th-key"));
		System.out.println("+++");
		
		System.out.println("hashmap on remove(): " + hashMap);
	}
}
