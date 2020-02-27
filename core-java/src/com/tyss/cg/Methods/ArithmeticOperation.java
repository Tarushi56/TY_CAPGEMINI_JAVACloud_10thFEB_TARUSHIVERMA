package com.tyss.cg.Methods;

public class ArithmeticOperation {
	public  ArithmeticOperation(String st) {
		System.out.println("BasicArithmeticOperation constructor...");
		
	}
	/**
	 * this method returns the sum of two given integer.
	 * @param i
	 * @param j
	 * @return i + j
	 */
	
	
	public static int add(int i,int j) {
		int sum=i+j;	
		return sum;
		//return=i+j; as a method can have only one return type
	}
	public static int sub(int i,int j) {
		return i-j;	
	}
	
	public static double div(int i,double j) {
		return (i/j);
		}
	
	public static int mul(int i,int j) {
		return i*j;
		
	}
	public static void main(String[] args) {
		int sum=add(24,567);
		System.out.println("sum is:" +sum);
		System.out.println("sum:" +add(89,543));
		System.out.println("sub is "+sub(45,32));
		System.out.println("mul is "+mul(96,32));
		System.out.println("div is "+div(15,2));
		
	}	
		
	

}
