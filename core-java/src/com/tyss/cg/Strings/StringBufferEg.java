package com.tyss.cg.Strings;

public class StringBufferEg {
	public static void main(String[] args) {
		StringBuffer stringBuffer = new StringBuffer("chocolates for string");

		System.out.println(stringBuffer);
		System.out.println(stringBuffer.length());

		stringBuffer.append("Buffer");
		System.out.println(stringBuffer);

		System.out.println(stringBuffer.reverse());
		System.out.println(stringBuffer.reverse());

		stringBuffer.replace(1, 7, "O");
		System.out.println(stringBuffer);

		stringBuffer.insert(5, "ABC");
		System.out.println(stringBuffer);
		
		System.out.println(stringBuffer);

		int index = stringBuffer.indexOf("for");
		System.out.println(index);
		
		stringBuffer.delete(5, 12);
		System.out.println(stringBuffer);

	}

}
