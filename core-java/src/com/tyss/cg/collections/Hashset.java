package com.tyss.cg.collections;

import java.util.HashSet;

public class Hashset {
public static void main(String[] args) {
	HashSet<String> hs = new HashSet<String>();
	hs.add("1st String");
	hs.add("2st String");
	hs.add("3st String");
	hs.add("4st String");
	System.out.println("size of hashset after add(): "+hs.size() );
	System.out.println("+++");
	
	System.out.println("contains() on hashset: "+hs.contains("5th string"));
	System.out.println("++++");
	
	
	System.out.println(hs);
	System.out.println("++++");
	
	
	System.out.println("hashset after remove(): " + hs.remove(""));
	System.out.println("++++");
	System.out.println("size of hashset after add(): "+hs.size() );
	System.out.println("+++");
}
}
