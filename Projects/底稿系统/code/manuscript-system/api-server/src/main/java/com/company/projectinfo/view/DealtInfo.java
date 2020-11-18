/*
*
* ProjectInfo.java
*                    中证技术公司
* @date 2020-03-09
*/
package com.company.projectinfo.view;

import com.company.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value="待办信息对象",description="待办信息")
public class DealtInfo extends BaseModel implements Serializable {
    /**
     * 项目ID
     */
    @ApiModelProperty(value="项目ID",name="projectid")
    private String projectid;

    /**
     * 项目阶段
     */
    @ApiModelProperty(value="项目阶段",name="stage")
    private String stage;

    /**
     * 项目名称
     */
    @ApiModelProperty(value="项目名称",name="projectname")
    private String projectname;

    /**
     * 目录简称
     */
    @ApiModelProperty(value="项目编号",name="sname")
    private String sname;

    /**
     * 流程状态ID
     */
    @ApiModelProperty(value="流程状态ID",name="processnode")
    private String processnode;

    /**
     * 流程状态名称
     */
    @ApiModelProperty(value="流程状态名称",name="processnodename")
    private String processnodename;

    /**
     * projectinfo
     */
    private static final long serialVersionUID = 1L;

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getProcessnode() {
        return processnode;
    }

    public void setProcessnode(String processnode) {
        this.processnode = processnode;
    }

    public String getProcessnodename() {
        return processnodename;
    }

    public void setProcessnodename(String processnodename) {
        this.processnodename = processnodename;
    }

}