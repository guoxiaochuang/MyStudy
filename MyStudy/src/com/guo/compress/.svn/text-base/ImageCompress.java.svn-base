package com.guo.compress;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图片压缩
 * 
 * @author guoxiaochuang
 * @Time 2016年02月23日14:52:32
 */
public class ImageCompress {
	private Image img;
	private int width;
	private int height;

	/**
	 * 构造函数
	 */
	public ImageCompress(String fileName) throws IOException {
		File file = new File(fileName);// 读入文件
		img = ImageIO.read(file); // 构造Image对象
		width = img.getWidth(null); // 得到源图宽
		height = img.getHeight(null); // 得到源图长
	}

	/**
	 * 按照宽度还是高度进行压缩
	 * 
	 * @param w
	 *            int 最大宽度
	 * @param h
	 *            int 最大高度
	 */
	public void resizeFix(String filePath, String fileName, int w, int h)
			throws IOException {
		if (width / height > w / h) {
			resizeByWidth(filePath, fileName, w);
		} else {
			resizeByHeight(filePath, fileName, h);
		}
	}

	/**
	 * 以宽度为基准，等比例放缩图片
	 * 
	 * @param w
	 *            int 新宽度
	 */
	public void resizeByWidth(String filePath, String fileName, int w)
			throws IOException {
		int h = (int) (height * w / width);
		resize(filePath, fileName, w, h);
	}

	/**
	 * 以高度为基准，等比例缩放图片
	 * 
	 * @param h
	 *            int 新高度
	 */
	public void resizeByHeight(String filePath, String fileName, int h)
			throws IOException {
		int w = (int) (width * h / height);
		resize(filePath, fileName, w, h);
	}

	/**
	 * 强制压缩/放大图片到固定的大小
	 * 
	 * @param w
	 *            int 新宽度
	 * @param h
	 *            int 新高度
	 */
	public void resize(String filePath, String fileName, int w, int h)
			throws IOException {
		// SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
		BufferedImage image = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_RGB);
		image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
		String file = filePath + "/" + fileName;
		File destFile = new File(file);
		FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
		// 可以正常实现bmp、png、gif转jpg
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(image);
		encoder.encode(image, jep); // JPEG编码
		out.close();
	}

	public static void saveImage() {
		try {
			// 这是你的源文件，本身是存在的
			File beforefile = new File( "/Users/guoxiaochuang/workspace/workspace-mine/MyStudy1/src/conf/images/a1.png");

			// 这是你要保存之后的文件，是自定义的，本身不存在
			File afterfile = new File( "/Users/guoxiaochuang/workspace/workspace-mine/MyStudy1/src/conf/images/back/a3.png");

			// 定义文件输入流，用来读取beforefile文件
			FileInputStream fis = new FileInputStream(beforefile);
			System.out.println("beforefile--"+beforefile);
			// 定义文件输出流，用来把信息写入afterfile文件中
			FileOutputStream fos = new FileOutputStream(afterfile);

			// 文件缓存区
			byte[] b = new byte[1024];
			// 将文件流信息读取文件缓存区，如果读取结果不为-1就代表文件没有读取完毕，反之已经读取完毕
			while (fis.read(b) != -1) {
				// 将缓存区中的内容写到afterfile文件中
				fos.write(b);
				fos.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		saveImage();

		// System.out.println("开始：" + new Date().toLocaleString());
		// ImageCompress imgCom = new
		// ImageCompress("/Users/guoxiaochuang/workspace/workspace-mine/MyStudy1/src/conf/images/a1.png");
		// String filePath =
		// "/Users/guoxiaochuang/workspace/workspace-mine/MyStudy1/src/conf/images/back";
		// String fileName = "a3.png";
		// imgCom.resizeFix(filePath, fileName, 400, 400);
		// System.out.println("结束：" + new Date().toLocaleString());
		//
		// File file1 = new
		// File("/Users/guoxiaochuang/workspace/workspace-mine/MyStudy1/src/conf/images/a1.png");
		// File file2 = new
		// File("/Users/guoxiaochuang/workspace/workspace-mine/MyStudy1/src/conf/images/back/a1.png");
		// if (file1.exists() && file1.isFile()){
		// System.out.println(file1.length());
		// }
		// if (file2.exists() && file2.isFile()){
		// System.out.println(file2.length());
		// }

	}
}
