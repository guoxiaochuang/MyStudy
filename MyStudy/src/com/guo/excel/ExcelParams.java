package com.guo.excel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Excel参数集合
 */
public class ExcelParams<T> {
    final static String excel2003L = ".xls";
    final static String excel2007U = ".xlsx";
    /**
     * 导入或导出的类集合
     */
    private List<T> list;
    /**
     * 数据对应的实体类
     */
    private Class<T> entityClass;

    /**
     * 输出流
     */
    private OutputStream outputStream;

    /**
     * 输入流-用于直接从数据流中解析excel文件
     */
    private InputStream inputStream;

    /**
     * 文件名
     */
    private String fileName;
    /**
     * sheetName
     */
    private String sheetName;
    /**
     * 类的英文属性和Excel中的中文列名的对应关系
     */
    private LinkedHashMap<String, String> fieldMap;
    /**
     * 如果要分页，需指定分页大小
     */
    private int sheetSize;

    /**
     * 日期转换格式，如果不写，默认为yyyy-MM-dd HH:mm:ss
     */
    private String dateformat;

    /**
     *
     *
     * @param fileName
     *            文件全路径名称
     * @param fieldMap
     *            类的英文属性和Excel中的中文列名的对应关系，key为中文列名，value为英文属性
     * @throws IOException
     */
    public ExcelParams(String fileName, LinkedHashMap<String, String> fieldMap) throws IOException {
        this.fileName = fileName;
        this.fieldMap = fieldMap;
    }

    public ExcelParams(String fileName, InputStream inputStreamParam, LinkedHashMap<String, String> fieldMap)
            throws IOException {
        this.fileName = fileName;
        this.fieldMap = fieldMap;
        this.inputStream = inputStreamParam;
    }

    /**
     * @return the list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * @param list
     *            the list to set
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * @return the entityClass
     */
    public Class<T> getEntityClass() {
        return entityClass;
    }

    /**
     * @param entityClass
     *            the entityClass to set
     */
    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * @return the outputStream
     */
    public OutputStream getOutputStream() {
        return outputStream;
    }

    /**
     * @param outputStream
     *            the outputStream to set
     */
    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * 输入流-用于直接从数据流中解析excel文件
     *
     * @return
     */
    public InputStream getInputStream() {
        return inputStream;
    }

    /**
     * 输入流-用于直接从数据流中解析excel文件
     *
     * @param inputStream
     */
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @return the sheetName
     */
    public String getSheetName() {
        return sheetName;
    }

    /**
     * @param sheetName
     *            the sheetName to set
     */
    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    /**
     * @return the fieldMap
     */
    public LinkedHashMap<String, String> getFieldMap() {
        return fieldMap;
    }

    /**
     * @param fieldMap
     *            the fieldMap to set
     */
    public void setFieldMap(LinkedHashMap<String, String> fieldMap) {
        this.fieldMap = fieldMap;
    }

    /**
     * @return the sheetSize
     */
    public int getSheetSize() {
        return sheetSize;
    }

    /**
     * @param sheetSize
     *            the sheetSize to set
     */
    public void setSheetSize(int sheetSize) {
        this.sheetSize = sheetSize;
    }

    /**
     * @return the dateformat
     */
    public String getDateformat() {
        return dateformat;
    }

    /**
     * @param dateformat
     *            the dateformat to set
     */
    public void setDateformat(String dateformat) {
        this.dateformat = dateformat;
    }
}
