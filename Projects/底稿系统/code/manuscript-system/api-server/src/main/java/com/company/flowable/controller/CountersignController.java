package com.company.flowable.controller;

import com.company.base.exception.BaseException;
import com.company.bean.ResponseDataListModel;
import com.company.config.ProcessEngineConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.*;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.image.ProcessDiagramGenerator;
import org.flowable.task.api.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 	会签功能
 * Controller类
 *
 */
@Api(value="会签功能",tags={"会签功能接口"})
@RestController("CountersignController")
@RequestMapping("/api/countersign")
public class CountersignController {
    public static Logger logger = LoggerFactory.getLogger(CountersignController.class);

    @Autowired
    private ProcessEngineConfig processEngine;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;


    /**
     *  添加会签实例
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public String addCountersign() {
        //启动流程
        HashMap<String, Object> map = new HashMap<>();
        String[] persons = { "person1", "person2", "person3"};
        //定义会签人员
        map.put("assigneeList", Arrays.asList(persons));
        //完成会签的人员，完成一个就+1
        map.put("signCount", 0);
        map.put("task1","办理人");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Countersign", map);
        System.out.println("流程实例id==" + processInstance.getId());
        System.out.println("流程实例Name==" + processInstance.getName());
        System.out.println("流程实例开始时间==" + processInstance.getStartTime());
        return "提交成功.流程Id为：" + processInstance.getId();
    }

    /**
     * 查询当前个人任务
     */
    @RequestMapping(value = "getMyPersonalTaskListByProcessId")
    public ResponseDataListModel<Task> getMyPersonalTaskListByProcessId(
            @RequestParam(required = false) @ApiParam(name="processId",value="流程id",required=true) String processId
    ) throws BaseException {
        logger.info("processId:{}", processId);
        ResponseDataListModel<Task> responseModel = new ResponseDataListModel<Task>();
        try {
            List<Task> list = taskService// 与正在执行的任务管理相关的Service
                    .createTaskQuery()// 创建任务查询对象
                    /** 查询条件（where部分） */
//                .taskAssignee(assignee)// 指定个人任务查询，指定办理人
//						.taskCandidateUser(candidateUser)//组任务的办理人查询
//						.processDefinitionId(processDefinitionId)//使用流程定义ID查询
                    .processInstanceId(processId)//使用流程实例ID查询
//						.executionId(executionId)//使用执行对象ID查询
                    /** 排序 */
                    .orderByTaskCreateTime().asc()// 使用创建时间的升序排列
                    /** 返回结果集 */
//						.singleResult()//返回惟一结果集
//						.count()//返回结果集的数量
//						.listPage(firstResult, maxResults);//分页查询
                    .list();// 返回列表
            responseModel.setSuccess(true);
            responseModel.setList(list);
            responseModel.setMessage("列表查询成功");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            responseModel.setSuccess(false);
            responseModel.setMessage("失败:" + e.getMessage());
            logger.error("Fail:", e);
            return responseModel;
        }
        return responseModel;
    }

    // 个人完成任务
    @RequestMapping(value = "completeMyPersonalTask1")
    @ResponseBody
    public String completeMyPersonalTask1(String taskId) {
        // 任务ID
        taskService.complete(taskId);// 与正在执行的任务管理相关的Service
        System.out.println("完成任务：任务ID：" + taskId);
        return "processed ok!";
    }

