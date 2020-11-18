/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.constant;

/**
 * 附件
 * 
 * @author yangyanchao
 * 
 */
public class MediaConstant {

	/**
	 * 类型<br>
	 * photo：照片<br>
	 * file：文件<br>
	 * 
	 * @author yangyanchao
	 * 
	 */
	public static enum Type {
		/**
		 * 相册
		 */
		photo, /**
		 * 文件
		 */
		file, video
	}

	/**
	 * 种类
	 * 
	 * @author yangyanchao
	 * 
	 */
	public static enum Kind {
		/**
		 * 目录
		 */
		folder, /**
		 * 文件
		 */
		article, /**
		 * 编辑器
		 */
		editor
	}
}
