package com.guo.thread.test2;

public class ThreadDemo extends Thread{
	public void run(){
//		while(true){
//			System.out.println(Thread.currentThread().getName() + " running...");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		for(int i=0; i<100; i++){
			System.out.println(Thread.currentThread().getName() + " running " + i);
		}
	}
}
