package com.guo.thread.test2;

public class ThreadDemo2 implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " running...");
	}

}
