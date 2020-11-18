package com.company.internalauditreviewresult.listener;

import com.company.projectdirectory.service.ProjectDirectoryService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InternalAuditReviewResultDelegate implements JavaDelegate, ApplicationContextAware {
    public static Logger logger = LoggerFactory.getLogger(InternalAuditReviewResultDelegate.class);

//    @Autowired
//    private ProjectDirectoryService projectDirectoryService;

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (InternalAuditReviewResultDelegate.applicationContext == null) {
            InternalAuditReviewResultDelegate.applicationContext = applicationContext;
        }
    }

    @Override
    public void execute(DelegateExecution delegateExecution) {
        ProjectDirectoryService projectDirectoryService = applicationContext.getBean(ProjectDirectoryService.class);
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
