package com.guo.excel;

import co.yixiang.modules.utils.helper.TimeFormatHelper;
import co.yixiang.modules.utils.util.FieldUtil;
import co.yixiang.utils.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.*;

public class ExcelImporter {
    /**
     * 导入方法，根据单个sheet名导入，没有sheet名则默认取第一个sheet
     *
     * @param params
     *            params必需字段（实体类entityclass)
     * @return List<T> 返回数据对应实体类的列表
     * @throws ExcelException
     */
    public static <T> List<T> excelToList(ExcelParams<T> params) throws ExcelException {

        // 定义要返回的list
        List<T> resultList = new ArrayList<T>();
        LinkedHashMap<String, String> fieldMap = params.getFieldMap();
        Class<T> entityClass = params.getEntityClass();
        String dateformat = params.getDateformat();
        try {
            // 获取工作簿
            Sheet[] sheets = getSheet(params);
            Sheet sheet = sheets[0];
            // 获取有效列数
            int realRows = getRealRow(sheet);
            Row firstRow = sheet.getRow(0);
            // 获取列名
            String[] excelFieldNames = getFiledList(firstRow, fieldMap);
            // 将列名和列号放入Map中,这样通过列名就可以拿到列号
            LinkedHashMap<String, Integer> colMap = new LinkedHashMap<String, Integer>();
            for (int i = 0; i < excelFieldNames.length; i++) {
                colMap.put(excelFieldNames[i], firstRow.getCell(i).getColumnIndex());
            }

            // 将sheet转换为list
            for (int i = 1; i <= realRows; i++) {
                // 新建要转换的对象
                T entity = entityClass.newInstance();
                Row row2 = sheet.getRow(i);
                // 给对象中的字段赋值
                for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
                    // 获取中文字段名
                    String cnNormalName = entry.getKey();
                    // 获取英文字段名
                    String enNormalName = entry.getValue();
                    // 根据中文字段名获取列号
                    int col = colMap.get(cnNormalName);

                    // 获取当前单元格中的内容
                    String content = getCellValueByCell(row2.getCell(col));

                    // 给对象赋值
                    FieldUtil.setFieldValueByName(enNormalName, content, entity, dateformat);
                }

                resultList.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 如果是ExcelException，则直接抛出
            if (e instanceof ExcelException) {
                throw (ExcelException) e;

                // 否则将其它异常包装成ExcelException再抛出
            } else {
                e.printStackTrace();
                throw new ExcelException("导入Excel失败");
            }
        }
        return resultList;
    }

    /**
     * 描述：供导入时使用的workbook格式自适应方法
     *
     * @param inStr
     *            导入流
     * @param fileName
     *            文件名
     * @return workbook 对应的Workbook类型
     * @throws Exception
     */
    private static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (ExcelParams.excel2003L.equals(fileType)) {
            wb = new HSSFWorkbook(inStr); // 2003-
        } else if (ExcelParams.excel2007U.equals(fileType) || ".csv".equals(fileType)) {
            wb = new XSSFWorkbook(inStr); // 2007+
        } else {
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }

    private static <T> Sheet[] getSheet(ExcelParams<T> params) throws Exception {
        String fileName = params.getFileName();
        InputStream in = params.getInputStream();
        if (params.getInputStream() == null) {
            in = new FileInputStream(fileName);
        }

        // 根据Excel数据源创建WorkBook
        Workbook wb = getWorkbook(in, fileName);
        String sheetName = params.getSheetName();
        int sheetsize = wb.getNumberOfSheets();
        Sheet[] sheet = new Sheet[sheetsize];
        if (sheetName == null || sheetName.trim().equals("")) {
            for (int i = 0; i < sheetsize; i++) {
                sheet[i] = wb.getSheetAt(i);
            }
        } else {
            sheet[0] = wb.getSheet(sheetName);
        }
        in.close();
        return sheet;
    }

    private static int getRealRow(Sheet sheet) throws ExcelException {
        // 获取工作表的有效行数
        int realRows = 0;
        if (sheet.getLastRowNum() == 1) {
            return 1;
        }
        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {

            int nullCols = 0;
            Row row = sheet.getRow(i);
            if (row == null) {
                // 遇到空行就不读了
                break;
            }
            // for (int j = 0; j < row.getRowNum(); j++) {
            for (int j = 0; j <= row.getLastCellNum(); j++) {
                Cell currentCell = row.getCell(j);
                String cellValue = getCellValueByCell(currentCell);
                if (currentCell == null || "".equals(cellValue)) {
                    nullCols++;
                }
            }

            // if (nullCols == sheet.getLastRowNum() - sheet.getFirstRowNum()) {
            if (nullCols == row.getLastCellNum() - row.getFirstCellNum()) {
                break;
            } else {
                realRows++;
            }
        }

        // 如果Excel中没有数据则提示错误
        if (realRows <= 1) {
            throw new ExcelException("Excel文件中没有任何数据");
        }
        return realRows - 1;

    }

    /**
     * 获取Excel中的有效列名
     *
     * @param firstRow
     * @param fieldMap
     * @return
     * @throws ExcelException
     */
    private static String[] getFiledList(Row firstRow, LinkedHashMap<String, String> fieldMap) throws ExcelException {
        List<String> excelFieldList;
        int length = firstRow.getLastCellNum() - firstRow.getFirstCellNum();
        String[] excelFieldNames = new String[length];

        // 获取Excel中的列名
        for (int i = 0; i < length; i++) {
            // 防止报空指针错误
            if (firstRow.getCell(i).getStringCellValue() == null) {
                excelFieldNames[i] = "";
            }
            excelFieldNames[i] = firstRow.getCell(i).getStringCellValue().replaceAll(" ", "");
        }

        // 判断需要的字段在Excel中是否都存在
        boolean isExist = true;
        excelFieldList = Arrays.asList(excelFieldNames);
        for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
            String cnName = entry.getKey();
            if (!excelFieldList.contains(cnName)) {
                isExist = false;
                continue;
            }
        }

        // 如果有列名不存在，则抛出异常，提示错误
        if (!isExist) {
            throw new ExcelException("Excel中缺少必要的字段，或字段名称有误");
        }
        return excelFieldNames;
    }

    // 获取单元格各类型值，返回字符串类型
    private static String getCellValueByCell(Cell cell) {
        // 判断是否为null或空串
        if (cell == null || cell.toString().trim().equals("")) {
            return "";
        }
        String cellValue = "";
        CellType cellType = cell.getCellTypeEnum();

        switch (cellType) {
            case STRING: // 字符串类型
                cellValue = cell.getStringCellValue().trim();
                cellValue = StringUtils.isEmpty(cellValue) ? "" : cellValue;
                break;
            case BOOLEAN: // 布尔类型
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case NUMERIC: // 数值类型
                if (HSSFDateUtil.isCellDateFormatted(cell)) { // 判断日期类型
                    cellValue = TimeFormatHelper.getFormatDate(cell.getDateCellValue(), TimeFormatHelper.TIME_FORMAT_A);
                } else { // 否
                    cellValue = new DecimalFormat("#.######").format(cell.getNumericCellValue());
                }
                break;
            default: // 其它类型，取空串吧
                cellValue = "";
                break;
        }
        return cellValue;
    }
}
