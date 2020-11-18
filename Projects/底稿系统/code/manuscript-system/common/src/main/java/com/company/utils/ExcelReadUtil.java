package com.company.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.company.exception.ExcelReadException;
import com.company.exception.ExcelWriteException;
import com.company.query.model.SmartQueryModel;

/**
 * 	读取excel工具类
 * 
 * @author fra.zj fra.yyc
 *
 */
public class ExcelReadUtil {
	public static Logger logger = LoggerFactory.getLogger(ExcelReadUtil.class);
	public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
	public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";

	public static final String EMPTY = "";
	public static final String POINT = ".";
	public static final String NOT_EXCEL_FILE = " : Not the Excel file!";
	public static final String PROCESSING = "Processing...";

	
	private static class LazyHolder {
		private static final ExcelReadUtil EXCEL_READ_UTIL = new ExcelReadUtil();
	}
	
	private ExcelReadUtil() {
	}
	
	/**
	 * 	实例化当前工具类
	 * @return
	 */
	public static final ExcelReadUtil getInstance() {
		return LazyHolder.EXCEL_READ_UTIL;
	}
	
	/**
	 * 	读取excel文件
	 * 
	 * @param path
	 * @return
	 */
	public Workbook readExcelToWb(String path) {
		if (path == null || EMPTY.equals(path)) {
			return null;
		} else {
			String postfix = getPostfix(path);
			logger.info("文件后缀名： {}", postfix);
			if (!EMPTY.equals(postfix)) {
				if (OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					return readXls(path);
				} else if (OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
					return readXlsx(path);
				}
			} else {
				logger.info(path + NOT_EXCEL_FILE);
			}
		}
		return null;
	}
	
	
	/**
	 * 	读取excel文件
	 * 
	 * @param path
	 * @return
	 */
	public Workbook readExcelToWb(String path,File file) {
		if (path == null || EMPTY.equals(path)) {
			return null;
		} else {
			String postfix = getPostfix(path);
			logger.info("文件后缀名： {}", postfix);
			if (!EMPTY.equals(postfix)) {
				if (OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					return readXls(file);
				} else if (OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
					return readXlsx(file);
				}
			} else {
				logger.info(path + NOT_EXCEL_FILE);
			}
		}
		return null;
	}
	
	/**
	 * 	获取Workbook
	 * 
	 * @param file
	 * @return
	 */
	public Workbook readExcelToWb(MultipartFile file) {
		if (file == null) {
			return null;
		} else {
			
			//文件名
			String fileName = file.getOriginalFilename();
			logger.info("文件名： {}", fileName);
			
			//获取文件名后缀
			String postfix = getPostfix(fileName);
			logger.info("文件后缀名： {}", postfix);
			
			if (!EMPTY.equals(postfix)) {
				if (OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					return readXls(file);
				} else if (OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
					return readXlsx(file);
				}
			} else {
				logger.info(fileName + NOT_EXCEL_FILE);
			}
		}
		return null;
	}
	
	/**
	 * 	获取excel扩展名
	 * 
	 * @param path
	 * @return
	 */
	public String getPostfix(String path) {
		if (path == null || EMPTY.equals(path.trim())) {
			return EMPTY;
		}
		if (path.contains(POINT)) {
			return path.substring(path.lastIndexOf(POINT) + 1, path.length());
		}
		return EMPTY;
	}
	
	/**
	 * 	获取XSSFWorkbook 2010 excel
	 * 
	 * @param file
	 * @return
	 * @throws ExcelReadException
	 */
	public XSSFWorkbook readXlsx(MultipartFile file) throws ExcelReadException {
		logger.info(PROCESSING + file.getOriginalFilename());
		XSSFWorkbook xssfWorkbook = null;
		try {
			xssfWorkbook = new XSSFWorkbook(file.getInputStream());
		} catch (IOException e) {
			logger.error("Fail:", e);
			throw new ExcelReadException("读取Xlsx(2010)文件失败：获取workbook失败。", e);
		}
		return xssfWorkbook;
	}

