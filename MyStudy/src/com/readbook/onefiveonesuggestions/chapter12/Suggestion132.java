package com.readbook.onefiveonesuggestions.chapter12;

/**
 * @ClassName: Suggestion132.java
 * @Description: 建议132：提示Java性能的基本方法 
 * @author: gxc
 * @date: 2018年10月11日上午10:49:14
 */
public class Suggestion132 {
	// （2）尽可能把变量、方法生命为final static类型
	private final static String[] cns = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	public String toChineseNum(int num){
		return cns[num];
	}
	
	public static void main(String[] args) {

	}
}
