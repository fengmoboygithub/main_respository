package com.company.config;

import java.io.File;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.base.exception.BaseException;
import com.company.config.job.JobParam;
import com.company.job.ScheduledJob1;

/**
 * 任务调度配置及基本配置信息类
 * 
 * @author yangyanchao
 *
 */
@Configuration
public class QuartzConfig {

	/**
	 * 定义定时任务执行频率
	 */
	@Value("${quartz.cron}")
	private String cron;
	
	/**
	 * 扫描目录
	 */
	@Value("${quartz.scan.path}")
	private String scanPath;
	
	/**
	 * 备份目录
	 */
	@Value("${quartz.backup.path}")
	private String backupPath;
	
	/**
	 * 临时目录
	 */
	@Value("${quartz.temp.path}")
	private String tempPath;
	
	/**
	 * 附件目录
	 */
	@Value("${quartz.annex.path}")
	private String annexPath;
	
	/**
	 * 应答目录
	 */
	@Value("${quartz.respond.path}")
	private String respondPath;

	/**
	 * 设置插入一批次中最多行数
	 */
	@Value("${quartz.file.insert.one.batch.maxrownum}")
	private int insertBatchMaxNum;

	/**
	 * 设置查询一批次中最多行数
	 */
	@Value("${quartz.file.query.one.batch.maxrownum}")
	private int queryBatchMaxNum;

	/**
	 * 字段分隔符
	 */
	@Value("${quartz.file.separator}")
	private String separator;

	/**
	 * 换行符
	 */
	@Value("${quartz.file.linefeed}")
	private String linefeed;

	/**
	 * 结束字符
	 */
	@Value("${quartz.file.end}")
	private String end;
	
	/**
	 * 附件目录名称
	 */
	@Value("${quartz.file.attachment}")
	private String attachmentName;
	
	/**
	 * txt文件名正则表达式
	 */
	@Value("${quartz.file.regular.txtname}")
	private String regularTxtname;

	/**
	 * zip文件名正则表达式
	 */
	@Value("${quartz.file.regular.zipname}")
	private String regularZipname;
	
	/**
	 * 普通信息正则表达式
	 */
	@Value("${quartz.file.regular.plain}")
	private String regularPlain;

	/**
	 * 元组信息正则正则表达式
	 */
	@Value("${quartz.file.regular.tuple}")
	private String regularTuple;
	
	/**
	 * 注入 参数类
	 * @return
	 * @throws BaseException
	 */
	@Bean
	public JobParam jobParam() throws BaseException{
		//扫描目录
		File scanDir = new File(scanPath);
		if(!scanDir.exists() || !scanDir.isDirectory()){
			throw new BaseException("扫描目录不存在或者不是个目录，请在配置文件中设置。");
		}
		//备份目录
		File backupDir = new File(backupPath);
		if(!backupDir.exists() || !backupDir.isDirectory()){
			throw new BaseException("备份目录不存在或者不是个目录，请在配置文件中设置。");
		}
		//临时目录
		File tempDir = new File(tempPath);
		if(!tempDir.exists() || !tempDir.isDirectory()){
			throw new BaseException("临时目录不存在或者不是个目录，请在配置文件中设置。");
		}
		//附件目录
		File annexDir = new File(annexPath);
		if(!annexDir.exists() || !annexDir.isDirectory()){
			throw new BaseException("附件目录不存在或者不是个目录，请在配置文件中设置。");
		}
		//应答目录
		File respondDir = new File(respondPath);
		if(!respondDir.exists() || !respondDir.isDirectory()){
			throw new BaseException("应答目录不存在或者不是个目录，请在配置文件中设置。");
		}
		JobParam jobParam = new JobParam(scanDir, backupDir, tempDir, annexDir, respondDir, insertBatchMaxNum, queryBatchMaxNum, separator, linefeed, end, attachmentName, regularTxtname, regularZipname, regularPlain, regularTuple);
		return jobParam;
	}
	
	///////////////////////////////// (一)任务调度配置相关开始////////////////////////////////////////
	@Bean(name = "jobDetail1")
	public JobDetail jobDetail1() {
		JobDetail jobDetail = JobBuilder.newJob(ScheduledJob1.class).withIdentity("job1", "group1")
				.storeDurably().build();
		return jobDetail;
	}

	@Bean(name = "myTrigger1")
	public Trigger myTrigger1() {
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
				.forJob("job1", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
		return trigger;
	}
	///////////////////////////////// (一)任务调度配置相关结束////////////////////////////////////////

}
