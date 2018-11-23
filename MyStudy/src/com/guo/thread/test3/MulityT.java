package com.guo.thread.test3;

public class MulityT implements Runnable {
	private String name;
	private long i = 1;

	public MulityT(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (i < 10) {
			System.out.println(name + " running ... " + i++);
			System.out.println();
			Thread.yield();
			// try {
			// Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
		}
	}

	public static void main(String[] args) {
		MulityT m1 = new MulityT("t1");
		Thread t1 = new Thread(m1);
		t1.start();
		MulityT m2 = new MulityT("t2");
		Thread t2 = new Thread(m2);
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MulityT m3 = new MulityT("t3");
		Thread t3 = new Thread(m3);
		t3.start();
	}
}
