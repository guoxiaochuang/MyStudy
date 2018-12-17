package com.test;

public class MyTest {

	public static String f1(){
		try {
			System.out.println("1--");
		} catch (Exception e) {
			
		} finally {
			System.out.println("finally--");
		}

		return "3";
	}
	
	public static void main(String[] args){
//		System.out.println(f1());
//		System.out.println((12345-1)%9+1);
		
		MyTest t = new MyTest();
		int n = 999;
		int m = t.f2(n);
		System.out.println("m="+m);
	} 
	
	public int f2(int n){
		return (n-1)%9+1;
	}
	
}
