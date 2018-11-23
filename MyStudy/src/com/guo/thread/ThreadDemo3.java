package com.guo.thread;
public class ThreadDemo3 {
	public static void main(String[] args) {
		// 基于子类的实现
		new Thread() {
			public void run() {
				while (true) {
					System.out.println(Thread.currentThread().getName() + " running ...");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		// 基于接口的实现
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					System.out.println(Thread.currentThread().getName() + " running ...");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		// 主线程的方法
		while (true) {
			System.out.println(Thread.currentThread().getName() + " is running ... "); // 打印当前线程的名字
			try {
				Thread.sleep(1000); // 休息1000ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
