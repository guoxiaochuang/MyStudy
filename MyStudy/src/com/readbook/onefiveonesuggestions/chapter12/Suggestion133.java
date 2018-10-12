package com.readbook.onefiveonesuggestions.chapter12;

/**
 * @ClassName: Suggestion133.java
 * @Description: 建议133：若非必要，不要克隆对象
 * @author: gxc
 * @date: 2018年10月11日上午11:20:13
 */
public class Suggestion133 {

	public static void main(String[] args) {
		// 循环10万次
		final int maxLoops = 10 * 10000;
		int loops = 0;
		long start = System.nanoTime();
		Apple apple = new Apple();
		while (++loops < maxLoops) {
			apple.clone();
		}
		long mid = System.nanoTime();
		System.out.println("clone方法生成对象耗时：" + (mid - start) + " ns");

		// new生成对象
		while (--loops > 0) {
			new Apple();
		}
		long end = System.nanoTime();
		System.out.println("new方法生成对象耗时：" + (end - mid) + " ns");
	}

}

class Apple implements Cloneable {
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error();
		}
	}
}