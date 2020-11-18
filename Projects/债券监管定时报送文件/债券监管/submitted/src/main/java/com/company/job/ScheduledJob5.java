package com.company.job;

import java.util.Calendar;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.base.exception.BaseException;
import com.company.config.job.JobParam;
import com.company.config.job.OutputFileInfo;
import com.company.one.riskbreachcause.model.RiskBreachCause;
import com.company.one.riskbreachcause.model.RiskBreachCauseExample;
import com.company.one.riskbreachcause.service.RiskBreachCauseService;
import com.company.two.joblog.model.JobLogTab;
import com.company.two.joblog.model.JobLogTabExample;
import com.company.two.joblog.service.JobLogTabService;

/**
 * 数据接口名称：债券风险违约信息
 * 接口编号：J005
 * 结构化标志：结构化
 * 传输文件格式：TXT
 * 传输频度：周
 * 传输时间：每周日三点
 * 增全量标志：增量
 * @author yangyanchao
 *
 */
public class ScheduledJob5 implements Job {
	private Logger logger = LoggerFactory.getLogger(ScheduledJob5.class);
	@Autowired
    private JobLogTabService<JobLogTab, JobLogTabExample> jobLogTabService;
	@Autowired
    private RiskBreachCauseService<RiskBreachCause, RiskBreachCauseExample> service;
	@Autowired
    private JobParam jobParam;
	@Override  
    public void execute(JobExecutionContext context) throws JobExecutionException {
		long start = System.currentTimeMillis();
		logger.info("数据接口名称：债券风险违约信息正在运行中");
    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
    	RiskBreachCauseExample example = new RiskBreachCauseExample();
    	com.company.one.riskbreachcause.model.RiskBreachCauseExample.Criteria criteria = example.createCriteria();
    	Calendar cl = Calendar.getInstance();
    	cl.setTime(new Date());
    	cl.add(Calendar.DAY_OF_MONTH, -7);
    	criteria.andUpdateTimeBetween(cl.getTime(), new Date());
    	OutputFileInfo outputFileInfo = new OutputFileInfo("J005", "Z");
    	JobLogTab jobLogTab = new JobLogTab("J005", 1, outputFileInfo.getDataDate());
    	long totalNumber = 0;
    	try {
    		totalNumber = service.getDataByBatchToFile(example, outputFileInfo, jobParam);
		} catch (BaseException e) {
			logger.info("生成债券风险违约信息接口文件报错",e.fillInStackTrace());
		}
    	try {
    		jobLogTab.setTotalNumber((int)totalNumber);
			jobLogTabService.save(jobLogTab);
		} catch (BaseException e) {
			logger.info("债券风险违约信息录入日志数据表出错",e.fillInStackTrace());
		}
    	long end = System.currentTimeMillis();
    	logger.info("数据接口名称：债券风险违约信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
    }
}  