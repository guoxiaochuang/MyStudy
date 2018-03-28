package com.guo.java.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 *Map学习 
 */
public class MapStudy {

	/**
	 * Java中如何遍历Map对象的4种方法
	 */

	/**
	 * 1、在for-each循环中使用entries来遍历
	 */
	public void f1() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}
	
	/**
	 * 2、在for-each循环中遍历keys或values。
	 * 如果只需要map中的键或者值，你可以通过keySet或values来实现遍历，而不是用entrySet。
	 */
	public void f2(){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();  
		//遍历map中的键  
		for (Integer key : map.keySet()) {  
		    System.out.println("Key = " + key);  
		}  
		//遍历map中的值  
		for (Integer value : map.values()) {  
		    System.out.println("Value = " + value);  
		}  
	}
	
	/**
	 * 3、使用Iterator遍历
	 */
	public void f3(){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();  
		Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();  
		while (entries.hasNext()) {  
		    Map.Entry<Integer, Integer> entry = entries.next();  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
		} 
	}
	
	/**
	 * 4、通过键找值遍历（效率低）
	 */
	public void f4(){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();  
		for (Integer key : map.keySet()) {  
		    Integer value = map.get(key);  
		    System.out.println("Key = " + key + ", Value = " + value);  
		}  
	}
}
