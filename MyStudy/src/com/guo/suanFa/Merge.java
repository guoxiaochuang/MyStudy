package com.guo.suanFa;

import java.util.Arrays;

/**
 * @ClassName: Merge.java
 * @Description: 合并两个有序数组成一个有序数组
 * @author: gxc
 * @date: 2018年11月21日下午5:03:21
 */
public class Merge {

	public int[] f1(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];

		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
		}
		for (int i = 0; i < b.length; i++) {
			c[a.length + i] = b[i];
		}
		Arrays.sort(c);
		return c;
	}

	public int[] f2(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}
		while (i < a.length) {
			c[k++] = a[i++];
		}
		while (j < b.length) {
			c[k++] = b[j++];
		}
		return c;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 8 };
		int[] b = { 2, 3, 4, 5, 6, 7 };
		Merge p = new Merge();
		int[] c = p.f1(a, b);
		for (int num : c) {
			System.out.println(num);
		}

		int[] d = p.f2(a, b);
		for (int num : c) {
			System.out.println(num);
		}
	}

}
