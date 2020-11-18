package com.company.domain.query.handledetail;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.base.exception.BaseException;
import com.company.domain.query.ExistHandle;
import com.company.domain.query.FirstHandle;
import com.company.domain.query.LoopEndHandle;
import com.company.domain.query.LoopHandle;
import com.company.domain.query.NotExistHandle;
import com.company.enums.HandleDetailTabStatus;
import com.company.one.handledetail.dao.HandleDetailTabMapper;
import com.company.one.handledetail.model.HandleDetailTab;
import com.company.one.handledetail.model.HandleDetailTabExample;
import com.company.one.handledetail.model.HandleDetailTabExample.Criteria;
import com.company.one.handlefile.model.HandleFileTab;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 处理明细表相关查询domain
 * @author yangyanchao
 *
 */
public class HandleDetailTabQueryDomain {
	/**
	 * 输出日志
	 */
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(HandleDetailTabQueryDomain.class);

	/**
	 * 处理文件表实体
	 */
	private HandleFileTab handleFileTab;
	
	/**
     * 报送记录号
     */
    private String submissionRecordId;

    /**
     * 状态
     */
    private HandleDetailTabStatus status;
    
    /**
	 * 设置查询一批次中最多行数
	 */
	private int queryBatchMaxNum;
	
	/**
	 * 处理明细--Mapper类
	 */
	@Autowired
	private HandleDetailTabMapper handleDetailTabMapper;
	
	/**
     * 比对实体
     */
    private HandleDetailTab comparisonEntity;
	
    /**
     * 循环中的实体
     */
    private HandleDetailTab loopEntity;
    
	/**
	 * 判断存在循环操作接口
	 */
	private LoopHandle<HandleDetailTabQueryDomain> loopHandle;
	
	/**
	 * 循环完毕操作接口
	 */
	private LoopEndHandle<HandleDetailTabQueryDomain> loopEndHandle;
	
	/**
	 * 判断存在操作接口
	 */
	private ExistHandle<HandleDetailTabQueryDomain> existHandle;
	
	/**
	 * 判断不存在操作接口
	 */
	private NotExistHandle<HandleDetailTabQueryDomain> notExistHandle;
	
	/**
	 * 总条数
	 */
	private long totalNum;
	
	/**
	 * 当前序号
	 */
	private int currCount;
	
	/**
	 * 第一次操作接口
	 */
	private FirstHandle<HandleDetailTabQueryDomain> firstHandle;
	
	public HandleDetailTabQueryDomain() {
		super();
	}
	
	public HandleDetailTabQueryDomain(HandleFileTab handleFileTab, HandleDetailTabStatus status, int queryBatchMaxNum) {
		super();
		this.handleFileTab = handleFileTab;
		this.status = status;
	}

	public HandleDetailTabQueryDomain(HandleFileTab handleFileTab, String submissionRecordId, HandleDetailTabStatus status) {
		super();
		this.handleFileTab = handleFileTab;
		this.submissionRecordId = submissionRecordId;
		this.status = status;
	}

	public FirstHandle<HandleDetailTabQueryDomain> getFirstHandle() {
		return firstHandle;
	}

	public void setFirstHandle(FirstHandle<HandleDetailTabQueryDomain> firstHandle) {
		this.firstHandle = firstHandle;
	}

	public int getCurrCount() {
		return currCount;
	}

	public long getTotalNum() {
		return totalNum;
	}

	public String getSubmissionRecordId() {
		return submissionRecordId;
	}

	public void setSubmissionRecordId(String submissionRecordId) {
		this.submissionRecordId = submissionRecordId;
	}

	public HandleDetailTabStatus getStatus() {
		return status;
	}

	public void setStatus(HandleDetailTabStatus status) {
		this.status = status;
	}

	public int getQueryBatchMaxNum() {
		return queryBatchMaxNum;
	}

	public void setQueryBatchMaxNum(int queryBatchMaxNum) {
		this.queryBatchMaxNum = queryBatchMaxNum;
	}

	public HandleFileTab getHandleFileTab() {
		return handleFileTab;
	}

	public void setHandleFileTab(HandleFileTab handleFileTab) {
		this.handleFileTab = handleFileTab;
	}

	public LoopHandle<HandleDetailTabQueryDomain> getLoopHandle() {
		return loopHandle;
	}

