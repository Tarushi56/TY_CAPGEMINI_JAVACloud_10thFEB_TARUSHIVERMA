package com.tyss.cg.loops;

public class ForLoop { 
	public static void main(String[] args) {
		
		
		for (int i = 0; i <= 9; i++) {
			System.out.println((i+1)*8);
			
		}
		System.out.println("**************loop-2*****************");
		int j=0;
		for (; j < 10; j++) {
			System.out.println((j+1)*12);
			}
		System.out.println("**************loop-3*****************");
		int k=0;
		for (; k < 10;) {
			System.out.println((k+1)*11);
			k++;
			
		}
	
}

}
