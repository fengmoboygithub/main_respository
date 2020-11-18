package com.company.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.company.exception.ExcelReadException;
import com.company.query.model.SmartQueryModel;

/**
 * 导出excel工具类
 * 
 * @author fra.zj
 *
 */
public class ExcelWriteUtil {
	public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
	public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";

	private static class LazyHolder {
		private static final ExcelWriteUtil EXCEL_WRITE_UTIL = new ExcelWriteUtil();
	}

	private ExcelWriteUtil() {
	}

	/**
	 * 实例化当前工具类
	 * 
	 * @return
	 */
	public static final ExcelWriteUtil getInstance() {
		return LazyHolder.EXCEL_WRITE_UTIL;
	}

	/**
	 * 生成输出流用于浏览器下载
	 * 
	 * @param request
	 * @param response
	 * @param excelType
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void outputStream(Workbook workbook, HttpServletRequest request, HttpServletResponse response,
			String excelType) throws IOException {
		// 命名
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmsss");
		String filename = sdf.format(new Date()) + excelType;
		// 设置文件MIME类型
		response.reset(); // 必要地清除response中的缓存信息
		response.setContentType(request.getServletContext().getMimeType(filename));
		response.setContentType("application/msexcel;charset=utf-8");
		response.setHeader("name", filename);
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		response.setDateHeader("Expires", 0);
		response.setHeader("Content-disposition",
				"attachment; filename=\"" + URLEncoder.encode(filename, "UTF-8") + "\"");
		// 网络下载代码
		workbook.write(response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

	/**
	 * 导出到指定文件夹
	 * 
	 * @param request
	 * @param response
	 * @param listArray
	 * @param excelType
	 * @throws IOException
	 */
	public <T> void downloadExcelFile(HttpServletRequest request, HttpServletResponse response, List<T> listArray,
			String excelType) throws IOException {
		// 生成workbook对象
		Workbook workbook = exportExcel(listArray, excelType);
		// =========本地文件生成===========
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmsss");
		String filename = sdf.format(new Date()) + excelType;
		FileOutputStream fileOut = new FileOutputStream(filename);
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
	}

	/**
	 * 
	 * @param listArray
	 * @param fileType
	 * @return
	 * @throws IOException
	 */
	public <T> Workbook exportExcel(List<T> listArray, String fileType) throws IOException {
		Workbook workbook = null; // 后缀xls excel2003
		// if (StringUtils.isNoneBlank(fileType)) {
		// if (fileType.contains(OFFICE_EXCEL_2003_POSTFIX)) {
		// workbook = new HSSFWorkbook(); //后缀xls excel2003
		// } else if (fileType.contains(OFFICE_EXCEL_2010_POSTFIX)) {
		// workbook = new XSSFWorkbook(); //后缀xlsx excel2010及高版本
		// }
		// } else {
		// workbook = new HSSFWorkbook();
		// }
		//
		// //判断是否为空
		// if (listArray != null && listArray.size() > 0) {
		// //设置sheet名称
		// Sheet sheet =
		// workbook.createSheet(getClassModelDesc(listArray.get(0)));
		// Row row = sheet.createRow((int) 0);
		// row.setHeightInPoints(20);
		// row.setHeight((short) 360);
		// Object modelView = listArray.get(0);
		// Field[] fields = modelView.getClass().getDeclaredFields();
		//
		//
		// //==================数据栏============================
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Cell contentCell = null;
		// for (int i = 0; i < listArray.size(); i++) {
		// //设置行
		// row = sheet.createRow(i + 1);
		// row.setHeight((short) 300);
		// //设置列数据
		// if (fields != null && fields.length > 0) {
		// Object model = listArray.get(i);
		// int dataIndex = 0;
		// //依次取各字段的值
		// for (Field field : fields) {
		// //根据字段名称取值
		// Object modelValue = getClassValue(model, field.getName());
		// //有注解标识则创建单元格
		// String modelProperty = getModelPropertyDesc(field);
		// if (StringUtils.isNotBlank(modelProperty)) {
		// contentCell = row.createCell(dataIndex++);
		// //针对日期数据进行特别处理
		// if (modelValue instanceof java.util.Date) {
		// modelValue = sdf.format(modelValue);
		// }
		// if (modelValue instanceof java.sql.Date) {
		// modelValue = sdf.format(modelValue);
		// }
		// contentCell.setCellValue((modelValue != null) ? modelValue.toString()
		// : "");
		// contentCell.setCellStyle(contentCellStyle);
		// }
		// }
		// }
		// }
		// } else {
		// //设置sheet名称
		// workbook.createSheet("new sheet");
		// }
		return workbook;
	}

