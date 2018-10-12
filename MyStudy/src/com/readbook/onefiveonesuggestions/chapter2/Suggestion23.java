package com.readbook.onefiveonesuggestions.chapter2;

/**
 * @ClassName: Suggestion23.java
 * @Description: 不要让类型默默转换 
 * @author: gxc
 * @date: 2018年10月10日下午3:02:59
 */
public class Suggestion23 {

	// 光速是30万公里/秒，常量
	public static final int LIGHT_SPEED = 30 * 10000 * 1000;
	public static void main(String[] args) {
		System.out.println("题目1：月亮光照射到地球需要1秒，计算月球到地球的距离。");
		long dis1 = LIGHT_SPEED * 1;
		System.out.println("月球与地球的距离是：" + dis1 + " 米");
		System.out.println("题目2：太阳光照射到地球需要8分钟，计算太阳到地球的距离。");
		long dis2 = LIGHT_SPEED * 60 * 8;
		System.out.println("太阳与地球的距离是：" + dis2 + " 米");
		long dis3 = LIGHT_SPEED * 60L * 8;
		System.out.println("太阳与地球的距离是：" + dis3 + " 米");
		long dis4 = 1L * LIGHT_SPEED * 60 * 8;
		System.out.println("太阳与地球的距离是：" + dis4 + " 米");
	}

}
