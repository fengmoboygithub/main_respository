package com.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 程序启动时执行
 * @author yangyanchao
 *
 */
@Component
public class MyStartupRunner implements CommandLineRunner {
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(MyStartupRunner.class);

//    @Autowired
//    public FirstParam firstParam;
//    @Autowired
//    public RepairParam repairParam;
//    @Autowired
//    private JobLogTabService<JobLogTab, JobLogTabExample> jobLogTabService;
//    @Autowired
//    private BondBaseInfoService<BondBaseInfo, BondBaseInfoExample> service1;
//	@Autowired
//    private AbsBaseInfoService<AbsBaseInfo, AbsBaseInfoExample> service2;
//	@Autowired
//    private PublisherInfoService<PublisherInfo, PublisherInfoExample> service3;
//	@Autowired
//    private AgencyInfoService<AgencyInfo, AgencyInfoExample> service4;
//	@Autowired
//    private RiskBreachCauseService<RiskBreachCause, RiskBreachCauseExample> service5;
//	@Autowired
//    private JobParam jobParam;
	
//	/**
//	 * 首次报送处理
//	 * @param interfaceCode
//	 */
//	private void firstDeal(String interfaceCode){
//		logger.info(">>>>>>>>>>>>>>>首次报送接口编码"+interfaceCode+"开始执行<<<<<<<<<<<<<");
//		if("J0001".equals(interfaceCode)){
//			long start = System.currentTimeMillis();
//			logger.info("数据接口名称：公司债券基本信息正在运行中");
//	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
//	    	BondBaseInfoExample example = new BondBaseInfoExample();
//	    	Criteria criteria = example.createCriteria();
//	    	criteria.andStateEqualTo(1);
//	    	criteria.andEditStateEqualTo(1);
//	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J0001", "Q");
//	    	JobLogTab jobLogTab = new JobLogTab("J0001", 1, outputFileInfo.getDataDate());
//	    	Long totalNumber1 = 0L;
//	    	try {
//	    		totalNumber1 = service1.getDataByBatchToFile(example, outputFileInfo, jobParam);
//			} catch (BaseException e) {
//				logger.info("生成公司债券基本信息接口文件报错",e.fillInStackTrace());
//			}
//	    	try {
//	    		jobLogTab.setTotalNumber(totalNumber1.intValue());
//				jobLogTabService.save(jobLogTab);
//			} catch (BaseException e) {
//				logger.info("公司债券基本信息录入日志数据表出错",e.fillInStackTrace());
//			}
//	    	long end = System.currentTimeMillis();
//	    	logger.info("数据接口名称：公司债券基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
//		} else if("J0002".equals(interfaceCode)){
//			long start = System.currentTimeMillis();
//			logger.info("数据接口名称：企业资产支持证券基本信息正在运行中");
//	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
//	    	AbsBaseInfoExample example = new AbsBaseInfoExample();
//	    	com.company.one.absinfo.model.AbsBaseInfoExample.Criteria criteria = example.createCriteria();
//	    	criteria.addCriterion("state =", 1, "state");
//	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J0002", "Q");
//	    	JobLogTab jobLogTab = new JobLogTab("J0002", 1, outputFileInfo.getDataDate());
//	    	Long totalNumber2 = 0L;
//	    	try {
//	    		totalNumber2 = service2.getDataByBatchToFile(example, outputFileInfo, jobParam);
//			} catch (BaseException e) {
//				logger.info("生成企业资产支持证券基本信息接口文件报错",e.fillInStackTrace());
//			}
//	    	try {
//	    		jobLogTab.setTotalNumber(totalNumber2.intValue());
//				jobLogTabService.save(jobLogTab);
//			} catch (BaseException e) {
//				logger.info("企业资产支持证券基本信息录入日志数据表出错",e.fillInStackTrace());
//			}
//	    	long end = System.currentTimeMillis();
//	    	logger.info("数据接口名称：公司债券基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
//		} else if("J0003".equals(interfaceCode)){
//			long start = System.currentTimeMillis();
//			logger.info("数据接口名称：发行人（原始权益人）基本信息正在运行中");
//	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
//	    	PublisherInfoExample example = new PublisherInfoExample();
//	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J0003", "Q");
//	    	JobLogTab jobLogTab = new JobLogTab("J0003", 1, outputFileInfo.getDataDate());
//	    	Long totalNumber3 = 0L;
//	    	try {
//	    		totalNumber3 = service3.getDataByBatchToFile(example, outputFileInfo, jobParam);
//			} catch (BaseException e) {
//				logger.info("生成发行人（原始权益人）基本信息接口文件报错",e.fillInStackTrace());
//			}
//	    	try {
//	    		jobLogTab.setTotalNumber(totalNumber3.intValue());
//				jobLogTabService.save(jobLogTab);
//			} catch (BaseException e) {
//				logger.info("发行人（原始权益人）基本信息录入日志数据表出错",e.fillInStackTrace());
//			}
//	    	long end = System.currentTimeMillis();
//	    	logger.info("数据接口名称：发行人（原始权益人）基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
//		} else if("J0004".equals(interfaceCode)){
//			long start = System.currentTimeMillis();
//			logger.info("数据接口名称：债券相关中介机构基本信息正在运行中");
//	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
//	    	AgencyInfoExample example = new AgencyInfoExample();
//	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J0004", "Q");
//	    	JobLogTab jobLogTab = new JobLogTab("J0004", 1, outputFileInfo.getDataDate());
//	    	Long totalNumber4 = 0L;
//	    	try {
//	    		totalNumber4 = service4.getDataByBatchToFile(example, outputFileInfo, jobParam);
//			} catch (BaseException e) {
//				logger.info("生成债券相关中介机构基本信息接口文件报错",e.fillInStackTrace());
//			}
//	    	try {
//	    		jobLogTab.setTotalNumber(totalNumber4.intValue());
//				jobLogTabService.save(jobLogTab);
//			} catch (BaseException e) {
//				logger.info("债券相关中介机构基本信息录入日志数据表出错",e.fillInStackTrace());
//			}
//	    	long end = System.currentTimeMillis();
//	    	logger.info("数据接口名称：债券相关中介机构基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
//		} else if("J0005".equals(interfaceCode)){
//			long start = System.currentTimeMillis();
//			logger.info("数据接口名称：债券风险违约信息正在运行中");
//	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
//	    	RiskBreachCauseExample example = new RiskBreachCauseExample();
//	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J0005", "Q");
//	    	JobLogTab jobLogTab = new JobLogTab("J0005", 1, outputFileInfo.getDataDate());
//	    	Long totalNumber5 = 0L;
//	    	try {
//	    		totalNumber5 = service5.getDataByBatchToFile(example, outputFileInfo, jobParam);
//			} catch (BaseException e) {
//				logger.info("生成债券风险违约信息接口文件报错",e.fillInStackTrace());
//			}
//	    	try {
//	    		jobLogTab.setTotalNumber(totalNumber5.intValue());
//				jobLogTabService.save(jobLogTab);
//			} catch (BaseException e) {
//				logger.info("债券风险违约信息录入日志数据表出错",e.fillInStackTrace());
//			}
//	    	long end = System.currentTimeMillis();
//	    	logger.info("数据接口名称：债券风险违约信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
//		}
//	}
//	
//	/**
//	 * 重新报送处理
//	 * @param interfaceCode
//	 */
//	private void repairtDeal(String interfaceCode){
//		logger.info(">>>>>>>>>>>>>>>重新报送接口编码"+interfaceCode+"开始执行<<<<<<<<<<<<<");
//		if("J0001".equals(interfaceCode)){
//			long start = System.currentTimeMillis();
//			logger.info("数据接口名称：公司债券基本信息正在运行中");
//	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
//	    	BondBaseInfoExample example = new BondBaseInfoExample();
//	    	Criteria criteria = example.createCriteria();
//	    	criteria.andStateEqualTo(1);
//	    	criteria.andEditStateEqualTo(1);
//	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J0001", "Q");
//	    	JobLogTabExample jobLogTabExample = new JobLogTabExample();
//	    	com.company.two.joblog.model.JobLogTabExample.Criteria criteria1 = jobLogTabExample.createCriteria();
//	    	criteria1.andInterfaceCodeEqualTo("J0001");
//	    	criteria1.andInterfaceDateEqualTo(outputFileInfo.getDataDate());
//	    	long count = 0;
//	    	try {
//				count = jobLogTabService.countByExample(jobLogTabExample);
//			} catch (BaseException e1) {
//				logger.info("公司债券基本信息查询版本号出错",e1.fillInStackTrace());
//			}
//	    	int currnum = ((int)++count);
//	    	outputFileInfo.setVersionNum(String.format("V%02d", currnum));
//	    	long totalNumber = 0;
//	    	try {
//	    		totalNumber = service1.getDataByBatchToFile(example, outputFileInfo, jobParam);
//			} catch (BaseException e) {
//				logger.info("生成公司债券基本信息接口文件报错",e.fillInStackTrace());
//			}
//	    	JobLogTab jobLogTab = new JobLogTab("J0001", currnum, outputFileInfo.getDataDate());
//	    	try {
//	    		jobLogTab.setTotalNumber((int)totalNumber);
//				jobLogTabService.save(jobLogTab);
//			} catch (BaseException e) {
//				logger.info("公司债券基本信息录入日志数据表出错",e.fillInStackTrace());
//			}
//	    	long end = System.currentTimeMillis();
//	    	logger.info("数据接口名称：公司债券基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
//		} else if("J0002".equals(interfaceCode)){
//			long start = System.currentTimeMillis();
//			logger.info("数据接口名称：企业资产支持证券基本信息正在运行中");
//	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
//	    	AbsBaseInfoExample example = new AbsBaseInfoExample();
//	    	com.company.one.absinfo.model.AbsBaseInfoExample.Criteria criteria = example.createCriteria();
//	    	criteria.addCriterion("state =", 1, "state");
//	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J0002", "Q");
//	    	JobLogTabExample jobLogTabExample = new JobLogTabExample();
//	    	com.company.two.joblog.model.JobLogTabExample.Criteria criteria1 = jobLogTabExample.createCriteria();
//	    	criteria1.andInterfaceCodeEqualTo("J0002");
//	    	criteria1.andInterfaceDateEqualTo(outputFileInfo.getDataDate());
//	    	long count = 0;
//	    	try {
//				count = jobLogTabService.countByExample(jobLogTabExample);
//			} catch (BaseException e1) {
//				logger.info("企业资产支持证券基本信息查询版本号出错",e1.fillInStackTrace());
//			}
//	    	int currnum = ((int)++count);
//	    	outputFileInfo.setVersionNum(String.format("V%02d", currnum));
//	    	long totalNumber = 0;
//	    	try {
//	    		totalNumber = service2.getDataByBatchToFile(example, outputFileInfo, jobParam);
//			} catch (BaseException e) {
//				logger.info("生成企业资产支持证券基本信息接口文件报错",e.fillInStackTrace());
//			}
//	    	JobLogTab jobLogTab = new JobLogTab("J0002", currnum, outputFileInfo.getDataDate());
//	    	try {
//	    		jobLogTab.setTotalNumber((int)totalNumber);
//				jobLogTabService.save(jobLogTab);
//			} catch (BaseException e) {
//				logger.info("企业资产支持证券基本信息录入日志数据表出错",e.fillInStackTrace());
//			}
//	    	long end = System.currentTimeMillis();
//	    	logger.info("数据接口名称：公司债券基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
//		} else if("J0003".equals(interfaceCode)){
//			long start = System.currentTimeMillis();
//			logger.info("数据接口名称：发行人（原始权益人）基本信息正在运行中");
//	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
//	    	PublisherInfoExample example = new PublisherInfoExample();
//	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J0003", "Q");
//	    	JobLogTabExample jobLogTabExample = new JobLogTabExample();
//	    	com.company.two.joblog.model.JobLogTabExample.Criteria criteria1 = jobLogTabExample.createCriteria();
//	    	criteria1.andInterfaceCodeEqualTo("J0003");
//	    	criteria1.andInterfaceDateEqualTo(outputFileInfo.getDataDate());
//	    	long count = 0;
//	    	try {
//				count = jobLogTabService.countByExample(jobLogTabExample);
//			} catch (BaseException e1) {
//				logger.info("发行人（原始权益人）基本信息查询版本号出错",e1.fillInStackTrace());
//			}
//	    	int currnum = ((int)++count);
//	    	outputFileInfo.setVersionNum(String.format("V%02d", currnum));
//	    	long totalNumber = 0;
//	    	try {
//	    		totalNumber = service3.getDataByBatchToFile(example, outputFileInfo, jobParam);
//			} catch (BaseException e) {
//				logger.info("生成发行人（原始权益人）基本信息接口文件报错",e.fillInStackTrace());
//			}
//	    	JobLogTab jobLogTab = new JobLogTab("J0003", currnum, outputFileInfo.getDataDate());
//	    	try {
//	    		jobLogTab.setTotalNumber((int)totalNumber);
//				jobLogTabService.save(jobLogTab);
//			} catch (BaseException e) {
//				logger.info("发行人（原始权益人）基本信息录入日志数据表出错",e.fillInStackTrace());
//			}
//	    	long end = System.currentTimeMillis();
//	    	logger.info("数据接口名称：发行人（原始权益人）基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
//		} else if("J0004".equals(interfaceCode)){
//			long start = System.currentTimeMillis();
//			logger.info("数据接口名称：债券相关中介机构基本信息正在运行中");
//	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
//	    	AgencyInfoExample example = new AgencyInfoExample();
//	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J0004", "Q");
//	    	JobLogTabExample jobLogTabExample = new JobLogTabExample();
//	    	com.company.two.joblog.model.JobLogTabExample.Criteria criteria1 = jobLogTabExample.createCriteria();
//	    	criteria1.andInterfaceCodeEqualTo("J0004");
//	    	criteria1.andInterfaceDateEqualTo(outputFileInfo.getDataDate());
//	    	long count = 0;
//	    	try {
//				count = jobLogTabService.countByExample(jobLogTabExample);
//			} catch (BaseException e1) {
//				logger.info("债券相关中介机构基本信息查询版本号出错",e1.fillInStackTrace());
//			}
//	    	int currnum = ((int)++count);
//	    	outputFileInfo.setVersionNum(String.format("V%02d", currnum));
//	    	long totalNumber = 0;
//	    	try {
//	    		totalNumber = service4.getDataByBatchToFile(example, outputFileInfo, jobParam);
//			} catch (BaseException e) {
//				logger.info("生成债券相关中介机构基本信息接口文件报错",e.fillInStackTrace());
//			}
//	    	JobLogTab jobLogTab = new JobLogTab("J0004", currnum, outputFileInfo.getDataDate());
//	    	try {
//	    		jobLogTab.setTotalNumber((int)totalNumber);
//				jobLogTabService.save(jobLogTab);
//			} catch (BaseException e) {
//				logger.info("债券相关中介机构基本信息录入日志数据表出错",e.fillInStackTrace());
//			}
//	    	long end = System.currentTimeMillis();
//	    	logger.info("数据接口名称：债券相关中介机构基本信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
//		} else if("J0005".equals(interfaceCode)){
//			long start = System.currentTimeMillis();
//			logger.info("数据接口名称：债券风险违约信息正在运行中");
//	    	logger.info("任务参数信息为====>>>>>>"+jobParam.toString());
//	    	RiskBreachCauseExample example = new RiskBreachCauseExample();
//	    	com.company.one.riskbreachcause.model.RiskBreachCauseExample.Criteria criteria = example.createCriteria();
//	    	Calendar cl = Calendar.getInstance();
//	    	cl.setTime(new Date());
//	    	cl.add(Calendar.DAY_OF_MONTH, -7);
//	    	criteria.andUpdateTimeBetween(cl.getTime(), new Date());
//	    	OutputFileInfo outputFileInfo = new OutputFileInfo("J0005", "Z");
//	    	JobLogTabExample jobLogTabExample = new JobLogTabExample();
//	    	com.company.two.joblog.model.JobLogTabExample.Criteria criteria1 = jobLogTabExample.createCriteria();
//	    	criteria1.andInterfaceCodeEqualTo("J0005");
//	    	criteria1.andInterfaceDateEqualTo(outputFileInfo.getDataDate());
//	    	long count = 0;
//	    	try {
//				count = jobLogTabService.countByExample(jobLogTabExample);
//			} catch (BaseException e1) {
//				logger.info("债券风险违约信息查询版本号出错",e1.fillInStackTrace());
//			}
//	    	int currnum = ((int)++count);
//	    	outputFileInfo.setVersionNum(String.format("V%02d", currnum));
//	    	long totalNumber = 0;
//	    	try {
//	    		totalNumber = service5.getDataByBatchToFile(example, outputFileInfo, jobParam);
//			} catch (BaseException e) {
//				logger.info("生成债券风险违约信息接口文件报错",e.fillInStackTrace());
//			}
//	    	JobLogTab jobLogTab = new JobLogTab("J0005", currnum, outputFileInfo.getDataDate());
//	    	try {
//	    		jobLogTab.setTotalNumber((int)totalNumber);
//				jobLogTabService.save(jobLogTab);
//			} catch (BaseException e) {
//				logger.info("债券风险违约信息录入日志数据表出错",e.fillInStackTrace());
//			}
//	    	long end = System.currentTimeMillis();
//	    	logger.info("数据接口名称：债券风险违约信息结束所用毫秒数为====>>>>>>"+(end-start)+"毫秒");
//		}
//	}

    /**
     * 运行代码
     */
    @Override
    public void run(String... args) throws Exception {
//    	//首次报送
//    	if(firstParam != null && firstParam.isFlag()){
//    		String interfaceCode = firstParam.getInterfaceCode();
//    		if(interfaceCode != null){
//    			if(interfaceCode.indexOf(",") >= 0){
//    				String[] arr = interfaceCode.split(",");
//    				for(String str : arr){
//    					this.firstDeal(str);
//    				}
//    			} else {
//    				this.firstDeal(interfaceCode);
//    			}
//    		}
//    	}
//    	
//    	//重新报送
//    	if(repairParam != null && repairParam.isFlag()){
//    		String interfaceCode = repairParam.getInterfaceCode();
//    		if(interfaceCode != null){
//    			if(interfaceCode.indexOf(",") >= 0){
//    				String[] arr = interfaceCode.split(",");
//    				for(String str : arr){
//    					this.repairtDeal(str);
//    				}
//    			} else {
//    				this.repairtDeal(interfaceCode);
//    			}
//    		}
//    	}
    }
}