package com.tyss.cg.operatos;

public class UnaryOperator {
	public static void main(String[] args) {
		int i=10;
		int j=10;
		boolean isTrue=true;
		
		System.out.println(j);
		System.out.println(!isTrue);
		System.out.println("value of j with pre-increment" + ++j); //pre-increment
		System.out.println(j);
		
		System.out.println ("value of i with post-increment"+ i++);//post-increment
		System.out.println(i);
		
		System.out.println("value of j with pre-decrement" + --j); // pre-decrement
		System.out.println(j);
		
		System.out.println ("value of i with post-decrement"+ i--);//post-increment
		System.out.println(i);
		
		char a = 'w';
//		System.out.println("value of a with pre-increment:" + ++a);//with characters
//		System.out.println("value of a with post-increment:" + a++);
		
		System.out.println("post-dec with char datatypes:" + a--);
		System.out.println("value of a:" +a);
		
		
	}

}
