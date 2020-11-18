package com.company;

import com.company.generationcode.GeneratorConfiguration.GeneratorConfiguration;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) throws Exception {
		
    	Map<String, String> paramMap = new HashMap<String, String>();
    	//数据库类型
    	paramMap.put("dialect", "mysql");
    	//导出地址
    	paramMap.put("outPath", "m://outputcode/");
    	//数据库连接地址
    	paramMap.put("jdbcUrl", "jdbc:mysql://127.0.0.1:3306/manuscript");
    	//数据库连接地址
//    	paramMap.put("jdbcUrl", "jdbc:mysql://10.0.48.60:3306/test");
//    	paramMap.put("jdbcPassword", "1234@Abc");
    	
    	paramMap.put("jdbcUserId", "root");
    	paramMap.put("jdbcPassword", "root");
    	

    	
//    	/****************************************表start********************************/
//    	//生成包名com.company.
    	paramMap.put("packageName", "processConfig");
    	//表名称
    	paramMap.put("tableName", "processinfo");
    	//模型实体名称
    	paramMap.put("domainObjectName", "ProcessInfo");
    	//模型定义
    	paramMap.put("cnObjectName", "流程信息");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
//    	/****************************************表end********************************/
    	
//    	/****************************************表start********************************/
//    	//生成包名com.company.
//    	paramMap.put("packageName", "one.handleplain");
//    	//表名称
//    	paramMap.put("tableName", "handle_plain_tmp");
//    	//模型实体名称
//    	paramMap.put("domainObjectName", "HandlePlainTmp");
//    	//模型定义
//    	paramMap.put("cnObjectName", "文件内容");
//    	GeneratorConfiguration.generatorConfigForGen(paramMap);
//    	/****************************************表end********************************/
    	
    	
//    	/****************************************表start********************************/
//    	//生成包名com.company.
//    	paramMap.put("packageName", "one.handletuple");
//    	//表名称
//    	paramMap.put("tableName", "handle_tuple_tmp");
//    	//模型实体名称
//    	paramMap.put("domainObjectName", "HandleTupleTmp");
//    	//模型定义
//    	paramMap.put("cnObjectName", "文件内容元组");
//    	GeneratorConfiguration.generatorConfigForGen(paramMap);
//    	/****************************************表end********************************/
//		
//    	/****************************************表start********************************/
//    	//生成包名com.company.
//    	paramMap.put("packageName", "one.handlefieldindex");
//    	//表名称
//    	paramMap.put("tableName", "handle_field_index_tab");
//    	//模型实体名称
//    	paramMap.put("domainObjectName", "HandleFieldIndexTab");
//    	//模型定义
//    	paramMap.put("cnObjectName", "字段索引");
//    	GeneratorConfiguration.generatorConfigForGen(paramMap);
//    	/****************************************表end********************************/
//
//    	/****************************************表start********************************/
//    	//生成包名com.company.
//    	paramMap.put("packageName", "one.handlecompresspackage");
//    	//表名称
//    	paramMap.put("tableName", "handle_compress_package_tab");
//    	//模型实体名称
//    	paramMap.put("domainObjectName", "HandleCompressPackageTab");
//    	//模型定义
//    	paramMap.put("cnObjectName", "处理压缩包");
//    	GeneratorConfiguration.generatorConfigForGen(paramMap);
//    	/****************************************表end********************************/
//    	/****************************************表start********************************/
    	//生成包名com.company.
//    	paramMap.put("packageName", "one.handlefile");
//    	//表名称
//    	paramMap.put("tableName", "handle_file_tab");
//    	//模型实体名称
//    	paramMap.put("domainObjectName", "HandleFileTab");
//    	//模型定义
//    	paramMap.put("cnObjectName", "处理文件");
//    	GeneratorConfiguration.generatorConfigForGen(paramMap);
//    	/****************************************表end********************************/
//
//    	/****************************************表start********************************/
    	//生成包名com.company.
//    	paramMap.put("packageName", "one.handledetail");
//    	//表名称
//    	paramMap.put("tableName", "handle_detail_tab");
//    	//模型实体名称
//    	paramMap.put("domainObjectName", "HandleDetailTab");
//    	//模型定义
//    	paramMap.put("cnObjectName", "处理明细");
//    	GeneratorConfiguration.generatorConfigForGen(paramMap);
//    	/****************************************表end********************************/
//
    	/****************************************表start********************************/
//    	//生成包名com.company.
//    	paramMap.put("packageName", "one.syslogging");
//    	//表名称
//    	paramMap.put("tableName", "sys_logging_tab");
//    	//模型实体名称
//    	paramMap.put("domainObjectName", "SysLoggingTab");
//    	//模型定义
//    	paramMap.put("cnObjectName", "系统日志");
//    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************表end********************************/
    	
    	/****************************************表start********************************/
//    	//生成包名com.company.
//    	paramMap.put("packageName", "one.handleenclosuretab");
//    	//表名称
//    	paramMap.put("tableName", "handle_enclosure_tab");
//    	//模型实体名称
//    	paramMap.put("domainObjectName", "HandleEnclosureTab");
//    	//模型定义
//    	paramMap.put("cnObjectName", "接口模板");
//    	GeneratorConfiguration.generatorConfigForGen(paramMap);
//    	/****************************************表end********************************/
    	
//    	Map<String, String> paramMap = new HashMap<String, String>();
//    	//数据库类型
//    	paramMap.put("dialect", "sqllite");
//    	//导出地址
//    	paramMap.put("outPath", "D://outputcode/");
//    	//数据库驱动包
//    	paramMap.put("jdbcDriver", "org.sqlite.JDBC");
//    	//数据库连接地址
//    	paramMap.put("jdbcUrl", "jdbc:sqlite:E:/db/myDb");
//    	//生成包名com.company.
//    	paramMap.put("packageName", "two.joblog");
//    	
//    	/****************************************表start********************************/
//    	//表名称
//    	paramMap.put("tableName", "job_log_tab");
//    	//模型实体名称
//    	paramMap.put("domainObjectName", "JobLogTab");
//    	//模型定义
//    	paramMap.put("cnObjectName", "工作日志信息");
//    	GeneratorConfiguration.generatorConfigForGen(paramMap);
//    	/****************************************表end********************************/
    }
}
