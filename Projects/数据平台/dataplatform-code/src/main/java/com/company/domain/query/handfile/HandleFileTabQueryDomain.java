package com.company.domain.query.handfile;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.base.exception.BaseException;
import com.company.domain.query.ExistHandle;
import com.company.domain.query.LoopHandle;
import com.company.domain.query.NotExistHandle;
import com.company.enums.HandleFileTabStatus;
import com.company.one.handlefile.dao.HandleFileTabMapper;
import com.company.one.handlefile.model.HandleFileTab;
import com.company.one.handlefile.model.HandleFileTabExample;
import com.company.one.handlefile.model.HandleFileTabExample.Criteria;

/**
 * 处理文件表相关查询domain
 * @author yangyanchao
 *
 */
public class HandleFileTabQueryDomain {
	/**
	 * 输出日志
	 */
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(HandleFileTabQueryDomain.class);
	/**
	 * TXT文件hash值
	 */
	private String hashFileEntity;
	
	/**
	 * 处理文件表状态枚举
	 */
	private HandleFileTabStatus status;
	
	/**
     * 处理文件--Mapper类
     */
    @Autowired
    private HandleFileTabMapper handleFileTabMapper;
    
    /**
     * 循环中的实体
     */
    private HandleFileTab loopEntity;
    
	/**
	 * 判断存在循环操作接口
	 */
	private LoopHandle<HandleFileTabQueryDomain> loopHandle;
	
	/**
	 * 判断存在操作接口
	 */
	private ExistHandle<HandleFileTabQueryDomain> existHandle;
	
	/**
	 * 判断不存在操作接口
	 */
	private NotExistHandle<HandleFileTabQueryDomain> notExistHandle;
	
	public HandleFileTabQueryDomain() {
		super();
	}

	public HandleFileTabQueryDomain(String hashFileEntity) {
		super();
		this.hashFileEntity = hashFileEntity;
	}

	public HandleFileTabQueryDomain(HandleFileTabStatus status) {
		super();
		this.status = status;
	}

	public String getHashFileEntity() {
		return hashFileEntity;
	}

	public void setHashFileEntity(String hashFileEntity) {
		this.hashFileEntity = hashFileEntity;
	}

	public HandleFileTabStatus getStatus() {
		return status;
	}

	public void setStatus(HandleFileTabStatus status) {
		this.status = status;
	}
	
	public LoopHandle<HandleFileTabQueryDomain> getLoopHandle() {
		return loopHandle;
	}

	public void setLoopHandle(LoopHandle<HandleFileTabQueryDomain> loopHandle) {
		this.loopHandle = loopHandle;
	}

	public ExistHandle<HandleFileTabQueryDomain> getExistHandle() {
		return existHandle;
	}

	public void setExistHandle(ExistHandle<HandleFileTabQueryDomain> existHandle) {
		this.existHandle = existHandle;
	}

	public NotExistHandle<HandleFileTabQueryDomain> getNotExistHandle() {
		return notExistHandle;
	}

	public void setNotExistHandle(NotExistHandle<HandleFileTabQueryDomain> notExistHandle) {
		this.notExistHandle = notExistHandle;
	}

	public HandleFileTab getLoopEntity() {
		return loopEntity;
	}

	/**
	 * 根据字段hash_file_entity查询处理文件表数据
	 * @throws BaseException
	 */
	public void queryByhashFileEntity() throws BaseException {
		HandleFileTabExample example = new HandleFileTabExample();
		Criteria criteria = example.createCriteria();
		criteria.andHashFileEntityEqualTo(hashFileEntity);
		List<HandleFileTab> handleFileTabList = handleFileTabMapper.selectByExample(example);
		if(handleFileTabList != null && handleFileTabList.size() > 0){
			if(existHandle != null){
				existHandle.handle(this);
			}
		} else {
			if(notExistHandle != null){
				notExistHandle.handle(this);
			}
		}
	}
	
	/**
	 * 根据字段status查询处理文件表数据
	 * @throws BaseException
	 */
	public void queryByStatus() throws BaseException {
		HandleFileTabExample example = new HandleFileTabExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(status.getCode());
		List<HandleFileTab> handleFileTabList = handleFileTabMapper.selectByExample(example);
		if(handleFileTabList != null && handleFileTabList.size() > 0){
			for(HandleFileTab loopEntity : handleFileTabList){
				this.loopEntity = loopEntity;
				if(loopHandle != null){
					loopHandle.handle(this);
				}
			}
		} else {
			if(notExistHandle != null){
				notExistHandle.handle(this);
			}
		}
	}
}
