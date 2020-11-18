package com.company.domain.submitted;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.base.exception.BaseException;
import com.company.config.job.JobParam;
import com.company.domain.query.LoopEndHandle;
import com.company.domain.query.LoopHandle;
import com.company.domain.query.handfile.HandleFileTabQueryDomain;
import com.company.domain.query.handledetail.HandleDetailTabQueryDomain;
import com.company.enums.HandleDetailTabStatus;
import com.company.enums.HandleFileTabStatus;
import com.company.one.handledetail.dao.HandleDetailTabMapper;
import com.company.one.handledetail.model.HandleDetailTab;
import com.company.one.handlefile.dao.HandleFileTabMapper;
import com.company.one.handlefile.model.HandleFileTab;

/**
 * 报送操作域
 * @author yangyanchao
 *
 */
public class SubmittedDomain {
	/**
	 * 输出日志
	 */
	private Logger logger = LoggerFactory.getLogger(SubmittedDomain.class);
	
	/**
	 * 设置查询一批次中最多行数
	 */
	private int queryBatchMaxNum;
	
	/**
     * 处理文件--Mapper类
     */
    @Autowired
    private HandleFileTabMapper handleFileTabMapper;
    
    /**
	 * 处理明细--Mapper类
	 */
	@Autowired
	private HandleDetailTabMapper handleDetailTabMapper;
	
    public SubmittedDomain() {
		super();
	}
    
    public SubmittedDomain(JobParam jobParam) {
		super();
		//设置查询一批次中最多行数
		this.queryBatchMaxNum = jobParam.getQueryBatchMaxNum();
	}

	public int getQueryBatchMaxNum() {
		return queryBatchMaxNum;
	}

	public void setQueryBatchMaxNum(int queryBatchMaxNum) {
		this.queryBatchMaxNum = queryBatchMaxNum;
	}

	/**
	 * 查询明细数据，报送
	 * @throws BaseException
	 */
	public void submitted() throws BaseException {
		//处理文件表相关查询域
		HandleFileTabQueryDomain handleFileTabQueryDomain = new HandleFileTabQueryDomain(HandleFileTabStatus.VERIFICATION);
		//判断存在循环操作接口
		handleFileTabQueryDomain.setLoopHandle(new LoopHandle<HandleFileTabQueryDomain>() {
			
			@Override
			public void handle(HandleFileTabQueryDomain t) throws BaseException {
				//处理文件表数据实体
				HandleFileTab handleFileTab = t.getLoopEntity();
				//处理明细表相关查询域
				HandleDetailTabQueryDomain handleDetailTabQueryDomain = new HandleDetailTabQueryDomain(handleFileTab, HandleDetailTabStatus.VERIFICATIONSUCCESS, queryBatchMaxNum);
				//循环处理明细表操作
				handleDetailTabQueryDomain.setLoopHandle(new LoopHandle<HandleDetailTabQueryDomain>() {
					@Override
					public void handle(HandleDetailTabQueryDomain t) throws BaseException {
						HandleDetailTab handleDetailTab = t.getLoopEntity();
						//json串
						String data = handleDetailTab.getDataJson();
						logger.info(data);
						boolean flag = true;
						if(flag){
							//报送成功
							//处理明细表数据状态置为"上报成功：31"
							HandleDetailTab record = new HandleDetailTab();
							record.setId(handleDetailTab.getId());
							record.setStatus(HandleDetailTabStatus.SUBMITTEDSUCCESS.getCode());
							handleDetailTabMapper.updateByPrimaryKey(record);
						} else {
							//报送失败
							//处理明细表数据状态置为"上报失败：32"并记下上报失败原因
							HandleDetailTab record = new HandleDetailTab();
							record.setId(handleDetailTab.getId());
							record.setStatus(HandleDetailTabStatus.SUBMITTEDERROR.getCode());
							record.setSubmissionError("xxx");
							handleDetailTabMapper.updateByPrimaryKey(record);
						}
					}
				});
				//循环完毕操作
				handleDetailTabQueryDomain.setLoopEndHandle(new LoopEndHandle<HandleDetailTabQueryDomain>() {
					@Override
					public void handle(HandleDetailTabQueryDomain t) throws BaseException {
						HandleFileTab handleFileTab = t.getHandleFileTab();
						//将处理文件表数据状态置为"已上报：30"
						HandleFileTab record = new HandleFileTab();
						record.setId(handleFileTab.getId());
						record.setStatus(HandleFileTabStatus.SUBMITTED.getCode());
						handleFileTabMapper.updateByPrimaryKey(record);
					}
				});
				//查询处理明细表数据
				handleDetailTabQueryDomain.query();
			}
		});
		//根据字段status查询处理文件表数据
		handleFileTabQueryDomain.queryByStatus();
	}
}
