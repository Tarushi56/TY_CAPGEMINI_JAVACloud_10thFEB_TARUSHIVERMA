package com.tyss.cg.collections;

import java.util.LinkedHashMap;

public class LinkedHashedMap {
public static void main(String[] args) {
	LinkedHashMap<String, Integer> linkedHashMap= new  LinkedHashMap<String, Integer>();
	
	System.out.println("size of Hashmap: " + linkedHashMap.size());
	System.out.println("++++");
	linkedHashMap.put("1st key",1);
	linkedHashMap.put("2st key",2);
	linkedHashMap.put("3st key",3);
	linkedHashMap.put("4st key",4);
	
	System.out.println("size if hashmap after put(): " + linkedHashMap.size());
	System.out.println("+++");
	
	System.out.println(linkedHashMap);
	System.out.println("+++++");
	
	System.out.println("isEmpty() on hashmap: " + linkedHashMap.isEmpty());
	System.out.println("++");
	
	System.out.println("remove() on hashmap: "+linkedHashMap.remove("4th-key"));
	System.out.println("+++");
	
	System.out.println("hashmap on remove(): " + linkedHashMap);
	System.out.println("+++++");
	
	
	System.out.println(" at last size is :"+ linkedHashMap.size());
}
}

