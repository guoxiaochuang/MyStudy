package com.readbook.onefiveonesuggestions.chapter2;

import java.util.Scanner;

/**
 * @ClassName: Suggestion24.java
 * @Description: 建议24：边界，边界，还是边界
 * @author: gxc
 * @date: 2018年10月10日下午3:26:28
 */
public class Suggestion24 {
	// 商家卖货，优惠产品，规定会员可拥有的最多产品数量
	// 一个会员拥有产品的最多数量
	public final static int LIMIT = 2000;

	public static void main(String[] args) {
		//2147483647
		try {
			// 会员当前拥有的产品数量
			int cur = 1000;
			Scanner input = new Scanner(System.in);
			System.out.println("预订数量：");
			while (input.hasNextInt()) {
				int order = input.nextInt();
				if (order > 0 && order + cur <= LIMIT) {
					System.out.println("你已经成功预订了" + order + "个产品");
				} else {
					System.out.println("超过限制，预订失败！");
				}
			}
		} catch (Exception e) {
			System.out.println("异常：" + e.toString());
		}
	}

}
