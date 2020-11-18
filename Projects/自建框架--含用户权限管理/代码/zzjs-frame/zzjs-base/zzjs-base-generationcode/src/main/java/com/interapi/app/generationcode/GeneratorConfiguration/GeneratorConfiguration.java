package com.interapi.app.generationcode.GeneratorConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自动生成代码类
 * @author yangyanchao
 *
 */
public class GeneratorConfiguration {
	
	public static Logger logger = LoggerFactory.getLogger(GeneratorConfiguration.class);
	
    public static void main(String[] args) throws Exception {
    	Map<String, String> paramMap = new HashMap<String, String>();
    	//数据库类型
    	paramMap.put("dialect", "mysql");
    	//导出地址
    	paramMap.put("outPath", "D://outputcode/");
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
    	
    	/****************************************模块表start********************************/
    	//表名称
    	paramMap.put("tableName", "modular_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "ModularTab");
    	//模型定义
    	paramMap.put("cnObjectName", "模块");
    	//模块所属菜单排序
    	paramMap.put("pageSort", "6");
    	//模块页面排序
    	paramMap.put("menuSort", "2");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************模块表end********************************/
    	
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
    
    /**
     * 通过generatorConfig.xml配置信息 反向生成代码
     * @throws Exception
     */
    public static void generatorConfigForGen(Map<String, String> paramMap) throws Exception {
    	//根据Map 生成属性配置文件
    	GeneratorConfiguration.genPropertiesFile(paramMap);
    	String dialect = paramMap.get("dialect");
    	List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        File configFile = new File(GeneratorConfiguration.class.getClassLoader().getResource("generatorConfig_"+dialect+".xml").getFile());
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
    /**
     * 根据Map 生成属性配置文件
     * @param paramMap
     * @throws Exception
     */
    public static void genPropertiesFile(Map<String, String> paramMap) throws Exception {
    	
    	File parentFile = new File(GeneratorConfiguration.class.getClassLoader().getResource("").getFile());
    	File propertiesFile = new File(parentFile, "init.properties");
    	Properties pps = new Properties();
    	InputStream in = new FileInputStream(propertiesFile);
    	//从输入流中读取属性列表（键和元素对） 
    	pps.load(in);
    	//调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。  
    	//强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
    	OutputStream out = new FileOutputStream(propertiesFile);
    	if(paramMap != null && paramMap.size() > 0){
    		for(Entry<String, String> entry : paramMap.entrySet()){
    			pps.setProperty(entry.getKey(), entry.getValue());
    		}
    	}
    	//以适合使用 load 方法加载到 Properties 表中的格式，  
    	//将此 Properties 表中的属性列表（键和元素对）写入输出流  
    	pps.store(out, "");
    	logger.info("恭喜init.properties生成成功~~，路径："+propertiesFile.getPath()+"");
    }
}
