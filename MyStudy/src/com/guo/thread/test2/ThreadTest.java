package com.guo.thread.test2;

public class ThreadTest {

	public static void main(String[] args) {
		ThreadDemo t = new ThreadDemo();
//		t.run();

//		t.start();

//		t.setDaemon(true);
//		t.start();
		
//		t.start();
//		System.out.println("111");
//		System.exit(1);
		
		ThreadDemo2 t2 = new ThreadDemo2();
		Thread t3 = new Thread(t2);
		t3.start();
	}

}
