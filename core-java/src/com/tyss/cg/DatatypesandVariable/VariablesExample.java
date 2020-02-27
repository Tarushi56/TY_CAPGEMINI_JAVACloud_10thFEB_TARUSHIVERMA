package com.tyss.cg.DatatypesandVariable;

public class VariablesExample {
	//Global variable
	static byte sGByte;
	static short sGShort;
	static int sGint;
	static long sGLong;
	static float sGFloat;
	static double sgDouble;
	static char sGChar;
	static boolean sGIstrue;
	static String sGstring;

	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//local variable
		byte lByte = 0 ;
		short lShort;
		int lint;
		long lLong;
		float lFloat;
		double lDouble;
		char lChar;
		boolean lIstrue;
		String lIsstring;
		
		
		System.out.println(sGByte); //these are static global variable
		System.out.println(sGShort);
		System.out.println(sGint);
		System.out.println(sGLong);
		System.out.println(sGFloat);
		System.out.println(sgDouble);
		System.out.println(sGChar);
		System.out.println(sGIstrue);
		System.out.println( sGstring);
		
		
		
		
		
		System.out.println( lByte );//we need to initialize the local variable
		
	}

}
