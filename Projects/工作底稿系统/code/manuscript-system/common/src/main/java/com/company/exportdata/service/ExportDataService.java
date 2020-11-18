package com.company.exportdata.service;

import java.io.OutputStream;
import java.util.List;

import com.company.base.exception.BaseException;
import com.company.query.model.SmartQueryModel;
import com.company.query.model.SmartQueryModelExample;
import com.company.utils.ExcelWriteHandle;
import com.github.pagehelper.PageInfo;

public interface ExportDataService{

	/**
	 * 	导出数据文件
	 * @param tempPath	            导出模板文件路径
	 * @param out		            输出到页面流		
	 * @param title 		标题
	 * @param sql			查询sql
	 * @param sqlTotal		合计sql
	 * @param example       
	 * @throws BaseException
	 */
	void export(String tempPath, OutputStream out, String title, String sql, String sqlTotal,
			SmartQueryModelExample example, ExcelWriteHandle eh) throws BaseException;
	
	/**
     * 	根据对象分页查询多条记录
     * @param currentPage  起始页目
     * @param itemsPerPage 每页最多显示条目
     * @param example      example类
     * @return
     * @throws BaseException
     */
    PageInfo<SmartQueryModel> getListByPage(int currentPage, int itemsPerPage, String sql, SmartQueryModelExample example) throws BaseException;

	/**
	 * 	查询合计数据
	 * @param sql
	 * @param example
	 * @return
	 */
	List<SmartQueryModel> getTotalList(String sql, SmartQueryModelExample example) throws BaseException;
	
	/**
	 * 根据对象查询多头记录列表
	 * @param sql
	 * @param example
	 * @return
	 * @throws BaseException
	 */
	List<SmartQueryModel> getList(String sql, SmartQueryModelExample example) throws BaseException;

    
}
