package com.readbook.onefiveonesuggestions.chapter1;

/**
 * @ClassName: Suggestion3.java
 * @Description: 建议3：三元操作符的类型务必一致
 * @author: gxc
 * @date: 2018年10月10日上午9:42:28
 */
public class Suggestion3 {
	public static void f1() {
		int i = 80;
		String s1 = String.valueOf(i < 90 ? 90 : 100);
		String s2 = String.valueOf(i < 90 ? 90 : 100.0);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println("两者是否相等：" + s1.equals(s2));
	}

	public static void main(String[] args) {
		f1();
	}
}
