package com.guo.String;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
		
		int flag = 3;
		
		String whereSql = "(";
		for (int i = 0; i < cuids.length; i++) {
			System.out.println(i);
			String cuid = cuids[i];
			whereSql += "'" + cuid + "',";
			if (((i+1) % flag == 0) || i==cuids.length-1) {
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
	
	public static void f3(){
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add("tt" + i);
		}
		
		int flag = 10; // 每次取的数据
		int size = list.size(); // 总条数
		int temp = size/flag + 1; // 总共分多少组
		boolean special = size%flag ==0; // 最后一组是否有数据
		
		System.out.println("共条数："+ size
				+";多少组："+temp
				+";每组条数：" +flag
				+";最后一组是否满员："+!special);
		String sql = "";
		List<String> subList = null;
		if(size>0){
			for(int i=0; i< temp; i++){
				if(i == temp -1){
					if(special){
						break;
					}
					subList = list.subList(flag * i, size);
				} else {
					subList = list.subList(flag * i, flag * (i + 1));
				}
				sql += " work_id in (";
				for(int j=0; j<subList.size(); j++){
					sql += " '" + subList.get(j) + "',";
				}
				sql = sql.substring(0, sql.length()-1);
				sql += " ) or";
			}
			sql = sql.substring(0, sql.length()-2);
		} else {
			sql = " 1=2 ";
		}
		System.out.println(sql);
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
		f3();
	}
}
