package com.company.utils;

import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.company.exception.ExcelWriteException;
import com.company.query.model.SmartQueryModel;

/**
 *	Excel里sheet页与导出数据整理合并的处理类
 * @author fra.yyc
 *
 */
public interface ExcelWriteHandle {
	
	/**
	 * sheet页与导出数据整理合并处理逻辑方法
	 * @param sheet
	 * @param list  导出数据
	 */
	public void sheetAndListHandle(Sheet sheet, Workbook wb, List<SmartQueryModel> list) throws ExcelWriteException;
	
}
