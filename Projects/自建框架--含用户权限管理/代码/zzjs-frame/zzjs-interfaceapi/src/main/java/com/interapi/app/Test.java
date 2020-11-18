package com.interapi.app;

import java.util.HashMap;
import java.util.Map;

import com.interapi.app.generationcode.GeneratorConfiguration.GeneratorConfiguration;

public class Test {
	public static void main(String[] args) throws Exception {
    	Map<String, String> paramMap = new HashMap<String, String>();
    	//数据库类型
    	paramMap.put("dialect", "mysql");
    	//导出地址
    	paramMap.put("outPath", "D://outputcode/");
    	//数据库连接地址
    	paramMap.put("jdbcUrl", "jdbc:mysql://127.0.0.1:3306/bmp");
    	//生成包名
    	paramMap.put("packageName", "bmp");
    	//模块所属菜单名称
    	paramMap.put("menuName", "基础信息管理");
    	/****************************************用户表start********************************/
    	//表名称
    	paramMap.put("tableName", "user_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "UserTab");
    	//模型定义
    	paramMap.put("cnObjectName", "用户");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "1");
    	//模块页面排序
    	paramMap.put("menuSort", "2");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************用户表end********************************/
    	
    	/****************************************角色表start********************************/
    	//表名称
    	paramMap.put("tableName", "role_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "RoleTab");
    	//模型定义
    	paramMap.put("cnObjectName", "角色");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "2");
    	//模块页面排序
    	paramMap.put("menuSort", "2");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************角色表end********************************/
    	
    	/****************************************权限表start********************************/
    	//表名称
    	paramMap.put("tableName", "authority_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "AuthorityTab");
    	//模型定义
    	paramMap.put("cnObjectName", "权限");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "3");
    	//模块页面排序
    	paramMap.put("menuSort", "2");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************权限表end********************************/
    	
    	/****************************************菜单页面表start********************************/
    	//表名称
    	paramMap.put("tableName", "page_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "PageTab");
    	//模型定义
    	paramMap.put("cnObjectName", "菜单页面");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "4");
    	//模块页面排序
    	paramMap.put("menuSort", "2");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************菜单页面表end********************************/
    	
    	/****************************************接口资源表start********************************/
    	//表名称
    	paramMap.put("tableName", "resource_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "ResourceTab");
    	//模型定义
    	paramMap.put("cnObjectName", "接口资源");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "5");
    	//模块页面排序
    	paramMap.put("menuSort", "2");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************接口资源表end********************************/
    	
    	/****************************************配置表start********************************/
    	//表名称
    	paramMap.put("tableName", "config_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "ConfigTab");
    	//模型定义
    	paramMap.put("cnObjectName", "配置");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "7");
    	//模块页面排序
    	paramMap.put("menuSort", "2");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************配置表end********************************/
    	
    	
    	//模块所属菜单名称
    	paramMap.put("menuName", "组织结构管理");
    	/****************************************机构表start********************************/
    	//表名称
    	paramMap.put("tableName", "ins_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "InsTab");
    	//模型定义
    	paramMap.put("cnObjectName", "机构");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "1");
    	//模块页面排序
    	paramMap.put("menuSort", "3");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************机构表end********************************/
    	
    	/****************************************部门表start********************************/
    	//表名称
    	paramMap.put("tableName", "dept_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "DeptTab");
    	//模型定义
    	paramMap.put("cnObjectName", "部门");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "2");
    	//模块页面排序
    	paramMap.put("menuSort", "3");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************部门表end********************************/

    	/****************************************岗位表start********************************/
    	//表名称
    	paramMap.put("tableName", "post_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "PostTab");
    	//模型定义
    	paramMap.put("cnObjectName", "岗位");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "3");
    	//模块页面排序
    	paramMap.put("menuSort", "3");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************岗位表end********************************/
    	
    	
    	//模块所属菜单名称
    	paramMap.put("menuName", "关系信息管理");
    	/****************************************用户角色表start********************************/
    	//表名称
    	paramMap.put("tableName", "user_role_rela");
    	//模型实体名称
    	paramMap.put("domainObjectName", "UserRoleRela");
    	//模型定义
    	paramMap.put("cnObjectName", "用户角色");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "1");
    	//模块页面排序
    	paramMap.put("menuSort", "4");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************用户角色表end********************************/
    	
    	/****************************************用户岗位表start********************************/
    	//表名称
    	paramMap.put("tableName", "user_post_rela");
    	//模型实体名称
    	paramMap.put("domainObjectName", "UserPostRela");
    	//模型定义
    	paramMap.put("cnObjectName", "用户岗位");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "2");
    	//模块页面排序
    	paramMap.put("menuSort", "4");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************用户岗位表end********************************/
    	
    	/****************************************岗位角色表start********************************/
    	//表名称
    	paramMap.put("tableName", "post_role_rela");
    	//模型实体名称
    	paramMap.put("domainObjectName", "PostRoleRela");
    	//模型定义
    	paramMap.put("cnObjectName", "岗位角色");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "3");
    	//模块页面排序
    	paramMap.put("menuSort", "4");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************岗位角色表end********************************/
    	
    	/****************************************角色权限表start********************************/
    	//表名称
    	paramMap.put("tableName", "role_authority_rela");
    	//模型实体名称
    	paramMap.put("domainObjectName", "RoleAuthorityRela");
    	//模型定义
    	paramMap.put("cnObjectName", "角色权限");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "4");
    	//模块页面排序
    	paramMap.put("menuSort", "4");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************角色权限表end********************************/
    	
    	/****************************************权限页面表start********************************/
    	//表名称
    	paramMap.put("tableName", "authority_page_rela");
    	//模型实体名称
    	paramMap.put("domainObjectName", "AuthorityPageRela");
    	//模型定义
    	paramMap.put("cnObjectName", "权限页面");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "5");
    	//模块页面排序
    	paramMap.put("menuSort", "4");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************权限页面表end********************************/

    	/****************************************权限资源表start********************************/
    	//表名称
    	paramMap.put("tableName", "authority_resource_rela");
    	//模型实体名称
    	paramMap.put("domainObjectName", "AuthorityResourceRela");
    	//模型定义
    	paramMap.put("cnObjectName", "权限资源");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "6");
    	//模块页面排序
    	paramMap.put("menuSort", "4");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************权限资源表end********************************/
    }
}
