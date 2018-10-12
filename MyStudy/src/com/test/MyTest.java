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
		System.out.println(f1());
	} 
	
}
