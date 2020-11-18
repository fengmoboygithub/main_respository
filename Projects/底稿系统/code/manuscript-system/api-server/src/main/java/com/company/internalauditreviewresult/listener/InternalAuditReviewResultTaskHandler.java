package com.company.internalauditreviewresult.listener;

import com.company.projectdirectory.dao.ProjectDirectoryMapper;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component(value="internalAuditListener")
public class InternalAuditReviewResultTaskHandler implements TaskListener {
    public static Logger logger = LoggerFactory.getLogger(InternalAuditReviewResultTaskHandler.class);

    @Autowired
    private ProjectDirectoryMapper projectDirectoryMapper;

    @Override
    public void notify(DelegateTask delegateTask) {
        //需要更改全部目录流程节点
        String projectid = String.valueOf(delegateTask.getVariable("projectid"));
        String projectstage = String.valueOf(delegateTask.getVariable("projectstage"));
        String nextProcessnode = "47";
        //更新全部节点
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("projectid",projectid);
        map.put("projectstage",projectstage);
        map.put("nextProcessnode",nextProcessnode);
        projectDirectoryMapper.updateCountersignProcessnodeTo47(map);
    }
}
