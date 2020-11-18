package com.interapi.app;

import java.util.HashMap;
import java.util.Map;

import com.interapi.app.generationcode.GeneratorConfiguration.GeneratorConfiguration;

public class Test2 {
	/**
	 * 	模块管理
			modular_tab                           模块表
			modular_field_tab                     模块字段表
			table_item_tab						      表格项表
			query_criteria_item_tab               查询条件项表
			form_item_tab                         表单项表
			rules_tab							      验证规则表
			element_tab							      元素表
		配置管理
			dictionary_tab                        数据字典表
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
    	Map<String, String> paramMap = new HashMap<String, String>();
    	//数据库类型
    	paramMap.put("dialect", "mysql");
    	//导出地址
    	paramMap.put("outPath", "D://outputcode/");
    	//数据库连接地址
    	paramMap.put("jdbcUrl", "jdbc:mysql://127.0.0.1:3306/modulemanagement");
    	//生成包名
    	paramMap.put("packageName", "modular");
    	//模块所属菜单名称 
    	paramMap.put("menuName", "模块管理");
    	/****************************************模块表start********************************/
    	//表名称
    	paramMap.put("tableName", "modular_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "ModularTab");
    	//模型定义
    	paramMap.put("cnObjectName", "模块");
    	//模块页面排序
    	paramMap.put("pageSort", "1");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "1");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************模块表end********************************/
    	
    	/****************************************模块字段表start********************************/
    	//表名称
    	paramMap.put("tableName", "modular_field_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "ModularFieldTab");
    	//模型定义
    	paramMap.put("cnObjectName", "模块字段");
    	//模块页面排序
    	paramMap.put("pageSort", "2");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "1");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************模块字段表end********************************/

    	/****************************************表格项表start********************************/
    	//表名称
    	paramMap.put("tableName", "table_item_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "TableItemTab");
    	//模型定义
    	paramMap.put("cnObjectName", "表格项");
    	//模块页面排序
    	paramMap.put("pageSort", "3");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "1");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************表格项表end********************************/
    	
    	/****************************************查询条件项表start********************************/
    	//表名称
    	paramMap.put("tableName", "query_criteria_item_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "QueryCriteriaItemTab");
    	//模型定义
    	paramMap.put("cnObjectName", "查询条件项");
    	//模块页面排序
    	paramMap.put("pageSort", "4");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "1");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************查询条件项表end********************************/
    	
    	/****************************************表单项表start********************************/
    	//表名称
    	paramMap.put("tableName", "form_item_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "FormItemTab");
    	//模型定义
    	paramMap.put("cnObjectName", "表单项");
    	//模块页面排序
    	paramMap.put("pageSort", "5");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "1");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************表单项表end********************************/
    	
    	/****************************************验证规则表start********************************/
    	//表名称
    	paramMap.put("tableName", "rules_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "RulesTab");
    	//模型定义
    	paramMap.put("cnObjectName", "验证规则");
    	//模块页面排序
    	paramMap.put("pageSort", "6");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "1");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************验证规则表end********************************/
    	
    	/****************************************元素表start********************************/
    	//表名称
    	paramMap.put("tableName", "element_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "ElementTab");
    	//模型定义
    	paramMap.put("cnObjectName", "元素");
    	//模块页面排序
    	paramMap.put("pageSort", "7");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "1");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************元素表end********************************/

    	//模块所属菜单名称 
    	paramMap.put("menuName", "配置管理");
    	/****************************************数据字典表start********************************/
    	//表名称
    	paramMap.put("tableName", "dictionaries_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "DictionariesTab");
    	//模型定义
    	paramMap.put("cnObjectName", "数据字典");
    	//模块页面排序
    	paramMap.put("pageSort", "1");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "2");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************数据字典表end********************************/
    }
}
