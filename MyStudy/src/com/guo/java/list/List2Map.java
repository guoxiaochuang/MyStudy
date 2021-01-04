package com.guo.java.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class List2Map {

	public static void main(String[] args) {
		
//		Date date = new Date();
//		System.out.println(date.equals(date));
		
		f1();
	}
	
	/**
	 * List数据按某个字段分组
	 * 如：按年龄分组
	 */
	private static void f1(){
		List<User> users = new ArrayList<>();
		
		User u1 = new User();
		u1.setId(1);
		u1.setName("n1");		
		User u2 = new User();
		u2.setId(2);
		u2.setName("n2");		
		User u3 = new User();
		u3.setId(3);
		u3.setName("n3");
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
		for(User u:users){
			System.out.println(u.getId()+"-"+u.getName()+"-"+u.getAge());
		}
		
		users.stream().forEach(item->item.setAge(12));
		System.out.println("----------------");
		
		for(User u:users){
			System.out.println(u.getId()+"-"+u.getName()+"-"+u.getAge());
		}
		
		Map<Integer, List<User>> groupByAge = users.stream().collect(Collectors.groupingBy(User::getAge));
		
		
	}
	
}

class User{
	private Integer id;
	private String name;
	private Integer age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
