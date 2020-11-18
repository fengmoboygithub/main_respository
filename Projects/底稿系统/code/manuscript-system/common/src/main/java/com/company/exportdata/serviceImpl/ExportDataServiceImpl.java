package com.company.exportdata.serviceImpl;

import java.io.OutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.company.base.exception.BaseException;
import com.company.exportdata.service.ExportDataService;
import com.company.query.dao.SmartQueryMapper;
import com.company.query.model.SmartQueryModel;
import com.company.query.model.SmartQueryModelExample;
import com.company.utils.ExcelReadUtil;
import com.company.utils.ExcelWriteHandle;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ExportDataServiceImpl implements ExportDataService{
	
	/**
     *	日志类 
     */
    public static Logger logger = LoggerFactory.getLogger(ExportDataServiceImpl.class);
	
    /**
     * 	执行查询Mapper
     */
    @Autowired
    private SmartQueryMapper smartQueryMapper;
    
    public SmartQueryMapper getSmartQueryMapperMapper(){
		return smartQueryMapper;
	}

	@Override
	public void export(String tempPath, OutputStream out, String title, String sql, String sqlTotal,
			SmartQueryModelExample example, ExcelWriteHandle eh) throws BaseException {
		ExcelReadUtil eru = ExcelReadUtil.getInstance();
		//	获取导出数据
		List<SmartQueryModel> list = getSmartQueryMapperMapper().select(sql, example);
		if (!StringUtils.isEmpty(sqlTotal)) {
			//	获取合计数据
			List<SmartQueryModel> listTotal = getSmartQueryMapperMapper().select(sqlTotal, example);
			if(listTotal != null && listTotal.size() > 0) {
				//	追加到导出数据中
				list.add(listTotal.get(0));
			}
		}
		
		//	通过导出模板与导出数据合并生成导出文件并输出到页面流（下载）
		eru.exportExcel(tempPath, list, 0, out, eh);
	}

	@Override
	public PageInfo<SmartQueryModel> getListByPage(int currentPage, int itemsPerPage, String sql, SmartQueryModelExample example)
			throws BaseException {
		List<SmartQueryModel> list = null;
        PageInfo<SmartQueryModel> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = getSmartQueryMapperMapper().select(sql, example);
			page = new PageInfo<SmartQueryModel>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
			throw new BaseException("分页查询失败");
		}
		return page;
	}

	@Override
	public List<SmartQueryModel> getTotalList(String sql, SmartQueryModelExample example) throws BaseException {
		List<SmartQueryModel> list = null;
		try {
			list = getSmartQueryMapperMapper().select(sql, example);
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
			throw new BaseException("查询合计数据失败");
		}
		return list;
	}

	@Override
	public List<SmartQueryModel> getList(String sql, SmartQueryModelExample example) throws BaseException {
		List<SmartQueryModel> list = null;
		try {
			list = getSmartQueryMapperMapper().select(sql, example);
			logger.info("返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
			throw new BaseException("列表查询失败");
		}
		return list;
	}
}