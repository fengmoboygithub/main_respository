package com.company.utils;

import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;

import com.company.exception.ExcelReadException;

/**
 *	Excel里sheet页读取数据验证并插入相关表的处理类
 * @author fra.yyc
 *
 */
public interface ExcelReadHandle {
	
	/**
	 * sheet页处理逻辑方法
	 * @param sheet
	 * @return 验证的错误信息
	 */
	public List<String> sheetHandle(Sheet sheet) throws ExcelReadException;
	
}
