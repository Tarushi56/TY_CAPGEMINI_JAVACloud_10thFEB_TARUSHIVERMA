package com.tyss.cg.Strings;

public class StringsExample {
	public static void main(String[] args) {
		String string1 = "some chocolates"; // creation using string literal
		String string2 = new String("some more chocolates"); // using new keyword
		String string3 = "some more chocolates";
		String string4 = "some chocolates";
		String string5 = new String("some more chocolates");
		System.out.println(string1.hashCode());
		System.out.println(string2.hashCode());
		System.out.println(string3.hashCode());
		System.out.println(string4.hashCode());
		System.out.println(string5.hashCode());

		System.out.println("string1== string4: " + string1.equals(string4));
		System.out.println("string2== string3: " + string2.equals(string3));
		System.out.println("string2== string5 " + string2.equals(string5));
	}

}
