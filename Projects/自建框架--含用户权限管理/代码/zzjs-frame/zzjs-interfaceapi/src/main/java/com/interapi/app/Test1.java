package com.interapi.app;

import java.util.HashMap;
import java.util.Map;

import com.interapi.app.generationcode.GeneratorConfiguration.GeneratorConfiguration;

public class Test1 {
	/**
	 * 	站点管理
			site_tab                              站点表
			file_tab                              页面表
			folder_tab                            目录表
			media_tab                             资源表
		组件管理
			component_tab                         组件表
			component_type_tab                    组件类型表
		组件实例管理
			component_instance_tab                组件实例表
			data_json_instance_tab		      	     数据参数实例表
		组件模板管理
			component_template_tab                组件模板表
			data_json_template_tab		                            数据参数模板表
		配置管理
			dictionary_tab                        数据字典表
		关系管理
			media_folder_rela                     资源目录关系表
			media_file_rela                       资源页面关系表
			user_site_rela                        用户站点关系表
			component_import_rela                 组件引入关系表
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
    	paramMap.put("jdbcUrl", "jdbc:mysql://127.0.0.1:3306/webcomponent");
    	//生成包名
    	paramMap.put("packageName", "component");
    	//模块所属菜单名称 
    	paramMap.put("menuName", "站点管理");
    	/****************************************站点表start********************************/
    	//表名称
    	paramMap.put("tableName", "site_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "SiteTab");
    	//模型定义
    	paramMap.put("cnObjectName", "站点");
    	//模块页面排序
    	paramMap.put("pageSort", "1");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "1");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************站点表end********************************/
    	
    	/****************************************页面表start********************************/
    	//表名称
    	paramMap.put("tableName", "file_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "FileTab");
    	//模型定义
    	paramMap.put("cnObjectName", "页面");
    	//模块页面排序
    	paramMap.put("pageSort", "2");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "1");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************页面表end********************************/
    	
    	/****************************************目录表start********************************/
    	//表名称
    	paramMap.put("tableName", "folder_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "FolderTab");
    	//模型定义
    	paramMap.put("cnObjectName", "目录");
    	//模块页面排序
    	paramMap.put("pageSort", "3");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "1");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************目录表end********************************/
    	
    	/****************************************资源表start********************************/
    	//表名称
    	paramMap.put("tableName", "media_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "MediaTab");
    	//模型定义
    	paramMap.put("cnObjectName", "资源");
    	//模块页面排序
    	paramMap.put("pageSort", "4");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "1");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************资源表end********************************/
    	
    	//模块所属菜单名称 
    	paramMap.put("menuName", "组件管理");
    	/****************************************组件表start********************************/
    	//表名称
    	paramMap.put("tableName", "component_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "ComponentTab");
    	//模型定义
    	paramMap.put("cnObjectName", "组件");
    	//模块页面排序
    	paramMap.put("pageSort", "1");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "2");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************组件表end********************************/
    	
    	/****************************************组件类型表start********************************/
    	//表名称
    	paramMap.put("tableName", "component_type_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "ComponentTypeTab");
    	//模型定义
    	paramMap.put("cnObjectName", "组件类型");
    	//模块页面排序
    	paramMap.put("pageSort", "2");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "2");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************组件类型表end********************************/
    	
    	//模块所属菜单名称 
    	paramMap.put("menuName", "组件实例管理");
    	/****************************************组件实例表start********************************/
    	//表名称
    	paramMap.put("tableName", "component_instance_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "ComponentInstanceTab");
    	//模型定义
    	paramMap.put("cnObjectName", "组件实例");
    	//模块页面排序
    	paramMap.put("pageSort", "1");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "3");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************组件实例表end********************************/
    	
    	/****************************************数据参数实例表start********************************/
    	//表名称
    	paramMap.put("tableName", "data_json_instance_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "DataJsonInstanceTab");
    	//模型定义
    	paramMap.put("cnObjectName", "数据参数实例");
    	//模块页面排序
    	paramMap.put("pageSort", "2");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "3");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************数据参数实例表end********************************/
    	//模块所属菜单名称 
    	paramMap.put("menuName", "组件模板管理");
    	/****************************************组件模板表start********************************/
    	//表名称
    	paramMap.put("tableName", "component_template_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "ComponentTemplateTab");
    	//模型定义
    	paramMap.put("cnObjectName", "组件模板");
    	//模块页面排序
    	paramMap.put("pageSort", "1");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "4");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************组件模板表end********************************/
    	
    	/****************************************数据参数模板表start********************************/
    	//表名称
    	paramMap.put("tableName", "data_json_template_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "DataJsonTemplateTab");
    	//模型定义
    	paramMap.put("cnObjectName", "数据参数模板");
    	//模块页面排序
    	paramMap.put("pageSort", "2");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "4");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************数据参数模板表end********************************/
    	
    	//模块所属菜单名称 
    	paramMap.put("menuName", "配置管理");
    	/****************************************数据字典表start********************************/
    	//表名称
    	paramMap.put("tableName", "dictionary_tab");
    	//模型实体名称
    	paramMap.put("domainObjectName", "DictionaryTab");
    	//模型定义
    	paramMap.put("cnObjectName", "数据字典");
    	//模块页面排序
    	paramMap.put("pageSort", "1");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "5");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************数据字典表end********************************/

    	//模块所属菜单名称 
    	paramMap.put("menuName", "关系管理");
    	/****************************************资源目录关系表start********************************/
    	//表名称
    	paramMap.put("tableName", "media_folder_rela");
    	//模型实体名称
    	paramMap.put("domainObjectName", "MediaFolderRela");
    	//模型定义
    	paramMap.put("cnObjectName", "资源目录关系");
    	//模块页面排序
    	paramMap.put("pageSort", "1");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "6");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************资源目录关系表end********************************/
    	
    	/****************************************资源页面关系表start********************************/
    	//表名称
    	paramMap.put("tableName", "media_file_rela");
    	//模型实体名称
    	paramMap.put("domainObjectName", "MediaFileRela");
    	//模型定义
    	paramMap.put("cnObjectName", "资源页面关系");
    	//模块页面排序
    	paramMap.put("pageSort", "2");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "6");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************资源页面关系表end********************************/
    	
    	/****************************************用户站点关系表start********************************/
    	//表名称
    	paramMap.put("tableName", "user_site_rela");
    	//模型实体名称
    	paramMap.put("domainObjectName", "UserSiteRela");
    	//模型定义
    	paramMap.put("cnObjectName", "用户站点关系");
    	//模块页面排序
    	paramMap.put("pageSort", "3");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "6");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************用户站点关系表end********************************/

    	/****************************************组件引入关系表start********************************/
    	//表名称
    	paramMap.put("tableName", "component_import_rela");
    	//模型实体名称
    	paramMap.put("domainObjectName", "ComponentImportRela");
    	//模型定义
    	paramMap.put("cnObjectName", "用户站点关系");
    	//模块页面排序
    	paramMap.put("pageSort", "4");
    	//模块所属菜单排序
    	paramMap.put("menuSort", "6");
    	GeneratorConfiguration.generatorConfigForGen(paramMap);
    	/****************************************组件引入关系表end********************************/
    }
}