	/**
	 *	 获取HSSFWorkbook 2003-2007 excel
	 * 
	 * @param file
	 * @return
	 * @throws ExcelReadException
	 */
	public HSSFWorkbook readXls(MultipartFile file) throws ExcelReadException {
		logger.info(PROCESSING + file.getOriginalFilename());
		HSSFWorkbook hssfWorkbook = null;
		try {
			hssfWorkbook = new HSSFWorkbook(file.getInputStream());
		} catch (IOException e) {
			logger.error("Fail:", e);
			throw new ExcelReadException("读取Xls(2003-2007)文件失败：获取workbook失败。", e);
		}
		return hssfWorkbook;
	}

	/**
	 * 	获取XSSFWorkbook 2010 excel
	 * 
	 * @param path
	 * @return
	 * @throws ExcelReadException
	 */
	public XSSFWorkbook readXlsx(String path) throws ExcelReadException {
		logger.info(PROCESSING + path);
		XSSFWorkbook xssfWorkbook = null;
		InputStream is = null;
		try {
			is = new FileInputStream(path);
			xssfWorkbook = new XSSFWorkbook(is);
		} catch (IOException e) {
			logger.error("Fail:", e);
			throw new ExcelReadException("读取Xlsx(2010)文件失败：获取workbook失败。", e);
		}
		return xssfWorkbook;
	}
	
