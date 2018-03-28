package com.guo.classPath;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Java获取文件路径
 * @author guoxiaochuang
 * @Time 2016年02月23日11:30:36
 */
public class FilePathHelper {
	
	public void getFilePath() throws IOException{
		//第一种：
		//获取当前类的所在工程路径;
		File f = new File(this.getClass().getResource("/").getPath()); 
		System.out.println(f); 
		//如果不加“/”，获取当前类的绝对路径； 
		File f2 = new File(this.getClass().getResource("").getPath()); 
		System.out.println(f2); 
		
		//第二种：
		//获取当前类的所在工程路径
		File directory = new File("");//参数为空 
		String courseFile = directory.getCanonicalPath() ; 
		System.out.println(courseFile); 
		
		//第三种：
		//获取当前工程路径 
		System.out.println(System.getProperty("user.dir")); 
		
		//第四种：
		//获取当前工程路径
		System.out.println( System.getProperty("java.class.path")); 
	}
	
	public static void main(String[] args) {
		FilePathHelper helper = new FilePathHelper();
		try {
			helper.getFilePath();
		} catch (IOException e) {
			System.out.println("获取文件路径报错："+e.getMessage());
			e.printStackTrace();
		}
	}
}
