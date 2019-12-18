package com.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TTTTT {
	public static void f1(){
		User u1 = new User();
		u1.setCellName("user1");
		User u2 = new User();
		u2.setCellName("user2");
		User u3 = new User();
		u3.setCellName("user3");
		User u4 = new User();
		u4.setCellName("user1");
		List<User> list = new ArrayList<User>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);
		Map<String, List<User>> groupBy = list.stream().collect(Collectors.groupingBy(User::getCellName));
		for(Map.Entry<String, List<User>> entry : groupBy.entrySet()){
			String key = entry.getKey();
			List<User> users = entry.getValue();
			if(users.size()>1){
				System.out.println("存在同名数据：" + key + "," + users.size() + "条");
			}
		}
	}
	public static void main(String[] args) {
//		f1();
		StringBuffer message = new StringBuffer();
		for(int i=0;i<2;i++){
			message.append("小区" + i + "-" + i + "条；");
		}
		message.replace(message.length()-1, message.length(), "。");
		String str = "导入失败，存在同名小区数据：" + message.toString();
		System.out.println(str);
		
//		message.replace(message.length()-1, "!");
//		System.out.println(message);
	}
}
class User implements Serializable{
	String cellName;

	public String getCellName() {
		return cellName;
	}

	public void setCellName(String cellName) {
		this.cellName = cellName;
	}
}
