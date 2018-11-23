package com.guo.file;

import java.io.File;

/**
 * @ClassName: FileTest.java
 * @Description: 递归读取文件夹的文件，代码怎么实现？ 利用File中的listFiles方法，将所有文件保存访问，然后递归调用
 * @author: gxc
 * @date: 2018年11月21日下午2:40:39
 */
public class FileTest {
	public void visitFile(String path) {

		if (path == null) {
			return;// 因为下面的new File如果path为空，回报异常
		}

		File[] files = new File(path).listFiles();
		if (files == null) {
			return;
		}

		for (File file : files) {
			if (file.isFile()) {
				System.out.println("  --"+file.getName());
			} else if (file.isDirectory()) {
				System.out.println("--Directory");
				visitFile(file.getPath());
			} else {
				System.out.println("Error");
			}

		}
	}

	public static void main(String[] args) {
		FileTest dc = new FileTest();
		dc.visitFile("/Users/guoxiaochuang/guoxiaoxiao/mystudy");
	}
}
