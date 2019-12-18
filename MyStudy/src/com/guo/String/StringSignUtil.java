package com.guo.String;

import org.hsqldb.lib.StringUtil;

/**
 * 
 * <p>字符串去除换行符</p>
 *
 * @author guoxiaochuang
 * @date 2019年12月18日
 */
public class StringSignUtil {
	
	public static String filterSign(String value){
		if(StringUtil.isEmpty(value)) {
			return "";
		}
		//替换掉 英文逗号
		value=value.replace("，", ",");
		//替换掉换行符
		value=value.replaceAll("[\\t\\n\\r]", "");
		
		return value;
	}

	public static void main(String[] args) {
		String str = "";
		str += "123" + "\t\n\r" + "456";
		System.out.println("1---" + str);
		str = filterSign(str);
		System.out.println("2---" + str);
	}
	
}
