package com.company.domain.query.handplain;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.base.exception.BaseException;
import com.company.domain.query.LoopEndHandle;
import com.company.domain.query.LoopHandle;
import com.company.domain.query.NotExistHandle;
import com.company.one.handlefile.model.HandleFileTab;
import com.company.one.handleplain.dao.HandlePlainTmpMapper;
import com.company.one.handleplain.model.HandlePlainTmp;
import com.company.one.handleplain.model.HandlePlainTmpExample;
import com.company.one.handleplain.model.HandlePlainTmpExample.Criteria;
import com.company.one.handletuple.dao.HandleTupleTmpMapper;
import com.company.one.handletuple.model.HandleTupleTmp;
import com.company.one.handletuple.model.HandleTupleTmpExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 文件内容表与文件内容元组表相关查询domain
 * @author yangyanchao
 *
 */
public class HandlePlainTabQueryDomain {
	/**
	 * 输出日志
	 */
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(HandlePlainTabQueryDomain.class);
	
	/**
	 * 文件内容--Mapper类
	 */
	@Autowired
	private HandlePlainTmpMapper handlePlainTmpMapper;
	
	/**
	 * 文件内容元组--Mapper类
	 */
	@Autowired
	private HandleTupleTmpMapper handleTupleTmpMapper;
	
	/**
	 * 处理文件表实体
	 */
	private HandleFileTab handleFileTab;
	
	/**
	 * 设置查询一批次中最多行数
	 */
	private int queryBatchMaxNum;
    
    /**
     * 循环中的实体
     */
    private HandlePlainTmp loopEntity;
    
    /**
     * 循环中的Tuple实体列表
     */
    private List<HandleTupleTmp> loopEntityTuple;
    
	/**
	 * 判断存在循环操作接口
	 */
	private LoopHandle<HandlePlainTabQueryDomain> loopHandle;
	
	/**
	 * 循环完毕操作接口
	 */
	private LoopEndHandle<HandlePlainTabQueryDomain> loopEndHandle;
	
	/**
	 * 判断不存在操作接口
	 */
	private NotExistHandle<HandlePlainTabQueryDomain> notExistHandle;
	
	public HandlePlainTabQueryDomain() {
		super();
	}

	public HandlePlainTabQueryDomain(HandleFileTab handleFileTab, int queryBatchMaxNum) {
		super();
		this.handleFileTab = handleFileTab;
		this.queryBatchMaxNum = queryBatchMaxNum;
	}

	public HandlePlainTmp getLoopEntity() {
		return loopEntity;
	}

	public List<HandleTupleTmp> getLoopEntityTuple() {
		return loopEntityTuple;
	}

	public HandleFileTab getHandleFileTab() {
		return handleFileTab;
	}

	public void setHandleFileTab(HandleFileTab handleFileTab) {
		this.handleFileTab = handleFileTab;
	}

	public int getQueryBatchMaxNum() {
		return queryBatchMaxNum;
	}

	public void setQueryBatchMaxNum(int queryBatchMaxNum) {
		this.queryBatchMaxNum = queryBatchMaxNum;
	}

	public LoopHandle<HandlePlainTabQueryDomain> getLoopHandle() {
		return loopHandle;
	}

	public void setLoopHandle(LoopHandle<HandlePlainTabQueryDomain> loopHandle) {
		this.loopHandle = loopHandle;
	}

	public NotExistHandle<HandlePlainTabQueryDomain> getNotExistHandle() {
		return notExistHandle;
	}

	public void setNotExistHandle(NotExistHandle<HandlePlainTabQueryDomain> notExistHandle) {
		this.notExistHandle = notExistHandle;
	}
	
	public LoopEndHandle<HandlePlainTabQueryDomain> getLoopEndHandle() {
		return loopEndHandle;
	}

	public void setLoopEndHandle(LoopEndHandle<HandlePlainTabQueryDomain> loopEndHandle) {
		this.loopEndHandle = loopEndHandle;
	}

	/**
	 * 根据条件查询处理文件内容表与文件元组表数据
	 * @throws BaseException
	 */
	public void query() throws BaseException {
		HandlePlainTmpExample example = new HandlePlainTmpExample();
		Criteria criteria = example.createCriteria();
		//根据主键查询文件内容表与文件内容元组表数据
		criteria.andFileIdEqualTo(handleFileTab.getId());
		
		PageHelper.startPage(1, queryBatchMaxNum); 
		List<HandlePlainTmp> handlePlainTmpListOne = handlePlainTmpMapper.selectByExample(example);
		PageInfo<HandlePlainTmp> page = new PageInfo<HandlePlainTmp>(handlePlainTmpListOne);
		if(page != null && page.getTotal() > 0 && page.getList()!= null && page.getList().size() > 0){
			//总页数
			int totalPages = page.getPages();
			for(int pageNum=1; pageNum<=totalPages; pageNum++){
				PageHelper.startPage(pageNum, queryBatchMaxNum); 
				List<HandlePlainTmp> handlePlainTmpList = handlePlainTmpMapper.selectByExample(example);
				if(handlePlainTmpList != null && handlePlainTmpList.size() > 0){
					
					for(HandlePlainTmp loopEntity : handlePlainTmpList){
						//循环中的实体
						this.loopEntity = loopEntity;
						HandleTupleTmpExample example1 = new HandleTupleTmpExample();
						//根据文件内容表主键查询文件元组表数据
						com.company.one.handletuple.model.HandleTupleTmpExample.Criteria criteria1 = example1.createCriteria();
						criteria1.andFileItemIdEqualTo(loopEntity.getId());
						List<HandleTupleTmp> loopEntityTuple = handleTupleTmpMapper.selectByExample(example1);
						if(loopEntityTuple != null && loopEntityTuple.size() > 0){
							//循环中的Tuple实体列表
							this.loopEntityTuple = loopEntityTuple;
						}
						//存在则循环操作
						if(loopHandle != null){
							loopHandle.handle(this);
						}
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
