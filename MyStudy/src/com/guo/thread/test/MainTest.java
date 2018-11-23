package com.guo.thread.test;

public class MainTest {

	public static void main(String[] args) {
		MainTest t = new MainTest();
		try {
			t.wait();
			t.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
