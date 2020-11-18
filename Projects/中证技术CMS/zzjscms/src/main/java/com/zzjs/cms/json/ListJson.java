package com.zzjs.cms.json;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.zzjs.cms.base.json.BaseJson;

/**
 * 返回多条数据json对象 
 * 
 * @param <T>
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ListJson<T> extends BaseJson{
	/**
	 * 数据
	 */
	private List<T> list;
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
