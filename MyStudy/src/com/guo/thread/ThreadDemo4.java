package com.guo.thread;

public class ThreadDemo4 {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println(Thread.currentThread().getName() + " runnable running...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}) {
			public void run() {
				while (true) {
					System.out.println(Thread.currentThread().getName() + " sub running...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
