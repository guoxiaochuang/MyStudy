package com.guo.imageOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 图片转换Base64编码，Base64编码转换图片
 * getBase64StrByImage：获取图片文件的Base64编码
 * generateImage：解码图片Base64编码，并生成和存储图片文件
 * makeDirs：根据文件夹路径和名称，判断是否存在此文件夹，如果不存在则新建文件夹
 * @author guoxiaochuang
 * @Time 2016年02月23日11:03:15
 */
public class ImageTransformation {
	
	/**
	 * 获取图片文件的Base64编码
	 * @param imgFile
	 * @return
	 */
	public String getBase64StrByImage(String imgFile) {
		// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		File file = new File(imgFile);
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(file);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}
	
	/**
	 * 解码图片Base64编码，并生成和存储图片文件
	 * @param imgStr
	 * @return
	 */
	public boolean generateImage(String imgStr) {
		// 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			String imagePath = System.getProperty("user.dir");//获取当前工程路径
			System.out.println(imagePath);
			String imageName = "a1a1.png";
			String folderName = imagePath + "/" + "src/conf/images/back";
			makeDirs(folderName);
			String address = folderName + "/" + imageName;
			String imgFilePath = address;// 新生成的图片
			File file = new File(imgFilePath);
			OutputStream out = new FileOutputStream(file);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			System.out.println("根据Base64编码生成图片出错："+e.getMessage());
			return false;
		}
	}
	/*
	 * 根据文件夹路径和名称，判断是否存在此文件夹，如果不存在则新建文件夹
	 */
	public static boolean makeDirs(String folderName) {
        if (folderName == null || folderName.isEmpty()) {
            return false;
        }
        File folder = new File(folderName);
        return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
    }
	public static void main(String[] args) {
		try {
			ImageTransformation a = new ImageTransformation();
			String imagePath = System.getProperty("user.dir");//获取当前工程路径
			String imageName = "a1.png";
			String folderName = imagePath + "/" + "src/conf/images";
			String address =  folderName + "/" + imageName;
			System.out.println("address---"+address);
			String iamgeBase64Str = a.getBase64StrByImage(address);
			System.out.println("iamgeBase64Str---"+iamgeBase64Str);
			a.generateImage(iamgeBase64Str);
		} catch (Exception e) {
			System.out.println("图片处理出错："+e.getMessage());
		}
	}
}
