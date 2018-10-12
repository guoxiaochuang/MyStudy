package com.readbook.onefiveonesuggestions.chapter1;

/**
 * @ClassName: Suggestion6.java
 * @Description: 覆写变长方法也循规蹈矩 
 * @author: gxc
 * @date: 2018年10月10日上午10:37:17
 */
public class Suggestion6 {

	public static void main(String[] args) {
		// 向上转型
		Base b = new Base();
		b.fun(100, 50);
		// 不转型
		Sub s = new Sub();
//		s.fun(100, 50) // 本行代码编译不通过
	}

}

//基类
class Base{
	void fun(int price , int... discounts){
		System.out.println("Base... fun");
	}
}

// 子类，覆写父类方法
class Sub extends Base{
	@Override
	void fun(int price, int[] discounts){
		System.out.println("Sub... fun");
	}
}
