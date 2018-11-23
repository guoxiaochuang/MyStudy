package com.guo.thread.test;

public class ThreadDemo extends Thread{

	private int a = 1;
	public void run(){
		System.out.println(Thread.currentThread().getName() + " running..." + a);
		
	}
	
	public static void main(String[] args) {
		ThreadDemo t1 = new ThreadDemo();
		t1.setName("t1");
		t1.start();
		ThreadDemo t2 = new ThreadDemo();
		t2.setName("t2");
		t2.start();
		int a = 2;
	}

}
