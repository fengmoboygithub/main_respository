package com.company.internalauditreviewresult.serviceImpl;

import com.company.base.dao.IBaseDao;
import com.company.base.exception.BaseException;
import com.company.base.service.BaseServiceImpl;
import com.company.config.ProcessEngineConfig;
import com.company.internalauditreviewresult.dao.InternalAuditReviewResultMapper;
import com.company.internalauditreviewresult.model.InternalAuditReviewResult;
import com.company.internalauditreviewresult.model.InternalAuditReviewResultExample;
import com.company.internalauditreviewresult.service.InternalAuditReviewResultService;
import org.apache.commons.lang.StringUtils;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InternalAuditReviewResultServiceImpl extends BaseServiceImpl<InternalAuditReviewResult, InternalAuditReviewResultExample> implements InternalAuditReviewResultService<InternalAuditReviewResult, InternalAuditReviewResultExample>{

    @Autowired
    private InternalAuditReviewResultMapper mapper;
	
	public IBaseDao<InternalAuditReviewResult, InternalAuditReviewResultExample> getMapper(){
		return mapper;
	}

	@Autowired
	private ProcessEngineConfig processEngine;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RepositoryService repositoryService;

	/**
	 * 添加会签意见
	 * @param record
	 * @param taskId
	 * @throws BaseException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor= BaseException.class)
	public void saveInternalAuditReviewResult(InternalAuditReviewResult record, String taskId) throws BaseException {
		//保存内核审议结果信息
		int success = getMapper().insertSelective(record);
		if (success <= 0) {
			logger.error("新增内核审议结果信息错误{}",  record.toString());
			throw new BaseException("新增内核审议结果信息错误");
		}
		//调用流程实例的通过审批接口
		List<Task> taskResultList = taskService.createTaskQuery().taskId(taskId).list();
		//当前执行id
		String currentExecutionId = taskResultList.get(0).getExecutionId();
		//当前签署总数
		String currentSignCount = StringUtils
				.defaultString(runtimeService.getVariable(currentExecutionId, "signCount").toString(), "0");
		//签署数+1
		runtimeService.setVariable(currentExecutionId, "signCount", Integer.parseInt(currentSignCount) + 1);
		//完成
		taskService.complete(taskId);
	}
}