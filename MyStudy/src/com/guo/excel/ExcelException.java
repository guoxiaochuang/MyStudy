package com.guo.excel;

/**
 * Excel异常类
 *
 * @author guoxiaochuang
 * @email guoxiaochuang@boco.com.cn
 * @version v1.0
 * @time 2020年9月4日
 * @modify <BR/>
 *         修改内容：<BR/>
 *         修改人员：<BR/>
 *         修改时间：<BR/>
 */
@SuppressWarnings("serial")
public class ExcelException extends Exception {

	/**
	 * 自定义异常类
	 */
	public ExcelException() {
	}

	/**
	 * 
	 * @param message
	 */
	public ExcelException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param cause
	 */
	public ExcelException(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public ExcelException(String message, Throwable cause) {
		super(message, cause);
	}

}
