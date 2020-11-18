/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.json;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.zzjs.cms.base.json.BaseJson;

/**
 * 返回分页多条数据json对象 
 * 
 * @author yangyanchao
 * 
 * @param <T>
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PageJson<T> extends BaseJson{
	
	/**
	 * 状态码
	 */
	private int status = 0;
	/**
	 * 页码
	 */
	private int pageIndex = 1;
	/**
	 * 数量
	 */
	private int pageSize = 10;
	/**
	 * 页码总数
	 */
	private int pageCount;
	/**
	 * 总数
	 */
	private int matchedTotal;
	/**
	 * 数据
	 */
	private List<T> resultSet;
	
	public PageJson() {
	}

	public PageJson(int pageIndex, int pageSize) {
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
	

	public int getPageIndex() {
		if (this.pageIndex <= 0) {
			this.pageIndex = 1;
			return 1;
		} else {
			return pageIndex;
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageCount() {
		this.pageCount = ((this.getMatchedTotal() - 1) / this.getPageSize()) + 1;
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getResultSet() {
		return resultSet;
	}

	public void setResultSet(List<T> resultSet) {
		this.resultSet = resultSet;
	}

	public int getMatchedTotal() {
		return matchedTotal;
	}

	public void setMatchedTotal(int matchedTotal) {
		this.matchedTotal = matchedTotal;
	}
}
