package com.company.config.job;

/**
 * 任务参数类
 * @author yangyanchao
 *
 */
public class JobParam {
	/**
	 * 任务执行结果输出目录
	 */
	private String outputPath;
	/**
	 * 设置查询一批次中最多行数
	 */
	private Integer pageSize;
	
	/**
	 * 字段分隔符
	 */
	private String separator;
	
	/**
	 * 换行符
	 */
	private String linefeed;

	public JobParam() {
		super();
	}

	public JobParam(String outputPath, Integer pageSize, String separator, String linefeed) {
		super();
		this.outputPath = outputPath;
		this.pageSize = pageSize;
		this.separator = separator;
		this.linefeed = linefeed;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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

	@Override
	public String toString() {
		return "JobConfig [outputPath=" + outputPath + ", pageSize=" + pageSize + ", separator=" + separator
				+ ", linefeed=" + linefeed + "]";
	}
}
