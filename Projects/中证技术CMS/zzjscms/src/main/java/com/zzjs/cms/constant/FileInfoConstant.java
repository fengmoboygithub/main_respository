/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.constant;

/**
 * 文件常量
 * 
 * @author yangyanchao
 * 
 */
public class FileInfoConstant {
	
	
	/**
	 * 文件类别
	 * 
	 * @author yangyanchao
	 * 
	 */
	public static enum Types {
		/**
		 * 样式表
		 */
		css, 
		/**
		 *  脚本
		 */
		js,
		/**
		 *  html文件
		 */
		html,
	};

	/**
	 * 文件状态
	 * 
	 * @author yangyanchao
	 * 
	 */
	public static enum Status {
		/**
		 * 隐藏
		 */
		hidden, /**
		 * /** 公开的
		 */
		display,
	};
}
