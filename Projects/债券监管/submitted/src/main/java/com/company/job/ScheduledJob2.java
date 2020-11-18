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
import com.company.one.absinfo.model.AbsBaseInfo;
import com.company.one.absinfo.model.AbsBaseInfoExample;
import com.company.one.absinfo.model.AbsBaseInfoExample.Criteria;
import com.company.one.absinfo.service.AbsBaseInfoService;
import com.company.two.joblog.model.JobLogTab;
import com.company.two.joblog.model.JobLogTabExample;
import com.company.two.joblog.service.JobLogTabService;

/**
 * 数据接口名称：企业资产支持证券基本信息
 * 接口编号：J8002
 * 结构化标志：结构化
 * 传输文件格式：TXT
 * 传输频度：周
 * 传输时间：每周日三点
 * 增全量标志：全量
 * @author yangyanchao
 *
 */
public class ScheduledJob2 implements Job {
	private Logger logger = LoggerFactory.getLogger(ScheduledJob2.class);
	@Autowired
    private JobLogTabService<JobLogTab, JobLogTabExample> jobLogTabService;
	@Autowired
    private AbsBaseInfoService<AbsBaseInfo, AbsBaseInfoExample> service;
	@Autowired
    private JobParam jobParam;
	@Override  
    public void execute(JobExecutionContext context) throws JobExecutionException {
		long start = System.currentTimeMillis();
		logger.info("数据接口名称：企业资产支持证券基本信息正在运行中");
    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
    	AbsBaseInfoExample example = new AbsBaseInfoExample();
    	Criteria criteria = example.createCriteria();
    	criteria.addCriterion("state =", 1, "state");
    	criteria.andAbsCodeNotEqualTo("");
    	criteria.andAbsCodeIsNotNull();
    	OutputFileInfo outputFileInfo = new OutputFileInfo("J8002", "Q");
    	JobLogTab jobLogTab = new JobLogTab("J8002", 1, outputFileInfo.getDataDate());
    	long totalNumber = 0;
    	try {
    		totalNumber = service.getDataByBatchToFile(example, outputFileInfo, jobParam);
		} catch (BaseException e) {
			logger.info("生成企业资产支持证券基本信息接口文件报错",e.fillInStackTrace());
		}
    	try {
    		jobLogTab.setTotalNumber((int)totalNumber);
			jobLogTabService.save(jobLogTab);
		} catch (BaseException e) {
			logger.info("企业资产支持证券基本信息录入日志数据表出错",e.fillInStackTrace());
		}
    	long end = System.currentTimeMillis();
    	logger.info("数据接口名称：公司债券基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
    }
}  