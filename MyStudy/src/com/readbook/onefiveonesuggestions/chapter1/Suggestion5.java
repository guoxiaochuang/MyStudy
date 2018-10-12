package com.readbook.onefiveonesuggestions.chapter1;

/**
 * @ClassName: Suggestion5.java
 * @Description: 建议5：别让null值和空值威胁到变长方法
 * @author: gxc
 * @date: 2018年10月10日上午10:22:13
 */
public class Suggestion5 {

	public void f1(String str, int... a) {

	}

	public void f1(String str, String... a) {

	}

	public static void main(String[] args) {
		Suggestion5 s = new Suggestion5();
		s.f1("ss", 1);
		s.f1("ss", "aa");
		// 重载方法，以下两行代码编译通不过。方法模糊不清，编译器不知道调用哪个方法
		// s.f1("ss");
		// s.f1("ss", null);
		String[] ss = null;
		s.f1("ss", ss);
	}

}
