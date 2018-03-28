package com.guo.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	/**
	 * @Method: showAllFiles
	 * @Description: 获取文件夹下的所有文件
	 * @param @param dir
	 * @return void
	 * @throws
	 */
	public static List<File> showAllFiles(File dir) throws Exception {
		List<File> files = new ArrayList<File>();
		File[] fs = dir.listFiles();
		for (int i = 0; i < fs.length; i++) {
			String filePath = fs[i].getAbsolutePath();
			System.out.println("filePath--"+filePath);
			files.add(new File(filePath));
			if (fs[i].isDirectory()) {
				try {
					showAllFiles(fs[i]);
				} catch (Exception e) {
				}
			}
		}
		return files;
	}
	
	public static void main(String[] args) {
		
		String attachAddress = "/Users/guoxiaochuang/work/server-bmdp/apache-tomcat-7.0.55/webapps/bmdp/file/imageFile/";
		File file = new File(attachAddress);
		try {
			showAllFiles(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
