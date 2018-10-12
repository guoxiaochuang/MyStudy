package com.readbook.onefiveonesuggestions.chapter1;

import java.text.NumberFormat;

/**
 * @ClassName: Suggestion4.java
 * @Description: 建议4：避免带有变长参数的方法重载 
 * 复习：重载和重写的区别： 
 * 重写：
 *  1、子类的方法覆盖父类的方法，要求返回值、方法名和参数类型都相同 
 *  2、子类异常不能超出父类异常
 *  3、子类的访问级别不能低于父类的访问级别 
 * 重载：
 *  重载是在同一个类中的两个或者两个以上的方法，拥有相同的方法名，但是参数却不相同，或者方法体也不同。最常见的例子就是类的构造函数。
 * @author: gxc
 * @date: 2018年10月10日上午9:56:37
 */
public class Suggestion4 {
	// 简单折扣
	public void calPrice(int price, int discount) {
		float knockDownPrice = price * discount / 100.0F;
		System.out.println("折扣后的价格：" + formateCurrency(knockDownPrice));
	}

	// 复杂折扣
	public void calPrice(int price, int... discounts) {
		float knockDownPrice = price;
		for (int discount : discounts) {
			knockDownPrice = knockDownPrice * discount / 100.0F;
		}
		System.out.println("折扣后的价格：" + formateCurrency(knockDownPrice));
	}

	// 格式化成本的货币形式
	private String formateCurrency(float price) {
		return NumberFormat.getInstance().format(price);
	}

	public static void main(String[] args) {
		Suggestion4 s = new Suggestion4();
		// 499，打75折
		s.calPrice(499, 75);
		// 499，打75折的基础上再折扣95折
		s.calPrice(499, 75, 95);
	}
}
