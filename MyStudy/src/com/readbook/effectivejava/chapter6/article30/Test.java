package com.readbook.effectivejava.chapter6.article30;

public class Test {

	public static void main(String[] args) {
		System.out.println(Operation.PLUS.apply(10, 2));
		System.out.println(Operation.MINUS.apply(10, 2));
		System.out.println(Operation.TIMES.apply(10, 2));
		System.out.println(Operation.DIVIDE.apply(10, 2));
		System.out.println(ColorEnum.RED.getName());
	}

}