	public void setLoopHandle(LoopHandle<HandleDetailTabQueryDomain> loopHandle) {
		this.loopHandle = loopHandle;
	}

	public ExistHandle<HandleDetailTabQueryDomain> getExistHandle() {
		return existHandle;
	}

	public void setExistHandle(ExistHandle<HandleDetailTabQueryDomain> existHandle) {
		this.existHandle = existHandle;
	}

	public NotExistHandle<HandleDetailTabQueryDomain> getNotExistHandle() {
		return notExistHandle;
	}

	public void setNotExistHandle(NotExistHandle<HandleDetailTabQueryDomain> notExistHandle) {
		this.notExistHandle = notExistHandle;
	}
	
	public LoopEndHandle<HandleDetailTabQueryDomain> getLoopEndHandle() {
		return loopEndHandle;
	}

	public void setLoopEndHandle(LoopEndHandle<HandleDetailTabQueryDomain> loopEndHandle) {
		this.loopEndHandle = loopEndHandle;
	}

	public HandleDetailTab getLoopEntity() {
		return loopEntity;
	}

	public HandleDetailTab getComparisonEntity() {
		return comparisonEntity;
	}

	/**
	 * 查询处理明细表数据用于比对
	 * @throws BaseException
	 */
	public void queryForComparison() throws BaseException {
		HandleDetailTabExample example = new HandleDetailTabExample();
		Criteria criteria = example.createCriteria();
		//根据报送记录号和处理文件表(文件创建人代码、文件接收人代码、接口标识)、状态为"上报成功：31"查询处理明细表数据
		criteria.andSubmissionRecordIdEqualTo(submissionRecordId);
		criteria.andStatusEqualTo(status.getCode());
		criteria.andFileCreaterCodeEqualTo(handleFileTab.getFileCreaterCode());
		criteria.andFileReceiverCodeEqualTo(handleFileTab.getFileReceiverCode());
		criteria.andInterfaceIdEqualTo(handleFileTab.getInterfaceId());
		List<HandleDetailTab> handleDetailTabList = handleDetailTabMapper.selectByExample(example);
		if(handleDetailTabList != null && handleDetailTabList.size() > 0){
			HandleDetailTab comparisonEntity = handleDetailTabList.get(0);
			this.comparisonEntity = comparisonEntity;
			//存在操作
			if(existHandle != null){
				existHandle.handle(this);
			}
		} else {
			//不存在操作
			if(notExistHandle != null){
				notExistHandle.handle(this);
			}
		}
	}
	
	/**
	 * 查询处理明细表数据
	 * @throws BaseException
	 */
	public void query() throws BaseException {
		HandleDetailTabExample example = new HandleDetailTabExample();
		Criteria criteria = example.createCriteria();
		//根据处理文件表主键和状态查询处理明细表数据
		criteria.andFileIdEqualTo(handleFileTab.getId());
		if(status != null){
			criteria.andStatusEqualTo(status.getCode());
		}
		
		PageHelper.startPage(1, queryBatchMaxNum); 
		List<HandleDetailTab> handleDetailTabListOne = handleDetailTabMapper.selectByExample(example);
		PageInfo<HandleDetailTab> page = new PageInfo<HandleDetailTab>(handleDetailTabListOne);
		if(page != null && page.getTotal() > 0 && page.getList() != null && page.getList().size() > 0){
			//总页数
			int totalPages = page.getPages();
			this.totalNum = page.getTotal();
			if(firstHandle != null){
				firstHandle.handle(this);
			}
			int count = 1;
			for(int pageNum=1; pageNum<=totalPages; pageNum++){
				PageHelper.startPage(pageNum, queryBatchMaxNum);
				List<HandleDetailTab> handleDetailTabList = handleDetailTabMapper.selectByExample(example);
				if(handleDetailTabList != null && handleDetailTabList.size() > 0){
					for(HandleDetailTab loopEntity : handleDetailTabList){
						//循环中的实体
						this.loopEntity = loopEntity;
						this.currCount = count;
						//存在则循环操作
						if(loopHandle != null){
							loopHandle.handle(this);
						}
						count++;
					}
					//循环完毕操作
					if(loopEndHandle != null){
						loopEndHandle.handle(this);
					}
				} else {
					//不存在操作
					if(notExistHandle != null){
						notExistHandle.handle(this);
					}
				}
			}
		}
	}
}
