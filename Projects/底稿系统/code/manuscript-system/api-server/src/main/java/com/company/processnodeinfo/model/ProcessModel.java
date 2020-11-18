package com.company.processnodeinfo.model;

import com.company.base.model.BaseModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ProcessModel extends BaseModel implements Serializable {

    /**
     * 项目id
     */
    @ApiModelProperty(value="项目id",name="projectid")
    private String projectid;

    /**
     *  项目阶段
     */
    @ApiModelProperty(value="项目阶段",name="projectStage")
    private String projectStage;

    /**
     *  流程节点
     */
    @ApiModelProperty(value="流程节点",name="processnode")
    private String processnode;

    /**
     *  操作ID
     */
    @ApiModelProperty(value="操作ID",name="operId")
    private String operId;

    /**
     *  目录树DAG
     */
    @ApiModelProperty(value="目录树DAG",name="treedag")
    private String treedag;

    /**
     *  会签人员id
     */
    @ApiModelProperty(value="会签人员id",name="countersignUserIds")
    private String countersignUserIds;

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getProjectStage() {
        return projectStage;
    }

    public void setProjectStage(String projectStage) {
        this.projectStage = projectStage;
    }

    public String getProcessnode() {
        return processnode;
    }

    public void setProcessnode(String processnode) {
        this.processnode = processnode;
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public String getTreedag() {
        return treedag;
    }

    public void setTreedag(String treedag) {
        this.treedag = treedag;
    }

    public String getCountersignUserIds() {
        return countersignUserIds;
    }

    public void setCountersignUserIds(String countersignUserIds) {
        this.countersignUserIds = countersignUserIds;
    }
}
