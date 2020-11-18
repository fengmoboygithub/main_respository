package com.company.internalauditreviewresult.serviceImpl;

import com.company.internalauditreviewresult.service.InternalAuditReviewResultServiceTaskService;
import com.company.projectdirectory.service.ProjectDirectoryService;
import org.flowable.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

//@Component(value = "internalAuditReviewResultServiceTaskService")
public class InternalAuditReviewResultServiceTaskServiceImpl implements InternalAuditReviewResultServiceTaskService, Serializable {

    @Autowired
    private ProjectDirectoryService projectDirectoryService;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        //需要更改全部目录流程节点
        String projectid = String.valueOf(delegateExecution.getVariable("projectid"));
        String projectstage = String.valueOf(delegateExecution.getVariable("projectstage"));
        String nextProcessnode = "47";
        //更新全部节点
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("projectid",projectid);
        map.put("projectstage",projectstage);
        map.put("nextProcessnode",nextProcessnode);
        projectDirectoryService.updateCountersignProcessnodeTo47(map);
    }
}