	/**
	 * 保存工作薄
	 * 
	 * @param wb
	 */
	public void saveExcel(XSSFWorkbook wb, String path) {
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(path);
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 	从第几行插入
	 * 
	 * @param sheet
	 * @param rowIndex
	 * @return
	 */
	public XSSFRow createRow(XSSFSheet sheet, int rowIndex) {
		XSSFRow row = null;
		if (sheet.getRow(rowIndex) != null) {
			int lastRowNo = sheet.getLastRowNum();
			sheet.shiftRows(rowIndex, lastRowNo, rowIndex);
		}
		row = sheet.createRow(rowIndex);
		return row;
	}

	/**
	 *	 创建要出入的行中单元格(根据自定义查询对象实现)
	 * 
	 * @param row
	 * @param qt
	 * @param cellCount
	 * @return
	 */
	public void createCell(XSSFRow row, SmartQueryModel sqm, int startCell, int cellCount) {
//		XSSFCell cell = row.createCell((short) 0);
		for (int i = startCell; i <= cellCount; i++) {
			row.createCell(i).setCellValue(getFieldValueByFieldName("property" + i, sqm));
		}
//		return cell;
	}
	
	
	/**
	 *	 创建要出入的行中单元格(根据自定义查询对象实现)
	 * 
	 * @param row
	 * @param qt
	 * @param cellCount
	 * @return
	 */
	public void createCell(XSSFRow row, SmartQueryModel sqm, int startCell, int cellCount, CellStyle cellStyle) {
		for (int i = startCell; i <= cellCount; i++) {
			row.createCell(i).setCellValue(getFieldValueByFieldName("property" + i, sqm));
			row.getCell(i).setCellStyle(cellStyle);
		}
	}

	/**
	 * 复制单元格
	 * 
	 * @param currentSheet sheet页
	 * @param startRow     开始行
	 * @param endRow       结束行
	 * @param pPosition    目标位置
	 */
	public void copyRows(Sheet currentSheet, int startRow, int endRow, int pPosition) {
		int pStartRow = startRow - 1;
		int pEndRow = endRow - 1;
		int targetRowFrom;
		int targetRowTo;
		int columnCount;
		CellRangeAddress region = null;
		int i;
		int j;

		if (pStartRow == -1 || pEndRow == -1) {
			return;
		}

		for (i = 0; i < currentSheet.getNumMergedRegions(); i++) {
			region = currentSheet.getMergedRegion(i);
			if ((region.getFirstRow() >= pStartRow) && (region.getLastRow() <= pEndRow)) {
				targetRowFrom = region.getFirstRow() - pStartRow + pPosition;
				targetRowTo = region.getLastRow() - pStartRow + pPosition;
				CellRangeAddress newRegion = region.copy();
				newRegion.setFirstRow(targetRowFrom);
				newRegion.setFirstColumn(region.getFirstColumn());
				newRegion.setLastRow(targetRowTo);
				newRegion.setLastColumn(region.getLastColumn());
				currentSheet.addMergedRegion(newRegion);
			}
		}

		for (i = pStartRow; i <= pEndRow; i++) {
			XSSFRow sourceRow = (XSSFRow) currentSheet.getRow(i);
			columnCount = sourceRow.getLastCellNum();
			if (sourceRow != null) {
				XSSFRow newRow = (XSSFRow) currentSheet.createRow(pPosition - pStartRow + i);
				newRow.setHeight(sourceRow.getHeight());
				for (j = 0; j < columnCount; j++) {
					XSSFCell templateCell = sourceRow.getCell(j);
					if (templateCell != null) {
						XSSFCell newCell = newRow.createCell(j);
						copyCell(templateCell, newCell);
					}
				}
			}
		}
	}

	/**
	 * 复制单元格
	 * 
	 * @param srcCell
	 * @param distCell
	 */
	public static void copyCell(XSSFCell srcCell, XSSFCell distCell) {
		distCell.setCellStyle(srcCell.getCellStyle());
		if (srcCell.getCellComment() != null) {
			distCell.setCellComment(srcCell.getCellComment());
		}
		int srcCellType = srcCell.getCellType();
		distCell.setCellType(srcCellType);
		if (srcCellType == XSSFCell.CELL_TYPE_NUMERIC) {
			if (DateUtil.isCellDateFormatted(srcCell)) {
				distCell.setCellValue(srcCell.getDateCellValue());
			} else {
				distCell.setCellValue(srcCell.getNumericCellValue());
			}
		} else if (srcCellType == XSSFCell.CELL_TYPE_STRING) {
			distCell.setCellValue(srcCell.getRichStringCellValue());
		} else if (srcCellType == XSSFCell.CELL_TYPE_BLANK) {
			// nothing21
		} else if (srcCellType == XSSFCell.CELL_TYPE_BOOLEAN) {
			distCell.setCellValue(srcCell.getBooleanCellValue());
		} else if (srcCellType == XSSFCell.CELL_TYPE_ERROR) {
			distCell.setCellErrorValue(srcCell.getErrorCellValue());
		} else if (srcCellType == XSSFCell.CELL_TYPE_FORMULA) {
			distCell.setCellFormula(srcCell.getCellFormula());
		} else { // nothing29

		}
	}
	
	/**
	 * 	合并单元格
	 * @param sheet
	 * @param firstRow
	 * @param lastRow
	 * @param firstCol
	 * @param lastCol
	 */
	public CellRangeAddress merge(Sheet sheet,int firstRow, int lastRow, int firstCol, int lastCol) {
		CellRangeAddress region = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
		sheet.addMergedRegion(region);
		return region;
	}
	
	/**
	 *	设置单元格居中
	 * @param wb
	 * @return
	 */
	public XSSFCellStyle alignCenter(Workbook wb) {
		XSSFCellStyle cellStyle = (XSSFCellStyle)wb.createCellStyle(); 
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		return cellStyle;
	}
	
	
	/**
	 * 	自动换行
	 * @param wb
	 * @return
	 */
	public XSSFCellStyle wrapText(Workbook wb) {
		XSSFCellStyle cellStyle=(XSSFCellStyle) wb.createCellStyle();    
		cellStyle.setWrapText(true);
		return cellStyle;
	}
	
	/**
	 * 	设置字体为粗体
	 * @param wb
	 * @return
	 */
	public XSSFCellStyle boldFont(Workbook wb) {
		XSSFCellStyle cellStyle=(XSSFCellStyle) wb.createCellStyle();    
		XSSFFont font = (XSSFFont)wb.createFont();
		font.setBold(true);
		cellStyle.setFont(font);
		return cellStyle;
	}
	
	/**
	 * 写入净值数据截止日期
	 * 
	 * @param cell
	 * @param date
	 * @return
	 */
	public Cell setNetWorthEndDate(Cell cell, String date) {
		cell.setCellValue("净值数据截止日期：" + date);
		return cell;
	}

	/**
	 * 根据属性名获取属性值
	 * 
	 * @param fieldName
	 * @param object
	 * @return
	 */
	public String getFieldValueByFieldName(String fieldName, Object object) {
		try {
			Field field = object.getClass().getDeclaredField(fieldName);
			// 设置对象的访问权限，保证对private的属性的访问
			field.setAccessible(true);
			return (String) field.get(object);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 设置边框样式
	 * @param top	是否加上边框
	 * @param bottom	是否加下边框
	 * @param left	是否加左边框
	 * @param right	是否加右边框
	 * @param borderType	边框类型(THIN:薄边框) 待补充
	 * @param cellStyle 样式对象
	 * @return
	 */
	public CellStyle SettingBorder(boolean top, boolean bottom, boolean left, boolean right, String borderType, CellStyle cellStyle) {
		BorderStyle border = null;
		if("THIN".equals(borderType)) {
			border = BorderStyle.THIN;
		}
		if(top) {
			cellStyle.setBorderTop(border);
		}
		if(bottom) {
			cellStyle.setBorderBottom(border);
		}
		if(left) {
			cellStyle.setBorderLeft(border);
		}
		if(right) {
			cellStyle.setBorderRight(border);
		}
		return cellStyle;
	}
	
	/**
	 * 设置合并单元格边框样式
	 * @param top	是否加上边框
	 * @param bottom	是否加下边框
	 * @param left	是否加左边框
	 * @param right	是否加右边框
	 * @param borderType	边框类型(THIN:薄边框) 待补充
	 * @param cra	合并单元格对象
	 * @param sheet	合并单元格所属sheet
	 */
	public void setMergedRegionBorderStyle(boolean top, boolean bottom, boolean left, boolean right, String borderType, CellRangeAddress cra, Sheet sheet) {
		BorderStyle border = null;
		if("THIN".equals(borderType)) {
			border = BorderStyle.THIN;
		}
		if(top) {
			RegionUtil.setBorderTop(border, cra, sheet);
		}
		if(bottom) {
			RegionUtil.setBorderBottom(border, cra, sheet);
		}
		if(left) {
			RegionUtil.setBorderLeft(border, cra, sheet);
		}
		if(right) {
			RegionUtil.setBorderRight(border, cra, sheet);
		}
	}

	public static void main(String[] args) {
		ExcelReadUtil eru = ExcelReadUtil.getInstance();
		ExcelWriteUtil ewu = ExcelWriteUtil.getInstance();

		String tempath = "d:/test.xlsx";
		String exportPath = "d:/test1.xlsx";

		Workbook wb = new XSSFWorkbook();
		try {
			wb = eru.readExcelToWb(tempath);
			Sheet sheet1 = wb.getSheetAt(0);
			Row row = sheet1.getRow(1);
			Cell cell = row.getCell(0);
			System.out.println(eru.getStringCellValue(cell));
			// 设置静数据截止日期
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			cell.setCellValue("净值数据截止日期：" + df.format(new Date()));

			Row row1 = sheet1.getRow(5);
			Cell cell1 = row1.getCell(0);
			System.out.println(eru.getStringCellValue(cell1));
			cell1.setCellValue("1.1.1 股票基金-标准股票型基金-标准股票型基金（A类）");

//			Row row2 = sheet1.getRow(7);
//			Cell cell2 = row2.getCell(9);
//			Cell cell3 = row2.getCell(10);
//			System.out.println(eru.getStringCellValue(cell2));
//			System.out.println(eru.getStringCellValue(cell3));
//			cell2.setCellValue("1.11%");
//			cell3.setCellValue("2.22%");

			
			
			String str = "业务规则与指标说明：\r\n" + 
					"1、本表的基金分类标准是《中国银河证券基金分类体系（2017版）》。\r\n" + 
					"2、部分封闭式基金一周披露一次净值、QDII基金净值披露比国内基金滞后一天或者两天。\r\n" + 
					"3、剩余期限和运作时间不足一年的基金均不计算年化指标。\r\n" + 
					"4、本表业务处理根据中国银河证券基金研究中心相关业务规则。\r\n" + 
					"5、每个类型基金日净值增长率平均值的样本数是全部基金；每个类型基金今年以来净值增长率平均值的样本数是满足建仓期3个月的基金，即去年10月1日之前成立基金。\r\n" + 
					"\r\n" + 
					"执业说明和免责声明：\r\n" + 
					"1、基金投资有风险，请谨慎抉择，本表所有信息与数据仅供参考，不构成投资建议。\r\n" + 
					"2、中国银河证券股份有限公司拥有证券投资咨询资格，我司基金研究业务内设机构是中国银河证券基金研究中心，中心负责人胡立峰。\r\n" + 
					"3、2010年5月18日，中国证券业协会（中证协发[2010]69号）同意中国银河证券股份有限公司证券投资基金评价业务备案申请，我司基金评价业务范围为：基金及基金管理公司评级、单一指标排名。根据向中国证监会和中国证券业协会备案的公告信息，我司基金评价业务内设机构是中国银河证券基金研究中心，我司基金评价业务负责人是胡立峰。\r\n" + 
					"4、本表执行中国证监会的《证券投资基金评价业务管理暂行办法》和中国证券业协会的《证券投资基金评价业务自律管理规则(试行)》的有关规定。\r\n" + 
					"5、本表的信息与数据来自《中国银河证券基金研究评价资讯系统》，我们力求基金信息与数据的准确，但无法确保准确。根据《证券投资基金信息披露管理办法》，如果对本表信息与数据有歧义的话，净值数据以基金管理公司网站披露为准，行情数据以交易所披露为准。\r\n" + 
					"6、对本表的信息与数据有异议的，请邮件联系中国银河证券基金研究中心官方邮箱fund@company.com.cn或者电话联系中国银河证券基金研究中心热线18811045599。";

			
			
			// 复制表头
			ewu.createRow((XSSFSheet) sheet1, 10);
			ewu.copyRows(sheet1, 4, 6, 10);
//			int lastCount = sheet1.getLastRowNum();
//			int addNum = lastCount+1;
//			ewu.createRow((XSSFSheet) sheet1, addNum);
//			Row row11 = sheet1.getRow(addNum);
//			row11.createCell(0).setCellValue(str);
			
			
//			CellRangeAddress region = new CellRangeAddress(addNum, addNum+13, 0, 15);
//			sheet1.addMergedRegion(region);
//			
//			XSSFCellStyle cellStyle=(XSSFCellStyle) wb.createCellStyle();    
//			cellStyle.setWrapText(true);
//			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);//水平居中  
//			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中  
//			row11.getCell(0).setCellStyle(cellStyle);
			
			
			ewu.saveExcel((XSSFWorkbook) wb, exportPath);

//			System.out.println(sheet1.getFirstRowNum()+"行开始，总计："+sheet1.getLastRowNum()+"行");
//			for(int i=0;i<sheet1.getLastRowNum();i++) {
//				Row row = sheet1.getRow(i);
//				int cellCount = row.getLastCellNum();
//				for(int j=0;j<cellCount;j++) {
//					Cell cell = row.getCell(j);
//					String str = eru.getStringCellValue(cell);
//					System.out.println("第"+i+"行，第"+j+"列，值为："+str);
//					
//				}
//			}

		} catch (ExcelReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
