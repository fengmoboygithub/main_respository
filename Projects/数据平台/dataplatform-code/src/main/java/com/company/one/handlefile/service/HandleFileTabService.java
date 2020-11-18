package com.company.one.handlefile.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;
import com.company.config.interfaceinfo.InterfaceParamInfo;
import com.company.config.job.JobParam;

/**
 * 处理文件服务接口类
 * @author yangyanchao
 * @param <T>
 * @param <E>
 */
public interface HandleFileTabService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
	
	/**
	 * 扫描指定目录下的文件进行解析入库临时表   
	 * 该过程没有事务 原因：由于文件数据量过10W+时 数据库应分批次提交事务
	 * @param jobParam
	 * @throws BaseException
	 */
	public void analysisAndWarehousingToTemp(JobParam jobParam) throws BaseException;
	
	/**
	 * 查询临时表数据进行比对入库正式表
	 * 该过程有事务
	 * @throws BaseException
	 */
	public void comparisonAndWarehousingToFormal(JobParam jobParam, InterfaceParamInfo interfaceParamInfo) throws BaseException;
	
	/**
	 * 校验数据合法性，若不通过记录原因
	 * @throws BaseException
	 */
	public void verification() throws BaseException;
	
	/**
	 * 报送数据，若报送失败记录原因
	 * 该过程没有事务
	 * @throws BaseException
	 */
	public void submitted() throws BaseException;
	
	/**
	 * 查询数据，生成应答文件
	 * @throws BaseException
	 */
	public void respond(JobParam jobParam) throws BaseException;
}