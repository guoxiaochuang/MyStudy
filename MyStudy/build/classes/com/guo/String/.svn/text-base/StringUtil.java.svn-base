package com.guo.String;

import java.io.File;

public class StringUtil {
	/**
	 * 组织sql，多条信息，防止sql过长，每N条数据整理一次条件进行查询
	 */
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
	
	public static void f2(){
		String cuid = "FIBER_CAB-001";
		System.out.println(cuid.split("-")[0]);
	}
	
	public static void main(String[] args) {
//		String fileName = "T_SUGGESTION-4028820853322e660153322e66470000.zip";
//		String name = fileName.substring( 0, fileName.indexOf('.'));
//		System.out.println("name--"+name);
//		
//		String fileName2 = "/Users/guoxiaochuang/work/server-bmdp/apache-tomcat-7.0.55/webapps/bmdp/file/imageFile/a1.png";
//		File file = new File(fileName2);
//		int start = file.toString().lastIndexOf(File.separator);
//		int end = fileName2.lastIndexOf('.');
//		String fileName3 = fileName2.substring(start+1, fileName2.length());
//		System.out.println(fileName3);
		f2();
	}
}
