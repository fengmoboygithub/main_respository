package com.company.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.config.job.JobParam;
import com.company.job.ScheduledJob1;
import com.company.job.ScheduledJob2;
import com.company.job.ScheduledJob3;
import com.company.job.ScheduledJob4;
import com.company.job.ScheduledJob5;

/**
 * 任务调度配置类
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
	 * 任务执行结果输出目录
	 */
	@Value("${quartz.output.path}")
	private String outputPath;
	/**
	 * 设置查询一批次中最多行数
	 */
	@Value("${quartz.query.one.batch.maxrownum}")
	private Integer pageSize;
	
	/**
	 * 字段分隔符
	 */
	@Value("${quartz.separator}")
	private String separator;
	
	/**
	 * 换行符
	 */
	@Value("${quartz.linefeed}")
	private String linefeed;
	
	@Bean
	public JobParam jobParam() {
		JobParam jobParam = new JobParam(outputPath, pageSize, separator, linefeed);
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

	///////////////////////////////// (二)任务调度配置相关开始////////////////////////////////////////
	@Bean(name = "jobDetail2")
	public JobDetail jobDetail2() {
		JobDetail jobDetail = JobBuilder.newJob(ScheduledJob2.class).withIdentity("job2", "group2")
				.storeDurably().build();
		return jobDetail;
	}

	@Bean(name = "myTrigger2")
	public Trigger myTrigger2() {
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
				.forJob("job2", "group2")
				.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
		return trigger;
	}
	///////////////////////////////// (二)任务调度配置相关结束////////////////////////////////////////

	///////////////////////////////// (三)任务调度配置相关开始////////////////////////////////////////
	@Bean(name = "jobDetail3")
	public JobDetail jobDetail3() {
		JobDetail jobDetail = JobBuilder.newJob(ScheduledJob3.class).withIdentity("job3", "group3")
				.storeDurably().build();
		return jobDetail;
	}

	@Bean(name = "myTrigger3")
	public Trigger myTrigger3() {
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger3", "group3")
				.forJob("job3", "group3")
				.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
		return trigger;
	}
	///////////////////////////////// (三)任务调度配置相关结束////////////////////////////////////////

	///////////////////////////////// (四)任务调度配置相关开始////////////////////////////////////////
	@Bean(name = "jobDetail4")
	public JobDetail jobDetail4() {
		JobDetail jobDetail = JobBuilder.newJob(ScheduledJob4.class).withIdentity("job4", "group4")
				.storeDurably().build();
		return jobDetail;
	}

	@Bean(name = "myTrigger4")
	public Trigger myTrigger4() {
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger4", "group4")
				.forJob("job4", "group4")
				.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
		return trigger;
	}
	///////////////////////////////// (四)任务调度配置相关结束////////////////////////////////////////

	///////////////////////////////// (五)任务调度配置相关开始////////////////////////////////////////
	@Bean(name = "jobDetail5")
	public JobDetail jobDetail5() {
		JobDetail jobDetail = JobBuilder.newJob(ScheduledJob5.class).withIdentity("job5", "group5")
				.storeDurably().build();
		return jobDetail;
	}

	@Bean(name = "myTrigger5")
	public Trigger myTrigger5() {
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger5", "group5")
				.forJob("job5", "group5")
				.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
		return trigger;
	}
	///////////////////////////////// (五)任务调度配置相关结束////////////////////////////////////////
}
