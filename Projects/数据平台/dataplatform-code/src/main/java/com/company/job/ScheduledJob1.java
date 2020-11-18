package com.company.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.base.exception.BaseException;
import com.company.config.interfaceinfo.InterfaceParamInfo;
import com.company.config.job.JobParam;
import com.company.domain.analysisinto.AnalysisAndWarehousingDomain;
import com.company.domain.comparisoninto.ComparisonAndWarehousingDomain;
import com.company.domain.respond.RespondDomain;
import com.company.domain.submitted.SubmittedDomain;
import com.company.domain.verification.VerificationDomain;
import com.company.one.handlefile.model.HandleFileTab;
import com.company.one.handlefile.model.HandleFileTabExample;
import com.company.one.handlefile.service.HandleFileTabService;

/**
 * 定时任务执行类
 * 1==>>文件解析入库
 * 2==>>数据移植
 * 3==>>校验
 * 4==>>上报
 * 5==>>应答
 * @author yangyanchao
 *
 */
public class ScheduledJob1 implements Job {
	private Logger logger = LoggerFactory.getLogger(ScheduledJob1.class);
	/**
	 * 参数信息类
	 */
	@Autowired
    private JobParam jobParam;
	/**
	 * 接口信息参数类
	 */
	@Autowired
    private InterfaceParamInfo interfaceParamInfo;
    /**
	 * 处理文件--服务类
	 */
	@Autowired
    private HandleFileTabService<HandleFileTab, HandleFileTabExample> handleFileTabService;
    
	@Override  
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	logger.info("参数信息为====>>>>>>"+jobParam.toString());
    	try {
    		//解析入库临时表
    		AnalysisAndWarehousingDomain analysisAndWarehousingDomain = new AnalysisAndWarehousingDomain(jobParam);
    		analysisAndWarehousingDomain.analysisAndWarehousingToTemp();
		} catch (BaseException e) {
			logger.info("解析入库临时表失败", e.fillInStackTrace());
		}
    	try {
    		//比对入库正式表
    		ComparisonAndWarehousingDomain comparisonAndWarehousingDomain = new ComparisonAndWarehousingDomain(jobParam, interfaceParamInfo);
    		comparisonAndWarehousingDomain.comparisonAndWarehousingToFormal();
    	} catch (BaseException e) {
			logger.info("比对入库正式表失败", e.fillInStackTrace());
		}
    	try {
    		//校验
    		VerificationDomain verificationDomain = new VerificationDomain(jobParam);
    		verificationDomain.verification();
    	} catch (BaseException e) {
			logger.info("校验失败", e.fillInStackTrace());
		}
    	try {
    		//报送
    		handleFileTabService.submitted();
    		SubmittedDomain submittedDomain = new SubmittedDomain(jobParam);
    		submittedDomain.submitted();
    	} catch (BaseException e) {
			logger.info("报送数据失败", e.fillInStackTrace());
		}
    	try {
    		//应答
    		RespondDomain respondDomain = new RespondDomain(jobParam);
    		respondDomain.respond();
    	} catch (BaseException e) {
			logger.info("生成应答失败", e.fillInStackTrace());
		}
    }  
} 