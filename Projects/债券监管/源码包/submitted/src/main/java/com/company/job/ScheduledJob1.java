package com.company.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.base.exception.BaseException;
import com.company.config.job.JobParam;
import com.company.config.job.OutputFileInfo;
import com.company.one.baseinfo.model.BondBaseInfo;
import com.company.one.baseinfo.model.BondBaseInfoExample;
import com.company.one.baseinfo.model.BondBaseInfoExample.Criteria;
import com.company.one.baseinfo.service.BondBaseInfoService;
import com.company.two.joblog.model.JobLogTab;
import com.company.two.joblog.model.JobLogTabExample;
import com.company.two.joblog.service.JobLogTabService;

/**
 * 数据接口名称：公司债券基本信息
 * 接口编号：J8001
 * 结构化标志：结构化
 * 传输文件格式：TXT
 * 传输频度：周
 * 传输时间：每周日三点
 * 增全量标志：全量
 * @author yangyanchao
 *
 */
public class ScheduledJob1 implements Job {
	private Logger logger = LoggerFactory.getLogger(ScheduledJob1.class);
	@Autowired
    private JobLogTabService<JobLogTab, JobLogTabExample> jobLogTabService;
	@Autowired
    private BondBaseInfoService<BondBaseInfo, BondBaseInfoExample> service;
	@Autowired
    private JobParam jobParam;
	@Override  
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	long start = System.currentTimeMillis();
		logger.info("数据接口名称：公司债券基本信息正在运行中");
    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
    	BondBaseInfoExample example = new BondBaseInfoExample();
    	Criteria criteria = example.createCriteria();
    	criteria.andStateEqualTo(1);
    	criteria.andEditStateEqualTo(1);
    	criteria.andBondCodeNotEqualTo("");
    	criteria.andBondCodeIsNotNull();
    	OutputFileInfo outputFileInfo = new OutputFileInfo("J8001", "Q");
    	JobLogTab jobLogTab = new JobLogTab("J8001", 1, outputFileInfo.getDataDate());
    	long totalNumber = 0;
    	try {
    		totalNumber = service.getDataByBatchToFile(example, outputFileInfo, jobParam);
		} catch (BaseException e) {
			logger.info("生成公司债券基本信息接口文件报错",e.fillInStackTrace());
		}
    	try {
    		jobLogTab.setTotalNumber((int)totalNumber);
			jobLogTabService.save(jobLogTab);
		} catch (BaseException e) {
			logger.info("公司债券基本信息录入日志数据表出错",e.fillInStackTrace());
		}
    	long end = System.currentTimeMillis();
    	logger.info("数据接口名称：公司债券基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
    }  
} 