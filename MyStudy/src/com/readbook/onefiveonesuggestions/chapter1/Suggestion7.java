package com.readbook.onefiveonesuggestions.chapter1;

/**
 * @ClassName: Suggestion7.java
 * @Description: 建议7：警惕自增陷阱
 * @author: gxc
 * @date: 2018年10月10日上午10:50:15
 */
public class Suggestion7 {

	// 猜猜运行结果是多少
	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			count = count++;
		}
		System.out.println("count："+count);
	}

	// "count = count++;"，这条语句可以按照以下代码来理解：
	public static int mockAdd(int count) {
		// 先保存原始值
		int temp = count;
		// 做自增操作
		count = count + 1;
		// 返回原始值
		return temp;
	}
}
