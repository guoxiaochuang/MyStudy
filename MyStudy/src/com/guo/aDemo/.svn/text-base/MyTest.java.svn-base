package com.guo.aDemo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class MyTest {
	private final int num = 4;

	public static void f1() {
		String[] cuids = new String[11];
		cuids[0] = "000";
		cuids[1] = "001";
		cuids[2] = "002";
		cuids[3] = "003";
		cuids[4] = "004";
		cuids[5] = "005";
		cuids[6] = "006";
		cuids[7] = "007";
		cuids[8] = "008";
		cuids[9] = "009";
		cuids[10] = "010";
		String whereSql = "(";
		for (int i = 0; i < cuids.length; i++) {
			System.out.println(i);
			String cuid = cuids[i];
			whereSql += "'" + cuid + "',";
			if (((i+1) % 4 == 0) || i==cuids.length-1) {
				whereSql = whereSql.substring(0, whereSql.length()-1) + ")";
				System.out.println(whereSql);
				whereSql = "(";
			}
		}

	}

	public static void main(String[] args) throws ParseException {
		f1();
	}
}
