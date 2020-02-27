package com.tyss.cg.threads;

public class CustomThread1 extends Thread {

	Object object1;
	Object object2;

	public CustomThread1(Object object1, Object object2) {
		this.object1 = object1;
		this.object2 = object2;
	}

	@Override
	public void run() {
		synchronized (object1) {
			System.out.println(object1);
			try {
				Thread.sleep(500);
				object1.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (object2) {
				System.out.println(object2);
			}
		}
	}
}
