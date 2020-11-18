package com.company.base.model;
import java.io.Serializable;



/**
 * @author yangyanchao
 *
 */
public class BaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8854172171163880901L;
	
	/**
	 * 字段分隔符
	 */
	private String separator;
	
	/**
	 * 换行符
	 */
	private String linefeed;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getLinefeed() {
		return linefeed;
	}

	public void setLinefeed(String linefeed) {
		this.linefeed = linefeed;
	}
}