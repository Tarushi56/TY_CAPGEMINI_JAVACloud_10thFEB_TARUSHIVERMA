package com.tyss.cg.Strings;

public class StringMethodEg {
	public static void main(String[] args) {
		String string1="Some chocolates";
		 String string2 ="";
		 String string3 ="SoMe ChOcOlaTeS";
		 
		 System.out.println("length of string1: " + string1.length()); 
		 System.out.println("length of string1: " + string2.length()); 
		 
		 System.out.println("isEmpty() of string: " + string1.isEmpty());
		 System.out.println("isEmpty() of string: " + string2.isEmpty());

		 string1.charAt(5);
		 System.out.println(string1.charAt(10));
		 
		 //string2.charAt(4);
		// System.out.println( string2.charAt(4));
		 
		 System.out.println(string1.charAt(string1.length() -1));
		 System.out.println("charAt() of String: " + string1.charAt(6));
		 
		 System.out.println("equals() of string: " + string1.equals(string3));
		 System.out.println("equalsIgnoreCase() of string: "+string1.equalsIgnoreCase(string3));
		 
		 System.out.println("concatination of two strings: "+string1.concat(" for me"));
		 String string4 = string1.concat(" hi");
		 System.out.println(string1);//string is immutable
		 System.out.println(string4);
		 
		String string5= string1.replace('s', 'z');
		 System.out.println(string1);//string is immutable
		 System.out.println("replace() output: "+string5);
		 System.out.println(string1.replace('s', 'z'));//one more way to do it..
		 
		  String string6= String.valueOf('A');// converts data into string
		  System.out.println(string6);
		 
		  System.out.println(string1.toUpperCase());
		  System.out.println(string1.toLowerCase());
		 
		  
		  System.out.println(string1.substring(3));
		  System.out.println(string1.substring(2, 11));
		  
		  System.out.println(string1.startsWith("hi"));
		  System.out.println(string1.endsWith("s"));
		  System.out.println(string1);
		 
	}
}