    /**
     *  查询当前人的个人任务
     * @return
     */
    @RequestMapping(value = "getMyPersonalTaskListByUserId")
    public ResponseDataListModel<Task> getMyPersonalTaskListByUserId(
            @RequestParam(required = false) @ApiParam(name="userId",value="用户id",required=true) String userId
    ) throws BaseException{
        logger.info("userId:{}", userId);
        ResponseDataListModel<Task> responseModel = new ResponseDataListModel<Task>();
        try {
            List<Task> list = taskService// 与正在执行的任务管理相关的Service
                    .createTaskQuery()// 创建任务查询对象
                    /** 查询条件（where部分） */
                    .taskAssignee(userId)// 指定个人任务查询，指定办理人
                    //						.taskCandidateUser(candidateUser)//组任务的办理人查询
                    //						.processDefinitionId(processDefinitionId)//使用流程定义ID查询
                    //						.processInstanceId(processInstanceId)//使用流程实例ID查询
                    //						.executionId(executionId)//使用执行对象ID查询
                    /** 排序 */
                    .orderByTaskCreateTime().asc()// 使用创建时间的升序排列
                    /** 返回结果集 */
                    //						.singleResult()//返回惟一结果集
                    //						.count()//返回结果集的数量
                    //						.listPage(firstResult, maxResults);//分页查询
                    .list();// 返回列表
            responseModel.setSuccess(true);
            responseModel.setList(list);
            responseModel.setMessage("列表查询成功");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            responseModel.setSuccess(false);
            responseModel.setMessage("失败:" + e.getMessage());
            logger.error("Fail:", e);
            return responseModel;
        }
        return responseModel;
    }

//    /**
//     * 如果同意
//     * @param taskId
//     */
//    @RequestMapping(value = "completeMyPersonalTask3")
//    public void completeMyPersonalTask3(String taskId) {
//        // 任务ID
////        String taskId = "任务id";
//        List<Task> taskResultList = taskService.createTaskQuery().taskId(taskId).list();
//        //当前executionId
//        System.out.println(taskResultList);
//        //当前executionId
//        String currentExecutionId = taskResultList.get(0).getExecutionId();
//        //当前签署总数
//        String currentSignCount = StringUtils
//                .defaultString(runtimeService.getVariable(currentExecutionId, "signCount").toString(), "0");
//        //签署数+1
//        runtimeService.setVariable(currentExecutionId, "signCount", Integer.parseInt(currentSignCount) + 1);
//        //完成
//        taskService.complete(taskId);
//    }

//    @RequestMapping(value = "completeMyPersonalTask")
//    public void completeMyPersonalTask(String taskId) {
//        // 任务ID
////        String taskId = "任务id";
//        taskService.complete(taskId);// 与正在执行的任务管理相关的Service
//        System.out.println("完成任务：任务ID：" + taskId);
//    }



//    /**
//     * 获取审批管理列表
//     */
//    @RequestMapping(value = "/list")
//    @ResponseBody
//    public Object list(String processId) {
////        List<Task> tasks = taskService.createTaskQuery().taskAssignee(userId).orderByTaskCreateTime().desc().list();
//        List<Task> list = taskService.createTaskQuery().processInstanceId(processId).list();
//        for (Task task : list) {
//            System.out.println(task.toString());
//        }
//        return list.toArray().toString();
//    }
//
//    /**
//     * 通过
//     *
//     * @param taskId 任务ID
//     */
//    @RequestMapping(value = "apply")
//    @ResponseBody
//    public String apply(String taskId) {
//        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
//        if (task == null) {
//            throw new RuntimeException("流程不存在");
//        }
//        //通过审核
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("outcome", "通过");
//        taskService.complete(taskId, map);
//        return "processed ok!";
//    }

    /**
     * 生成流程图
     *
     * @param processId 任务ID
     */
    @RequestMapping(value = "processDiagram")
    public void genProcessDiagram(HttpServletResponse httpServletResponse, String processId) throws Exception {
        ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processId).singleResult();

        //流程走完的不显示图
        if (pi == null) {
            return;
        }
        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        //使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
        String InstanceId = task.getProcessInstanceId();
        List<Execution> executions = runtimeService
                .createExecutionQuery()
                .processInstanceId(InstanceId)
                .list();

        //得到正在执行的Activity的Id
        List<String> activityIds = new ArrayList<>();
        List<String> flows = new ArrayList<>();
        for (Execution exe : executions) {
            List<String> ids = runtimeService.getActiveActivityIds(exe.getId());
            activityIds.addAll(ids);
        }

        //获取流程图
        BpmnModel bpmnModel = repositoryService.getBpmnModel(pi.getProcessDefinitionId());
        ProcessEngineConfiguration engconf = ProcessEngines.getDefaultProcessEngine().getProcessEngineConfiguration();
        ProcessDiagramGenerator diagramGenerator = engconf.getProcessDiagramGenerator();
        InputStream in = diagramGenerator.generateDiagram(bpmnModel, "png", activityIds, flows, engconf.getActivityFontName(), engconf.getLabelFontName(), engconf.getAnnotationFontName(), engconf.getClassLoader(), 1.0,false);
//        InputStream in = diagramGenerator.generateDiagram(bpmnModel, "png",activityIds, flows, "宋体","宋体","宋体",null,1.0,false);
        OutputStream out = null;
        byte[] buf = new byte[1024];
        int legth = 0;
        try {
            out = httpServletResponse.getOutputStream();
            while ((legth = in.read(buf)) != -1) {
                out.write(buf, 0, legth);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
