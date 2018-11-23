package com.guo.thread;

public class ThreadDemo2 extends Thread {
	public void run() {
		while (true) {
			try {
				System.out.println(Thread.currentThread().getName() + " running ...");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		while (true) {
			ThreadDemo2 demo1 = new ThreadDemo2();
			ThreadDemo2 demo2 = new ThreadDemo2();
			ThreadDemo2 demo3 = new ThreadDemo2();
			ThreadDemo2 demo4 = new ThreadDemo2();
			demo1.start();
			demo2.start();
			demo3.start();
			demo4.start();
			try {
				System.out.println(Thread.currentThread().getName() + " running ...");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
