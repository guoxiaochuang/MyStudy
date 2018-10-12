package com.readbook.onefiveonesuggestions.chapter4;

/**
 * @ClassName: Suggestion52.java
 * @Description: 建议52：推荐使用String直接量赋值
 * @author: gxc
 * @date: 2018年10月11日下午3:04:51
 */
public class Suggestion52 {

	public static void main(String[] args) {
		String str1 = "中国";
		String str2 = "中国";
		String str3 = new String("中国");
		String str4 = str3.intern();
		boolean b1 = (str1 == str2);
		boolean b2 = (str1 == str3);
		boolean b3 = (str1 == str4);
		System.out.println("b1-->" + b1);
		System.out.println("b2-->" + b2);
		System.out.println("b3-->" + b3);
	}

}
