package com.guo.compress;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.xml.sax.InputSource;

import sun.misc.BASE64Encoder;

/**
 * 压缩和解压字符串
 * 
 * @author guoxiaochuang
 * @Time 2016年02月23日20:54:16
 */
public class StringCompress {
	// 压缩字符串
	public String compressData(String data) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			DeflaterOutputStream zos = new DeflaterOutputStream(bos);
			zos.write(data.getBytes());
			zos.close();
			return new String(getenBASE64inCodec(bos.toByteArray()));
		} catch (Exception ex) {
			ex.printStackTrace();
			return "ZIP_ERR";
		}
	}

	// 使用apche codec对数组进行encode
	public static String getenBASE64inCodec(byte[] b) {
		if (b == null)
			return null;
		return new String((new Base64()).encode(b));
	}

	// 解码字符串
	public String decompressData(String encdata) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			InflaterOutputStream zos = new InflaterOutputStream(bos);
			zos.write(getdeBASE64inCodec(encdata));
			zos.close();
			return new String(bos.toByteArray());
		} catch (Exception ex) {
			ex.printStackTrace();
			return "UNZIP_ERR";
		}
	}

	// base64转码为string
	public static byte[] getdeBASE64inCodec(String s) {
		if (s == null)
			return null;
		return new Base64().decode(s.getBytes());
	}

	public static void main(String[] args) {
		StringCompress compress = new StringCompress();
		String compString = compress.compressData("中华人民共和国");
		System.out.println(compString);

		String decompString = compress.decompressData(compString);
		System.out.println(decompString);

	}
}
