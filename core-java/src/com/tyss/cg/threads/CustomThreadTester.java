package com.tyss.cg.threads;

public class CustomThreadTester {
	public static void main(String[] args) {
		Object object1=new Object();
		Object object2=new Object();
 new CustomThread1(object1, object2).start();
 new CustomThread2(object1, object2).start();
	}

}
