package com.readbook.onefiveonesuggestions.chapter2;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @ClassName: Suggestion22.java
 * @Description: 建议22：用整数类型处理货币 
 * @author: gxc
 * @date: 2018年10月10日下午2:46:40
 */
public class Suggestion22 {
	public static void main(String[] args) {
		//输出结果是：0.40000000000000036
		System.out.println(10.00 - 9.60);
		
		double num1 = 10.00d;
		double num2 = 9.60d;
		System.out.println((num1*100 - num2*100)/100);
		System.out.println(num1 - num2);
		NumberFormat f = new DecimalFormat("#.##");
		System.out.println(f.format(10.00 - 9.60));
	}
}
