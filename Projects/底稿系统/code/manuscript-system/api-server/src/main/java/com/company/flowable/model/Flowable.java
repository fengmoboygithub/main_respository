package com.company.flowable.model;

import com.company.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class Flowable extends BaseModel implements Serializable {

    @ApiModelProperty(value="任务ID",name="taskId")
    private String taskId;

    @ApiModelProperty(value="任务名称",name="taskName")
    private String taskName;

    @ApiModelProperty(value="任务的办理人",name="taskManager")
    private String taskManager;

    @ApiModelProperty(value="流程实例ID",name="taskManager")
    private String processInstanceId;

    @ApiModelProperty(value="执行对象ID",name="taskManager")
    private String execObjectId;

    @ApiModelProperty(value="流程定义ID",name="taskManager")
    private String processDefinitionId;

    @ApiModelProperty(value="创建时间",name="createTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskManager() {
        return taskManager;
    }

    public void setTaskManager(String taskManager) {
        this.taskManager = taskManager;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getExecObjectId() {
        return execObjectId;
    }

    public void setExecObjectId(String execObjectId) {
        this.execObjectId = execObjectId;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Flowable{" +
                "taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskManager='" + taskManager + '\'' +
                ", processInstanceId='" + processInstanceId + '\'' +
                ", execObjectId='" + execObjectId + '\'' +
                ", processDefinitionId='" + processDefinitionId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
