package com.company.domain.verification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.company.base.exception.BaseException;
import com.company.config.job.JobParam;
import com.company.domain.query.LoopEndHandle;
import com.company.domain.query.LoopHandle;
import com.company.domain.query.handfile.HandleFileTabQueryDomain;
import com.company.domain.query.handledetail.HandleDetailTabQueryDomain;
import com.company.enums.HandleDetailTabStatus;
import com.company.enums.HandleFileTabStatus;
import com.company.enums.SubmissionError;
import com.company.one.handledetail.dao.HandleDetailTabMapper;
import com.company.one.handledetail.model.HandleDetailTab;
import com.company.one.handlefile.dao.HandleFileTabMapper;
import com.company.one.handlefile.model.HandleFileTab;

/**
 * 校验操作域
 * @author yangyanchao
 *
 */
public class VerificationDomain {
	/**
	 * 输出日志
	 */
	private Logger logger = LoggerFactory.getLogger(VerificationDomain.class);
	
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
	
    public VerificationDomain() {
		super();
	}
    
    public VerificationDomain(JobParam jobParam) {
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
	 * 查询明细数据，校验
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void verification() throws BaseException {
		//处理文件表相关查询域
		HandleFileTabQueryDomain handleFileTabQueryDomain = new HandleFileTabQueryDomain(HandleFileTabStatus.WAREHOUSING);
		//判断存在循环操作接口
		handleFileTabQueryDomain.setLoopHandle(new LoopHandle<HandleFileTabQueryDomain>() {
			
			@Override
			public void handle(HandleFileTabQueryDomain t) throws BaseException {
				//处理文件表数据实体
				HandleFileTab handleFileTab = t.getLoopEntity();
				//处理明细表相关查询域
				HandleDetailTabQueryDomain handleDetailTabQueryDomain = new HandleDetailTabQueryDomain(handleFileTab, HandleDetailTabStatus.WAREHOUSING, queryBatchMaxNum);
				//循环处理明细表操作
				handleDetailTabQueryDomain.setLoopHandle(new LoopHandle<HandleDetailTabQueryDomain>() {
					@Override
					public void handle(HandleDetailTabQueryDomain t) throws BaseException {
						HandleDetailTab handleDetailTab = t.getLoopEntity();
						//文件创建人代码
						String fileCreaterCode = handleDetailTab.getFileCreaterCode();
						//报送记录号
						String submissionRecordId = handleDetailTab.getSubmissionRecordId();
						//报送记录号（截取前6位）
						if(submissionRecordId.length() > 6){
							submissionRecordId = submissionRecordId.substring(0, 6);
						}
						if(!submissionRecordId.equals(fileCreaterCode)){
							//若比对不一致则处理明细表数据状态置为"上报失败：32"并记下校验未通过原因：1002"该报告报送记录号中机构号与文件名中的不一致"
							HandleDetailTab record = new HandleDetailTab();
							record.setId(handleDetailTab.getId());
							record.setStatus(HandleDetailTabStatus.SUBMITTEDERROR.getCode());
							record.setSubmissionError(SubmissionError.FILEANDSUBMISSIONNUMATYPISM.getValue());
							handleDetailTabMapper.updateByPrimaryKey(record);
						} else {
							//若比对一致则开始调用校验接口
							//json串
							String data = handleDetailTab.getDataJson();
							logger.info(data);
							boolean flag = true;
							if(flag){
								//校验通过
								//处理明细表数据状态置为"校验通过：21"
								HandleDetailTab record = new HandleDetailTab();
								record.setId(handleDetailTab.getId());
								record.setStatus(HandleDetailTabStatus.VERIFICATIONSUCCESS.getCode());
								handleDetailTabMapper.updateByPrimaryKey(record);
							} else {
								//校验未通过
								//处理明细表数据状态置为"校验未通过：22"并记下校验未通过原因
								HandleDetailTab record = new HandleDetailTab();
								record.setId(handleDetailTab.getId());
								record.setStatus(HandleDetailTabStatus.VERIFICATIONERROR.getCode());
								record.setResponseMsg("xxxxxx");
								handleDetailTabMapper.updateByPrimaryKey(record);
							}
						}
					}
				});
				//循环完毕操作
				handleDetailTabQueryDomain.setLoopEndHandle(new LoopEndHandle<HandleDetailTabQueryDomain>() {
					@Override
					public void handle(HandleDetailTabQueryDomain t) throws BaseException {
						HandleFileTab handleFileTab = t.getHandleFileTab();
						//将处理文件表数据状态置为"已校验：20"
						HandleFileTab record = new HandleFileTab();
						record.setId(handleFileTab.getId());
						record.setStatus(HandleFileTabStatus.VERIFICATION.getCode());
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
