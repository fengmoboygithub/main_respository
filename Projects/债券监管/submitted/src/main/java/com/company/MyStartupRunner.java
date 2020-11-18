package com.company;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.company.base.exception.BaseException;
import com.company.config.first.FirstParam;
import com.company.config.job.JobParam;
import com.company.config.job.OutputFileInfo;
import com.company.config.repair.RepairParam;
import com.company.one.absinfo.model.AbsBaseInfo;
import com.company.one.absinfo.model.AbsBaseInfoExample;
import com.company.one.absinfo.service.AbsBaseInfoService;
import com.company.one.agencyinfo.model.AgencyInfo;
import com.company.one.agencyinfo.model.AgencyInfoExample;
import com.company.one.agencyinfo.service.AgencyInfoService;
import com.company.one.baseinfo.model.BondBaseInfo;
import com.company.one.baseinfo.model.BondBaseInfoExample;
import com.company.one.baseinfo.model.BondBaseInfoExample.Criteria;
import com.company.one.baseinfo.service.BondBaseInfoService;
import com.company.one.publisherinfo.model.PublisherInfo;
import com.company.one.publisherinfo.model.PublisherInfoExample;
import com.company.one.publisherinfo.service.PublisherInfoService;
import com.company.one.riskbreachcause.model.RiskBreachCause;
import com.company.one.riskbreachcause.model.RiskBreachCauseExample;
import com.company.one.riskbreachcause.service.RiskBreachCauseService;
import com.company.two.joblog.model.JobLogTab;
import com.company.two.joblog.model.JobLogTabExample;
import com.company.two.joblog.service.JobLogTabService;

