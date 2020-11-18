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
import com.company.one.agencyinfo.model.AgencyInfo;
import com.company.one.agencyinfo.model.AgencyInfoExample;
import com.company.one.agencyinfo.service.AgencyInfoService;
import com.company.two.joblog.model.JobLogTab;
import com.company.two.joblog.model.JobLogTabExample;
import com.company.two.joblog.service.JobLogTabService;

/**
 * 数据接口名称：债券相关中介机构基本信息
 * 接口编号：J004
 * 结构化标志：结构化
 * 传输文件格式：TXT
 * 传输频度：周
 * 传输时间：每周日三点
 * 增全量标志：全量
 * @author yangyanchao
 *
 */
public class ScheduledJob4 implements Job {
	private Logger logger = LoggerFactory.getLogger(ScheduledJob4.class);
	@Autowired
    private JobLogTabService<JobLogTab, JobLogTabExample> jobLogTabService;
	@Autowired
    private AgencyInfoService<AgencyInfo, AgencyInfoExample> service;
	@Autowired
    private JobParam jobParam;
	@Override  
    public void execute(JobExecutionContext context) throws JobExecutionException {
		long start = System.currentTimeMillis();
		logger.info("数据接口名称：债券相关中介机构基本信息正在运行中");
    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
    	AgencyInfoExample example = new AgencyInfoExample();
    	OutputFileInfo outputFileInfo = new OutputFileInfo("J004", "Q");
    	JobLogTab jobLogTab = new JobLogTab("J004", 1, outputFileInfo.getDataDate());
    	long totalNumber = 0;
    	try {
    		totalNumber = service.getDataByBatchToFile(example, outputFileInfo, jobParam);
		} catch (BaseException e) {
			logger.info("生成债券相关中介机构基本信息接口文件报错",e.fillInStackTrace());
		}
    	try {
    		jobLogTab.setTotalNumber((int)totalNumber);
			jobLogTabService.save(jobLogTab);
		} catch (BaseException e) {
			logger.info("债券相关中介机构基本信息录入日志数据表出错",e.fillInStackTrace());
		}
    	long end = System.currentTimeMillis();
    	logger.info("数据接口名称：债券相关中介机构基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
    }
}  