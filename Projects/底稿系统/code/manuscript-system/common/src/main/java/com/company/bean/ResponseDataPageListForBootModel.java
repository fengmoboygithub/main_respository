
package com.company.bean;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 返回分页多条数据json对象  适应于bootstrap dataTable分页插件
 * 
 * @author yangyanchao
 * 
 * @param <T>
 */
@SuppressWarnings("deprecation")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseDataPageListForBootModel<T> extends ResponseModel{
	
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
	private long recordsTotal;
	/**
	 * 过滤后的记录数
	 */
	private long recordsFiltered;
	/**
	 * 中中需要显示的数据
	 */
	private List<T> data;
	
	/**
	 * 请求次数计数器，每次发送给服务器后又原封返回.
	 */
	private int draw;
	
	public ResponseDataPageListForBootModel() {
	}

	public ResponseDataPageListForBootModel(int pageIndex, int pageSize) {
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

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageCount() {
		this.pageCount = (((int)(this.getRecordsTotal()) - 1) / this.getPageSize()) + 1;
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

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

}
