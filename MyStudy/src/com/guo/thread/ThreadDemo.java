package com.guo.thread;

/**
 * @ClassName: ThreadDemo.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: gxc
 * @date: 2018年11月2日上午10:35:01
 */
public class ThreadDemo extends Thread {

	public ThreadDemo(String name) {
		super(name);
	}

	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName() + " running...");// 打印当前线程的名字
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// 创建四个线程对象，代表四个线程
		ThreadDemo demo1 = new ThreadDemo("t1");// 指定线程名字
		ThreadDemo demo2 = new ThreadDemo("t2");
		ThreadDemo demo3 = new ThreadDemo("t3");
		ThreadDemo demo4 = new ThreadDemo("t4");
		demo1.start();
		demo2.start();
		demo3.start();
		demo4.start();
		while (true) {
			System.out.println(Thread.currentThread().getName() + " running...");// 打印当前线程的名字
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
