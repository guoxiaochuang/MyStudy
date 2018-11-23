package com.guo.suanFa;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName: Counter.java
 * @Description: 使用随机算法产生一个数，要求把1-1000W之间这些数全部生成。（考察高效率，解决产生冲突的问题）
 * @author: gxc
 * @date: 2018年11月21日下午4:20:44
 */
public class Counter {

	public void count() {
		long start = System.currentTimeMillis();
		
		Random random = new Random();
		int value = 100;
		int[] list = new int[value];
		for (int j = 0; j < value; j++) {
			list[j] = j + 1;
		}
		int index = 0;
		int count = 0;
		int tmp = 0;
		while (value > 0) {
			index = random.nextInt(value);
			
			tmp = list[count + index];
			
			list[count + index] = list[count];
			
			list[count] = tmp;
			
			++count;
			--value;
		}
		long end = System.currentTimeMillis();

		Arrays.sort(list);
		for (int i=0; i < list.length; ++i) {
			if (list[i] != (i + 1)) {
				System.out.println(i + "error" + list[i]);
			}
		}
		System.out.println("create----");
		System.out.println("执行消耗：" + (end - start) + "毫秒");
		System.out.println("完了，集合大小为" + list.length);

		for (int k = 0; k < list.length; k++) {
			System.out.println(k + "-----" + list[k]);
		}
	}

	public static void main(String[] args) {
		Counter c = new Counter();
		c.count();
	}

}
