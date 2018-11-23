package com.guo.suanFa;

import java.util.Arrays;

/**
 * @ClassName: SortArray.java
 * @Description: 一个数组的倒序
 * @author: gxc
 * @date: 2018年11月21日下午5:58:18
 */
public class SortArray {

	public int[] f1(int[] a) {
		int[] b = new int[a.length];
		int j = b.length - 1;
		for (int i = 0; i < a.length; i++) {
			b[j--] = a[i];
		}
		return b;
	}

	public int[] f2(int[] a) {

		int length = a.length;
		for (int i = 0; i < length / 2; i++) {
			int tmp = a[i];
			a[i] = a[length - i - 1];
			a[length - i - 1] = tmp;
		}

		return a;
	}

	public static void main(String[] args) {
		SortArray s = new SortArray();
		int[] a = { 1, 25, 7, 8, 2, 45, 9 };
		// int[] b = s.f1(a);
		// for (int num : b) {
		// System.out.println(num);
		// }
		int[] c = s.f1(a);
		for (int num : c) {
			System.out.println(num);
		}
		System.out.println(Arrays.toString(c));
	}

}
