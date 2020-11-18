/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.company.constant;

import org.springframework.stereotype.Component;

/**
 * 通用常量
 * 
 * @author yangyanchao
 */
@Component
public class BaseConstant {
	
	/**
	 * 登录会话中用户ID的session会话中的key值
	 */
	public static final String LOGIN_KEY="LOGIN_SESSION_KEY";
    /**
     * 登录会话中用户对象的session会话中的key值
     */
    public static final String LOGIN_USER="LOGIN_SESSION_USER";

	/**
	 * 注销标识 '注销'
	 */
	public static String DEL_FLAG_YES = "1";
	/**
	 * 注销标识 '正常'
	 */
	public static String DEL_FLAG_NO = "0";
	
	/**
	 * 是否适用 '适用'
	 */
	public static Boolean APPLY_FLAG_YES = true;
	/**
	 * 注销标识 '不使用'
	 */
	public static  Boolean APPLY_FLAG_NO = false;
	/**
	 * 输出JS文件目录
	 */
	public static final String ZZJS_COMPONENT_DIR = "zzjs_component_dir";
	/**
	 * 输出模板目录
	 */
	public static String ZZJS_TEMPLATE = "zzjs_template";
	/**
	 * 输出模板文件
	 */
	public static String ZZJS_TEMPLATE_FILE = "zzjs_template_file";
	/**
	 * 输出js模板文件
	 */
	public static String ZZJS_JS_TEMPLATE_FILE = "zzjs_js_template_file";
	/**
	 * 导出站点目录路径
	 */
	public static String ZZJS_SITE_FOLDER = "zzjs_site_folder";
	/**
	 * cms默认每页显示条数
	 */
	public static String ZZJS_CMS_ROWS = "zzjs_cms_rows";
	/**
	 * 服务模式
	 */
	public static String ZZJS_CMS_MODEL = "zzjs_cms_model";
	/**
	 * 资源项目真实地址
	 */
	public static String ZZJS_CMS_SOURCE_REAL_ADDRESS = "zzjs_cms_source_real_address_";
	/**
	 * 资源项目访问地址
	 */
	public static String ZZJS_CMS_SOURCE_ADDRESS = "zzjs_cms_source_address_";
	
	/**
	 * 网站名称
	 */
	public static String ZZJS_SEO_TITLE = "zzjs_seo_title";
	/**
	 * 网站描述
	 */
	public static String ZZJS_SEO_DESCRIPTION = "zzjs_seo_description";
}
