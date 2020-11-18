/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zzjs.cms.constant.ConfigConstant;
import com.zzjs.cms.dao.ConfigDao;
import com.zzjs.cms.entity.Config;
import com.zzjs.cms.entity.vo.PageVo;

/**
 * 网站配置
 * 
 * @author yangyanchao
 * 
 */
@Service
public class ConfigService {

	@Autowired
	private ConfigDao configDao;
	
	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * 增加配置
	 * 
	 * @param key
	 * @param value
	 * @param description 
	 * @return Config
	 */
	public Config addConfig(String key, String value, String description) {
		Config config = new Config();
		config.setKey(key);
		config.setValue(value);
		config.setDescription(description);
		config.setCreateTime(new Date());
		configDao.addConfig(config);
		return config;
	}

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除配置
	 * 
	 * @param key
	 * @return Integer
	 */
	@CacheEvict(value = "config")
	public int deleteConfigByKey(String key) {
		return configDao.deleteConfig(key);
	}

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 更新配置
	 * 
	 * @param key
	 * @param value
	 */
	@CacheEvict(value = "config")
	public Config updagteConfigByKey(String key, String value) {
		Config config = configDao.getConfigByKey(key);
		config.setValue(value);
		configDao.updateConfig(config);
		this.getStringByKey(key);
		return config;
	}

	/**
	 * @param key
	 * @return
	 */
	@Cacheable(value = "config")
	public String getStringByKey(String key) {
		Config config = configDao.getConfigByKey(key);
		if (config == null) {
			return "";
		} else {
			return config.getValue();
		}
	}

	/**
	 * 查询配置数据
	 * @param key
	 * @return
	 */
	public Config getConfigByKey(String key) {
		return configDao.getConfigByKey(key);
	}
	
	/**
	 * @param key
	 * @return
	 */
	@Cacheable(value = "config")
	public int getIntKey(String key) {
		Config config = configDao.getConfigByKey(key);
		if (config == null) {
			return 0;
		} else {
			return Integer.parseInt(config.getValue());
		}
	}

	/**
	 * 配置分页查询方法
	 * @param pageNum
	 * @return
	 */
	public PageVo<Config> getConfigListPage(int pageNum) {
		PageVo<Config> pageVo = new PageVo<Config>(pageNum);
		pageVo.setRows(this.getIntKey(ConfigConstant.ZZJS_CMS_ROWS));
		List<Config> list = this.getConfigList(pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setCount(this.getConfigListCount());
		return pageVo;
	}

	/**
	 * 配置数据总数
	 * @return
	 */
	public int getConfigListCount() {
		return configDao.getConfigListCount();
	}

	/**
	 * 条件分页查询配置信息数据
	 * @param offset
	 * @param rows
	 * @return
	 */
	public List<Config> getConfigList(int offset, int rows) {
		return configDao.getConfigList(offset, rows);
	}
	
	/**
	 * 删除配置数据
	 * @param key
	 */
	public int deleteConfig(String key) {
		return configDao.deleteConfig(key);
	}

	/**
	 * 更新配置信息
	 * @param key
	 * @param value
	 * @param description
	 * @return
	 */
	public Config updateConfig(String key, String value, String description) {
		Config config = configDao.getConfigByKey(key);
		config.setValue(value);
		config.setUpdateTime(new Date());
		config.setDescription(description);
		configDao.updateConfig(config);
		return config;
	}
}
