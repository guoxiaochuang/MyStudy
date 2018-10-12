package com.readbook.onefiveonesuggestions.chapter2;

import java.util.Scanner;

/**
 * @ClassName: Suggestion21.java
 * @Description: 建议21：用偶判断，不用奇判断 
 * @author: gxc
 * @date: 2018年10月10日下午2:29:53
 */
public class Suggestion21 {

	public static void main(String[] args) {
		// 接收键盘输入参数
		Scanner input = new Scanner(System.in);
		System.out.println("请输入数字：");
		while(input.hasNextInt()){
			int i = input.nextInt();
			String str = i + "->" + (i%2 == 1? "奇数":"偶数");
//			System.out.println(str);
			System.out.println("1-->"+remainder(i, 2));
		}
	}

	// 模拟取余计算，dividend除数，divisor被除数
	public static int remainder(int dividend, int divisor){
		return dividend - dividend / divisor * divisor;
	}
}
