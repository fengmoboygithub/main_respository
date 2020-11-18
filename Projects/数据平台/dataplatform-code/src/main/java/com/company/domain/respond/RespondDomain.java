package com.company.domain.respond;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.company.base.exception.BaseException;
import com.company.config.job.JobParam;
import com.company.domain.query.LoopHandle;
import com.company.domain.query.handfile.HandleFileTabQueryDomain;
import com.company.domain.query.handledetail.HandleDetailTabQueryDomain;
import com.company.domain.respond.createfile.CreateFileDomain;
import com.company.enums.HandleFileTabStatus;
import com.company.one.handlefile.model.HandleFileTab;

/**
 * 应答操作域
 * @author yangyanchao
 *
 */
public class RespondDomain {
	/**
	 * 输出日志
	 */
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(RespondDomain.class);
	
	/**
	 * 应答目录
	 */	
	private File respondDir;
	/**
	 * 设置查询一批次中最多行数
	 */
	private int queryBatchMaxNum;
	/**
	 * 字段分隔符
	 */
	private String separator;
	/**
	 * 换行符
	 */
	private String linefeed;
	/**
	 * 结束符
	 */
	private String end;
	
    public RespondDomain() {
		super();
	}
    
    public RespondDomain(JobParam jobParam) {
		super();
		//应答目录
		this.respondDir = jobParam.getRespondDir();
		//字段分隔符
		this.separator = jobParam.getSeparator();
		//换行符
		this.linefeed = jobParam.getLinefeed();
		//结束符
		this.end = jobParam.getEnd();
		//设置查询一批次中最多行数
		this.queryBatchMaxNum = jobParam.getQueryBatchMaxNum();
	}

	public File getRespondDir() {
		return respondDir;
	}

	public void setRespondDir(File respondDir) {
		this.respondDir = respondDir;
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

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getQueryBatchMaxNum() {
		return queryBatchMaxNum;
	}

	public void setQueryBatchMaxNum(int queryBatchMaxNum) {
		this.queryBatchMaxNum = queryBatchMaxNum;
	}

	/**
	 * 查询数据，生成应答文件
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void respond() throws BaseException {
		//处理文件表相关查询域
		HandleFileTabQueryDomain handleFileTabQueryDomain = new HandleFileTabQueryDomain(HandleFileTabStatus.SUBMITTED);
		//判断存在循环操作接口
		handleFileTabQueryDomain.setLoopHandle(new LoopHandle<HandleFileTabQueryDomain>() {
			
			@Override
			public void handle(HandleFileTabQueryDomain t) throws BaseException {
				//处理文件表数据实体
				HandleFileTab handleFileTab = t.getLoopEntity();
				//生成应答文件域
				CreateFileDomain createFileDomain = new CreateFileDomain(new File(respondDir, handleFileTab.getZipFileName()), handleFileTab.getFileCreaterCode(), handleFileTab.getFileReceiverCode(), handleFileTab.getInterfaceId(), handleFileTab.getFileNum(), separator, linefeed, end);
				//处理明细表相关查询域
				HandleDetailTabQueryDomain handleDetailTabQueryDomain = new HandleDetailTabQueryDomain(handleFileTab, null, queryBatchMaxNum);
				//遍历明细表数据生成应答文件
				createFileDomain.respondByHandleDetailTabQueryDomain(handleDetailTabQueryDomain);
			}
		});
		//根据字段status查询处理文件表数据
		handleFileTabQueryDomain.queryByStatus();
	}
}
