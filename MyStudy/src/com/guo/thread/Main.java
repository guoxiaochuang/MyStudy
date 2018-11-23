package com.guo.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		// ThreadTarget t = new ThreadTarget();// 实例化线程任务类
		// Thread tt = new Thread(t);// 创建线程对象，并将线程对象作为构造方法参数传入
		// tt.start();// 启动线程
		// while (true) {
		// System.out.println(Thread.currentThread().getName() + " running...");
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }

		// int i=1;
		// while(i<=10);
		// i++;

		// for(int y=1;y!=10;y++){
		// System.out.println(y/10);
		// }

		int n = 1;

		switch (n) {
		case 1:
			System.out.println(1);
		case 2:
			System.out.println(2);
			break;
		default:
			System.out.println(3);
			break;
		}

		// int m = 0;
		// while (m < 10) {
		// System.out.println(++m);
		// }
		// Main m = new Main();
		// // m.m();
		// try {
		// System.out.println("1---" + m.sum("1", "0.3"));
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// }
		// m.f();

	}

	int a;
	int b = 0;
	static int c;

	public void m() {
		int d;
		int e = 0;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		a++;
		b++;
		c++;
		// d++;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

	public long sum(String n, String m) throws Exception {
		long count;
		long ln = 0, lm = 0;
		try {
			ln = Long.parseLong(n);
		} catch (Exception e) {
			throw new Exception("数据类型转换失败");
		}
		try {
			lm = Long.parseLong(m);
		} catch (Exception e) {
			throw new Exception("数据类型转换失败");
		}
		return ln + lm;
	}

	public void f() {
		Map m = new HashMap();
		m.put(1, "a");
		m.get(1);
		m.remove(1);
		// for (Map.Entry entry : m.entrySet()) {
		//
		// }

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.get(1);
		list.get(2);
		list.get(3);
		list.remove(0);
	}
}
