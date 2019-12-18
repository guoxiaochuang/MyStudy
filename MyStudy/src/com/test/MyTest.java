package com.test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class MyTest {

	public static String f1() {
		try {
			System.out.println("1--");
		} catch (Exception e) {

		} finally {
			System.out.println("finally--");
		}

		return "3";
	}

	public static void main(String[] args) {
		// System.out.println(f1());
		// System.out.println((12345-1)%9+1);

		// MyTest t = new MyTest();
		// int n = 999;
		// int m = t.f2(n);
		// System.out.println("m="+m);

		// f4();
		// f5();
		f6();
	}

	public int f2(int n) {
		return (n - 1) % 9 + 1;
	}

	public static void f3() {

		int num = 10;
		List<String> ll = new ArrayList<String>();
		for (int i = 0; i < 11; i++) {
			ll.add("tt" + i);
		}

		String sql = "";
		System.out.println(ll.size());
		if (ll.size() > 0) {
			if (ll.size() == 1) {
				sql = " work_id in ('" + ll.get(0) + "')";
			} else {
				for (int i = 0; i < ll.size(); i++) {
					if (i % num == 0) {
						sql += " work_id in ( ";
						sql += "'" + ll.get(i) + "',";
					} else if (i % num == (num - 1) || i == ll.size() - 1) {
						sql = sql + "'" + ll.get(i) + "') or";
					} else {
						sql += "'" + ll.get(i) + "',";
					}
				}
				sql = sql.substring(0, sql.length() - 2);
			}
		}
		System.out.println(sql);

		int total = ll.size() / num;

		if (ll.size() > 0) {
			for (int i = 0; i < ll.size(); i++) {
				if (i % num == 0) {
					sql += (" work_id in (");
				}
				if (i % num == 0) {
					sql += "'" + ll.get(i) + "',";
				} else if (i % num == (num - 1) || i == ll.size() - 1) {
					sql = sql + "'" + ll.get(i) + "'";
				} else {
					sql += "'" + ll.get(i) + "',";
				}
			}
			sql = sql.substring(0, sql.length() - 2);
		}

		// for(int i=0; i<4; i++){
		// for(int j=0; j<4; j++){
		// sql += j + ",";
		// }
		// sql = sql.substring(0,sql.length()-1);
		// sql = sql + ") or work_id in (";
		// }
		// System.out.println(sql);
		// sql = sql.substring(0,sql.length()-16);
		// System.out.println(sql);
	}

	public static void f4() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 11; i++) {
			list.add("tt" + i);
		}
		int flag = 10; // 每次取的数据
		int size = list.size(); // 总条数
		int temp = size / flag + 1; // 总共分多少组
		boolean special = size % flag == 0; // 最后一组是否满员
		System.out.println("共条数：" + size + ";多少组：" + temp + ";每组条数：" + flag + ";最后一组是否满员：" + special);
		String sql = "";
		List<String> subList = null;
		if (size > 0) {

			for (int i = 0; i < temp; i++) {
				if (i == temp - 1) {
					if (special) {
						break;
					}
					subList = list.subList(flag * i, size);
				} else {
					subList = list.subList(flag * i, flag * (i + 1));
				}
				sql += " work_id in (";
				for (int j = 0; j < subList.size(); j++) {
					sql += " '" + subList.get(j) + "',";
				}
				sql = sql.substring(0, sql.length() - 1);
				sql += " ) or";
			}
			sql = sql.substring(0, sql.length() - 2);
		} else {
			sql = " 1=2 ";
		}
		System.out.println(sql);
	}

	public static void f5() {
		System.out.println(Integer.MAX_VALUE);
		BitSet bitSet = new BitSet(Integer.MAX_VALUE - 1);
		for (int i = 0; i < Integer.MAX_VALUE - 1; i++) {
			bitSet.set(i);
		}
		System.out.println(bitSet.size());
	}

	public static void f6() {

		int num = 10;
		List<String> ll = new ArrayList<String>();
		for (int i = 0; i < 125; i++) {
			ll.add("tt" + i);
		}

		int listSize = ll.size();
		int toIndex = 10;
		for (int i = 0; i < ll.size(); i += 10) {
			System.out.println("i----" + i);
			String intIds = "";
			if (i + 10 > listSize) { // 作用为toIndex最后没有100条数据则剩余几条newList中就装几条
				toIndex = listSize - i;
			}
			List<String> newList = ll.subList(i, i + toIndex);
			for(String nn:newList){
				intIds += nn + ",";
			}
			intIds = intIds.substring(0, intIds.length()-1);
			System.out.println(intIds);
		}
	}
}