@Component
public class MyStartupRunner implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(MyStartupRunner.class);

    @Autowired
    public FirstParam firstParam;
    @Autowired
    public RepairParam repairParam;
    @Autowired
    private JobLogTabService<JobLogTab, JobLogTabExample> jobLogTabService;
    @Autowired
    private BondBaseInfoService<BondBaseInfo, BondBaseInfoExample> service1;
	@Autowired
    private AbsBaseInfoService<AbsBaseInfo, AbsBaseInfoExample> service2;
	@Autowired
    private PublisherInfoService<PublisherInfo, PublisherInfoExample> service3;
	@Autowired
    private AgencyInfoService<AgencyInfo, AgencyInfoExample> service4;
	@Autowired
    private RiskBreachCauseService<RiskBreachCause, RiskBreachCauseExample> service5;
	@Autowired
    private JobParam jobParam;
	
	/**
	 * 首次报送处理
	 * @param interfaceCode
	 */
	private void firstDeal(String interfaceCode){
		logger.info(">>>>>>>>>>>>>>>首次报送接口编码"+interfaceCode+"开始执行<<<<<<<<<<<<<");
		if("J8001".equals(interfaceCode)){
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
	    	Long totalNumber1 = 0L;
	    	try {
	    		totalNumber1 = service1.getDataByBatchToFile(example, outputFileInfo, jobParam);
			} catch (BaseException e) {
				logger.info("生成公司债券基本信息接口文件报错",e.fillInStackTrace());
			}
	    	try {
	    		jobLogTab.setTotalNumber(totalNumber1.intValue());
				jobLogTabService.save(jobLogTab);
			} catch (BaseException e) {
				logger.info("公司债券基本信息录入日志数据表出错",e.fillInStackTrace());
			}
	    	long end = System.currentTimeMillis();
	    	logger.info("数据接口名称：公司债券基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
		} else if("J8002".equals(interfaceCode)){
			long start = System.currentTimeMillis();
			logger.info("数据接口名称：企业资产支持证券基本信息正在运行中");
	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
	    	AbsBaseInfoExample example = new AbsBaseInfoExample();
	    	com.company.one.absinfo.model.AbsBaseInfoExample.Criteria criteria = example.createCriteria();
	    	criteria.addCriterion("state =", 1, "state");
	    	criteria.andAbsCodeNotEqualTo("");
	    	criteria.andAbsCodeIsNotNull();
	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J8002", "Q");
	    	JobLogTab jobLogTab = new JobLogTab("J8002", 1, outputFileInfo.getDataDate());
	    	Long totalNumber2 = 0L;
	    	try {
	    		totalNumber2 = service2.getDataByBatchToFile(example, outputFileInfo, jobParam);
			} catch (BaseException e) {
				logger.info("生成企业资产支持证券基本信息接口文件报错",e.fillInStackTrace());
			}
	    	try {
	    		jobLogTab.setTotalNumber(totalNumber2.intValue());
				jobLogTabService.save(jobLogTab);
			} catch (BaseException e) {
				logger.info("企业资产支持证券基本信息录入日志数据表出错",e.fillInStackTrace());
			}
	    	long end = System.currentTimeMillis();
	    	logger.info("数据接口名称：公司债券基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
		} else if("J8003".equals(interfaceCode)){
			long start = System.currentTimeMillis();
			logger.info("数据接口名称：发行人（原始权益人）基本信息正在运行中");
	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
	    	PublisherInfoExample example = new PublisherInfoExample();
	    	com.company.one.publisherinfo.model.PublisherInfoExample.Criteria criteria = example.createCriteria();
	    	criteria.andBondCodeNotEqualTo("");
	    	criteria.andBondCodeIsNotNull();
	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J8003", "Q");
	    	JobLogTab jobLogTab = new JobLogTab("J8003", 1, outputFileInfo.getDataDate());
	    	Long totalNumber3 = 0L;
	    	try {
	    		totalNumber3 = service3.getDataByBatchToFile(example, outputFileInfo, jobParam);
			} catch (BaseException e) {
				logger.info("生成发行人（原始权益人）基本信息接口文件报错",e.fillInStackTrace());
			}
	    	try {
	    		jobLogTab.setTotalNumber(totalNumber3.intValue());
				jobLogTabService.save(jobLogTab);
			} catch (BaseException e) {
				logger.info("发行人（原始权益人）基本信息录入日志数据表出错",e.fillInStackTrace());
			}
	    	long end = System.currentTimeMillis();
	    	logger.info("数据接口名称：发行人（原始权益人）基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
		} else if("J8004".equals(interfaceCode)){
			long start = System.currentTimeMillis();
			logger.info("数据接口名称：债券相关中介机构基本信息正在运行中");
	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
	    	AgencyInfoExample example = new AgencyInfoExample();
	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J8004", "Q");
	    	JobLogTab jobLogTab = new JobLogTab("J8004", 1, outputFileInfo.getDataDate());
	    	Long totalNumber4 = 0L;
	    	try {
	    		totalNumber4 = service4.getDataByBatchToFile(example, outputFileInfo, jobParam);
			} catch (BaseException e) {
				logger.info("生成债券相关中介机构基本信息接口文件报错",e.fillInStackTrace());
			}
	    	try {
	    		jobLogTab.setTotalNumber(totalNumber4.intValue());
				jobLogTabService.save(jobLogTab);
			} catch (BaseException e) {
				logger.info("债券相关中介机构基本信息录入日志数据表出错",e.fillInStackTrace());
			}
	    	long end = System.currentTimeMillis();
	    	logger.info("数据接口名称：债券相关中介机构基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
		} else if("J8005".equals(interfaceCode)){
			long start = System.currentTimeMillis();
			logger.info("数据接口名称：债券风险违约信息正在运行中");
	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
	    	RiskBreachCauseExample example = new RiskBreachCauseExample();
	    	com.company.one.riskbreachcause.model.RiskBreachCauseExample.Criteria criteria = example.createCriteria();
	    	criteria.addCriterion("bond_code is not null");
	    	criteria.addCriterion("bond_code != ''");
	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J8005", "Q");
	    	JobLogTab jobLogTab = new JobLogTab("J8005", 1, outputFileInfo.getDataDate());
	    	Long totalNumber5 = 0L;
	    	try {
	    		totalNumber5 = service5.getDataByBatchToFile(example, outputFileInfo, jobParam);
			} catch (BaseException e) {
				logger.info("生成债券风险违约信息接口文件报错",e.fillInStackTrace());
			}
	    	try {
	    		jobLogTab.setTotalNumber(totalNumber5.intValue());
				jobLogTabService.save(jobLogTab);
			} catch (BaseException e) {
				logger.info("债券风险违约信息录入日志数据表出错",e.fillInStackTrace());
			}
	    	long end = System.currentTimeMillis();
	    	logger.info("数据接口名称：债券风险违约信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
		}
	}
	
	/**
	 * 重新报送处理
	 * @param interfaceCode
	 */
	private void repairtDeal(String interfaceCode){
		logger.info(">>>>>>>>>>>>>>>重新报送接口编码"+interfaceCode+"开始执行<<<<<<<<<<<<<");
		if("J8001".equals(interfaceCode)){
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
	    	JobLogTabExample jobLogTabExample = new JobLogTabExample();
	    	com.company.two.joblog.model.JobLogTabExample.Criteria criteria1 = jobLogTabExample.createCriteria();
	    	criteria1.andInterfaceCodeEqualTo("J8001");
	    	criteria1.andInterfaceDateEqualTo(outputFileInfo.getDataDate());
	    	long count = 0;
	    	try {
				count = jobLogTabService.countByExample(jobLogTabExample);
			} catch (BaseException e1) {
				logger.info("公司债券基本信息查询版本号出错",e1.fillInStackTrace());
			}
	    	int currnum = ((int)++count);
	    	outputFileInfo.setVersionNum(String.format("V%02d", currnum));
	    	long totalNumber = 0;
	    	try {
	    		totalNumber = service1.getDataByBatchToFile(example, outputFileInfo, jobParam);
			} catch (BaseException e) {
				logger.info("生成公司债券基本信息接口文件报错",e.fillInStackTrace());
			}
	    	JobLogTab jobLogTab = new JobLogTab("J8001", currnum, outputFileInfo.getDataDate());
	    	try {
	    		jobLogTab.setTotalNumber((int)totalNumber);
				jobLogTabService.save(jobLogTab);
			} catch (BaseException e) {
				logger.info("公司债券基本信息录入日志数据表出错",e.fillInStackTrace());
			}
	    	long end = System.currentTimeMillis();
	    	logger.info("数据接口名称：公司债券基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
		} else if("J8002".equals(interfaceCode)){
			long start = System.currentTimeMillis();
			logger.info("数据接口名称：企业资产支持证券基本信息正在运行中");
	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
	    	AbsBaseInfoExample example = new AbsBaseInfoExample();
	    	com.company.one.absinfo.model.AbsBaseInfoExample.Criteria criteria = example.createCriteria();
	    	criteria.addCriterion("state =", 1, "state");
	    	criteria.andAbsCodeNotEqualTo("");
	    	criteria.andAbsCodeIsNotNull();
	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J8002", "Q");
	    	JobLogTabExample jobLogTabExample = new JobLogTabExample();
	    	com.company.two.joblog.model.JobLogTabExample.Criteria criteria1 = jobLogTabExample.createCriteria();
	    	criteria1.andInterfaceCodeEqualTo("J8002");
	    	criteria1.andInterfaceDateEqualTo(outputFileInfo.getDataDate());
	    	long count = 0;
	    	try {
				count = jobLogTabService.countByExample(jobLogTabExample);
			} catch (BaseException e1) {
				logger.info("企业资产支持证券基本信息查询版本号出错",e1.fillInStackTrace());
			}
	    	int currnum = ((int)++count);
	    	outputFileInfo.setVersionNum(String.format("V%02d", currnum));
	    	long totalNumber = 0;
	    	try {
	    		totalNumber = service2.getDataByBatchToFile(example, outputFileInfo, jobParam);
			} catch (BaseException e) {
				logger.info("生成企业资产支持证券基本信息接口文件报错",e.fillInStackTrace());
			}
	    	JobLogTab jobLogTab = new JobLogTab("J8002", currnum, outputFileInfo.getDataDate());
	    	try {
	    		jobLogTab.setTotalNumber((int)totalNumber);
				jobLogTabService.save(jobLogTab);
			} catch (BaseException e) {
				logger.info("企业资产支持证券基本信息录入日志数据表出错",e.fillInStackTrace());
			}
	    	long end = System.currentTimeMillis();
	    	logger.info("数据接口名称：公司债券基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
		} else if("J8003".equals(interfaceCode)){
			long start = System.currentTimeMillis();
			logger.info("数据接口名称：发行人（原始权益人）基本信息正在运行中");
	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
	    	PublisherInfoExample example = new PublisherInfoExample();
	    	com.company.one.publisherinfo.model.PublisherInfoExample.Criteria criteria = example.createCriteria();
	    	criteria.andBondCodeNotEqualTo("");
	    	criteria.andBondCodeIsNotNull();
	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J8003", "Q");
	    	JobLogTabExample jobLogTabExample = new JobLogTabExample();
	    	com.company.two.joblog.model.JobLogTabExample.Criteria criteria1 = jobLogTabExample.createCriteria();
	    	criteria1.andInterfaceCodeEqualTo("J8003");
	    	criteria1.andInterfaceDateEqualTo(outputFileInfo.getDataDate());
	    	long count = 0;
	    	try {
				count = jobLogTabService.countByExample(jobLogTabExample);
			} catch (BaseException e1) {
				logger.info("发行人（原始权益人）基本信息查询版本号出错",e1.fillInStackTrace());
			}
	    	int currnum = ((int)++count);
	    	outputFileInfo.setVersionNum(String.format("V%02d", currnum));
	    	long totalNumber = 0;
	    	try {
	    		totalNumber = service3.getDataByBatchToFile(example, outputFileInfo, jobParam);
			} catch (BaseException e) {
				logger.info("生成发行人（原始权益人）基本信息接口文件报错",e.fillInStackTrace());
			}
	    	JobLogTab jobLogTab = new JobLogTab("J8003", currnum, outputFileInfo.getDataDate());
	    	try {
	    		jobLogTab.setTotalNumber((int)totalNumber);
				jobLogTabService.save(jobLogTab);
			} catch (BaseException e) {
				logger.info("发行人（原始权益人）基本信息录入日志数据表出错",e.fillInStackTrace());
			}
	    	long end = System.currentTimeMillis();
	    	logger.info("数据接口名称：发行人（原始权益人）基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
		} else if("J8004".equals(interfaceCode)){
			long start = System.currentTimeMillis();
			logger.info("数据接口名称：债券相关中介机构基本信息正在运行中");
	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
	    	AgencyInfoExample example = new AgencyInfoExample();
	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J8004", "Q");
	    	JobLogTabExample jobLogTabExample = new JobLogTabExample();
	    	com.company.two.joblog.model.JobLogTabExample.Criteria criteria1 = jobLogTabExample.createCriteria();
	    	criteria1.andInterfaceCodeEqualTo("J8004");
	    	criteria1.andInterfaceDateEqualTo(outputFileInfo.getDataDate());
	    	long count = 0;
	    	try {
				count = jobLogTabService.countByExample(jobLogTabExample);
			} catch (BaseException e1) {
				logger.info("债券相关中介机构基本信息查询版本号出错",e1.fillInStackTrace());
			}
	    	int currnum = ((int)++count);
	    	outputFileInfo.setVersionNum(String.format("V%02d", currnum));
	    	long totalNumber = 0;
	    	try {
	    		totalNumber = service4.getDataByBatchToFile(example, outputFileInfo, jobParam);
			} catch (BaseException e) {
				logger.info("生成债券相关中介机构基本信息接口文件报错",e.fillInStackTrace());
			}
	    	JobLogTab jobLogTab = new JobLogTab("J8004", currnum, outputFileInfo.getDataDate());
	    	try {
	    		jobLogTab.setTotalNumber((int)totalNumber);
				jobLogTabService.save(jobLogTab);
			} catch (BaseException e) {
				logger.info("债券相关中介机构基本信息录入日志数据表出错",e.fillInStackTrace());
			}
	    	long end = System.currentTimeMillis();
	    	logger.info("数据接口名称：债券相关中介机构基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
		} else if("J8005".equals(interfaceCode)){
			long start = System.currentTimeMillis();
			logger.info("数据接口名称：债券风险违约信息正在运行中");
	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
	    	RiskBreachCauseExample example = new RiskBreachCauseExample();
	    	com.company.one.riskbreachcause.model.RiskBreachCauseExample.Criteria criteria = example.createCriteria();
	    	Calendar cl = Calendar.getInstance();
	    	cl.setTime(new Date());
	    	cl.add(Calendar.DAY_OF_MONTH, -7);
	    	criteria.andUpdateTimeBetween(cl.getTime(), new Date());
	    	criteria.addCriterion("bond_code is not null");
	    	criteria.addCriterion("bond_code != ''");
	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J8005", "Z");
	    	JobLogTabExample jobLogTabExample = new JobLogTabExample();
	    	com.company.two.joblog.model.JobLogTabExample.Criteria criteria1 = jobLogTabExample.createCriteria();
	    	criteria1.andInterfaceCodeEqualTo("J8005");
	    	criteria1.andInterfaceDateEqualTo(outputFileInfo.getDataDate());
	    	long count = 0;
	    	try {
				count = jobLogTabService.countByExample(jobLogTabExample);
			} catch (BaseException e1) {
				logger.info("债券风险违约信息查询版本号出错",e1.fillInStackTrace());
			}
	    	int currnum = ((int)++count);
	    	outputFileInfo.setVersionNum(String.format("V%02d", currnum));
	    	long totalNumber = 0;
	    	try {
	    		totalNumber = service5.getDataByBatchToFile(example, outputFileInfo, jobParam);
			} catch (BaseException e) {
				logger.info("生成债券风险违约信息接口文件报错",e.fillInStackTrace());
			}
	    	JobLogTab jobLogTab = new JobLogTab("J8005", currnum, outputFileInfo.getDataDate());
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

    @Override
    public void run(String... args) throws Exception {
    	//首次报送
    	if(firstParam != null && firstParam.isFlag()){
    		String interfaceCode = firstParam.getInterfaceCode();
    		if(interfaceCode != null){
    			if(interfaceCode.indexOf(",") >= 0){
    				String[] arr = interfaceCode.split(",");
    				for(String str : arr){
    					this.firstDeal(str);
    				}
    			} else {
    				this.firstDeal(interfaceCode);
    			}
    		}
    	}
    	
    	//重新报送
    	if(repairParam != null && repairParam.isFlag()){
    		String interfaceCode = repairParam.getInterfaceCode();
    		if(interfaceCode != null){
    			if(interfaceCode.indexOf(",") >= 0){
    				String[] arr = interfaceCode.split(",");
    				for(String str : arr){
    					this.repairtDeal(str);
    				}
    			} else {
    				this.repairtDeal(interfaceCode);
    			}
    		}
    	}
    }
}