	/**
	 * 	获取XSSFWorkbook 2010 excel
	 * 
	 * @param path
	 * @return
	 * @throws ExcelReadException
	 */
	public XSSFWorkbook readXlsx(File file) throws ExcelReadException {
		logger.info(PROCESSING + file.getName());
		XSSFWorkbook xssfWorkbook = null;
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			xssfWorkbook = new XSSFWorkbook(is);
		} catch (IOException e) {
			logger.error("Fail:", e);
			throw new ExcelReadException("读取Xlsx(2010)文件失败：获取workbook失败。", e);
		}
		return xssfWorkbook;
	}

	/**
	 *	 获取HSSFWorkbook 2003-2007 excel
	 * 
	 * @param path
	 * @return
	 * @throws ExcelReadException
	 */
	public HSSFWorkbook readXls(String path) throws ExcelReadException {
		logger.info(PROCESSING + path);
		InputStream is = null;
		HSSFWorkbook hssfWorkbook = null;
		try {
			is = new FileInputStream(path);
			hssfWorkbook = new HSSFWorkbook(is);
		} catch (IOException e) {
			logger.error("Fail:", e);
			throw new ExcelReadException("读取Xls(2003-2007)文件失败：获取workbook失败。", e);
		}
		return hssfWorkbook;
	}
	
	/**
	 *	 获取HSSFWorkbook 2003-2007 excel
	 * 
	 * @param path
	 * @return
	 * @throws ExcelReadException
	 */
	public HSSFWorkbook readXls(File file) throws ExcelReadException {
		logger.info(PROCESSING + file.getName());
		InputStream is = null;
		HSSFWorkbook hssfWorkbook = null;
		try {
			is = new FileInputStream(file);
			hssfWorkbook = new HSSFWorkbook(is);
		} catch (IOException e) {
			logger.error("Fail:", e);
			throw new ExcelReadException("读取Xls(2003-2007)文件失败：获取workbook失败。", e);
		}
		return hssfWorkbook;
	}

	/**
	 * 	获取excel sheet总数
	 * 
	 * @param workbook
	 * @return
	 */
	public int getSheetsCount(Workbook workbook) {
		return workbook.getNumberOfSheets();
	}

	/**
	 * 	获取指定sheet页
	 * 
	 * @param workbook
	 * @param number
	 * @return
	 */
	public Sheet getSheet(Workbook workbook, int number) {
		return workbook.getSheetAt(number);
	}

	/**
	 * 	总行数
	 * 
	 * @param sheet
	 * @param number
	 * @return
	 */
	public int getRowNum(Sheet sheet) {
		return sheet.getLastRowNum();
	}
	
	/**
	 * 	获取指定row行
	 * 
	 * @param sheet
	 * @param number
	 * @return
	 */
	public Row getRow(Sheet sheet, int number) {
		return sheet.getRow(number);
	}
	
	/**
	 * 	传入字符串 去除空格后 验证非空
	 * @param str
	 * @return
	 */
	public boolean isNullOrEmptyString(Object obj){
		if(obj != null && obj.toString().trim().length() > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 	传入字符串 去除空格后 验证非空
	 * @param str
	 * @return
	 */
	public boolean isNumber(String obj){
		boolean bool = false;
		if(obj!=null){
			bool = Pattern.compile("^-?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)$")
					.matcher(obj).find();
		}
		return bool;
	}
	
	/**
	 * 	获取单元格数据
	 * @param cell
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String getCellValue(Cell cell) {
		  String value = "";
		  if (cell != null) {
		   // 以下是判断数据的类型
		   switch (cell.getCellType()) {
		   
		   case HSSFCell.CELL_TYPE_NUMERIC: // 数字
		       value = cell.getNumericCellValue() + "";
		       if (HSSFDateUtil.isCellDateFormatted(cell)) {
		            Date date = cell.getDateCellValue();
		            if (date != null) {
		            value = new SimpleDateFormat("yyyy-MM-dd").format(date);
		            } else {
		               value = "";
		            }
		       } else {
		             value = new DecimalFormat("0").format(cell.getNumericCellValue());
		       }
		    break;
		   case HSSFCell.CELL_TYPE_STRING: // 字符串
		        value = cell.getStringCellValue();
		        break;
		   case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
		        value = cell.getBooleanCellValue() + "";
		        break;
		   case HSSFCell.CELL_TYPE_FORMULA: // 公式
		        value = cell.getCellFormula() + "";
		        break;
		   case HSSFCell.CELL_TYPE_BLANK: // 空值
		        value = "";
		        break;
		   case HSSFCell.CELL_TYPE_ERROR: // 故障
		        value = "非法字符";
		        break;
		   default:
		       value = "未知类型";
		      break;
		   }
		  }
		  return value.trim();
	}
	
	/**
	 * 	导入文件到数据库表
	 * @param file 					导入文件
	 * @param sheetIndex 			获取sheet页索引值
	 * @param excelReadHandle 		导入数据处理逻辑接口
	 * @return 						该sheet页导入数据的验证信息
	 * @throws ExcelReadException
	 */
	public List<String> fileToData(MultipartFile file, int sheetIndex, ExcelReadHandle excelReadHandle) throws ExcelReadException{
		
			//	读取excel文件并获取workbook对象
			Workbook wb = null;
			wb = readExcelToWb(file);
			if(wb == null) {
				throw new ExcelReadException("获取workbook对象失败：workbook对象为空。");
			}
			//	查询sheet页总数
			int sheetCount = getSheetsCount(wb);
			if(sheetIndex>(sheetCount-1)) {
				throw new ExcelReadException("获取sheet页索引值异常：大于sheet页总数。");
			}
			//	通过sheet页索引值获取sheet对象
			Sheet sheet = wb.getSheetAt(sheetIndex);
			//	交与excelReadHandle处理sheet读取数据并入相关数据库
			return excelReadHandle.sheetHandle(sheet);
	}
	
	/**
	 * 	通过导出模板与导出数据合并生成导出文件并输出到页面流（下载）
	 * @param tempPath				导出模板文件路径
	 * @param list					导出数据
	 * @param sheetIndex			获取sheet页索引值
	 * @param out	               	输出到页面流
	 * @param excelWriteHandle		导出数据处理逻辑接口
	 * @throws ExcelWriteException
	 */
	public void exportExcel(
			String tempPath, 
			List<SmartQueryModel> list, 
			int sheetIndex,
			OutputStream out,
			ExcelWriteHandle excelWriteHandle) throws ExcelWriteException {
		//	读取excel文件并获取workbook对象
		Workbook wb = null;
		wb = readExcelToWb(tempPath);
		if(wb == null) {
			throw new ExcelWriteException("获取workbook对象失败：workbook对象为空。");
		} 
		//	查询sheet页总数
		int sheetCount = getSheetsCount(wb);
		if(sheetIndex>(sheetCount-1)) {
			throw new ExcelWriteException("获取sheet页索引值异常：大于sheet页总数。");
		}
		//	通过sheet页索引值获取sheet对象
		Sheet sheet = wb.getSheetAt(sheetIndex);
		//	交与excelWriteHandle处理sheet和数据列表整合输出到sheet对象中
		excelWriteHandle.sheetAndListHandle(sheet, wb, list);
        //	将表格赋给页面输出流 
		try {
			wb.write(out);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw new ExcelWriteException("将表格赋给页面输出流失败。", e);
		} finally {
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
					throw new ExcelWriteException("页面输出流 关闭失败。", e);
				}
			}
		} 
		
	}
		
	
	
	/**
     * 	获取单元格数据内容为字符串类型的数据
     * 
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    @SuppressWarnings("deprecation")
	public String getStringCellValue(Cell cell) {
        String strCell = "";
        if(cell != null) {
	        switch (cell.getCellType()) {
	        case HSSFCell.CELL_TYPE_STRING:
	            strCell = cell.getStringCellValue();
	            break;
	        case HSSFCell.CELL_TYPE_NUMERIC:
	            strCell = String.valueOf(cell.getNumericCellValue());
	            break;
	        case HSSFCell.CELL_TYPE_BOOLEAN:
	            strCell = String.valueOf(cell.getBooleanCellValue());
	            break;
	        case HSSFCell.CELL_TYPE_BLANK:
	            strCell = "";
	            break;
	        default:
	            strCell = "";
	            break;
	        }
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        if (cell == null) {
            return "";
        }
        return strCell;
    }
	
	
	
	
	public static int QDIIRB_SHEET1_611 = 6;
	public static int QDIIRB_SHEET1_612 = 10;
	
	public static int QDIIRB_SHEET1_698_ROW = 14;
	public static int QDIIRB_SHEET1_698_CELLCOUNT = 15;
	

	public static void main(String[] args) {
		ExcelReadUtil eru = ExcelReadUtil.getInstance();
		ExcelWriteUtil ewu = ExcelWriteUtil.getInstance();
		String path = "d:/test.xlsx";
		String exportPath = "d:/test1.xlsx";
		
		List<SmartQueryModel> list = new ArrayList<SmartQueryModel>();
		
		for(int i=0;i<2;i++){
			SmartQueryModel qt = new SmartQueryModel();
			qt.setProperty1("11");
			qt.setProperty2("21");
			qt.setProperty3("31");
			qt.setProperty4("41");
			qt.setProperty5("51");
			qt.setProperty6("61");
			qt.setProperty7("71");
			qt.setProperty8("81");
			qt.setProperty9("91");
			qt.setProperty10("101");
			qt.setProperty11("111");
			qt.setProperty12("121");
			qt.setProperty13("131");
			qt.setProperty14("141");
			qt.setProperty15("151");
			list.add(qt);
		}
		
		try {
			//1.读取模板
			Workbook wb = new XSSFWorkbook();
			wb = eru.readExcelToWb(path);
			//查询sheet页总数
			int sheetCount = eru.getSheetsCount(wb);
			//1.查询数据
			//2.将list填入指定位置
			//第一页
			XSSFSheet sheet = (XSSFSheet)wb.getSheetAt(0);
			for(int i=0;i<list.size();i++){
				XSSFRow row = ewu.createRow(sheet, QDIIRB_SHEET1_698_ROW);
				ewu.createCell(row,list.get(i),0,QDIIRB_SHEET1_698_CELLCOUNT);
			}
			ewu.saveExcel((XSSFWorkbook)wb,exportPath);
			
		} catch (ExcelReadException e) {
			e.printStackTrace();
		}
	}
    
}

