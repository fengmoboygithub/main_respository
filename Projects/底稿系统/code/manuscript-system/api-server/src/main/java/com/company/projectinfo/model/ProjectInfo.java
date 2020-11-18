/*
*
* ProjectInfo.java
*                    中证技术公司
* @date 2020-03-09
*/
package com.company.projectinfo.model;

import com.company.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
@ApiModel(value="项目信息对象",description="项目信息表(PROJECTINFO)")
public class ProjectInfo extends BaseModel implements Serializable {
    /**
     * 主键ID
     */
    @ApiModelProperty(value="项目ID",name="id")
    private String id;

    /**
     * 项目名称
     */
    @ApiModelProperty(value="项目名称",name="projectname")
    private String projectname;

    /**
     * 项目编号
     */
    @ApiModelProperty(value="项目编号",name="projectno")
    private String projectno;

    /**
     * 承揽、改制辅导、持续督导等
     */
    @ApiModelProperty(value="项目阶段",name="stage")
    private String stage;

    /**
     * 项目阶段名称
     */
    @ApiModelProperty(value="项目阶段名称",name="stagename")
    private String stagename;

    /**
     * 并购重组、IPO等
     */
    @ApiModelProperty(value="项目类型",name="projecttype")
    private String projecttype;

    /**
     * 并购重组、IPO等
     */
    @ApiModelProperty(value="项目类型名称",name="projecttypename")
    private String projecttypename;

    /**
     * 项目开始时间
     */
    @ApiModelProperty(value="开始时间",name="begindate")
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date begindate;

    /**
     * 项目结束时间
     */
    @ApiModelProperty(value="结束时间",name="enddate")
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date enddate;

    /**
     * 项目经理
     */
    @ApiModelProperty(value="项目经理",name="projectmanager")
    private String projectmanager;

    /**
     * 项目成员
     */
    @ApiModelProperty(value="项目成员",name="personnel")
    private String personnel;

    /**
     * 项目状态--普通(11)、暂停(12)、异常终止(13)、终止(14)
     */
    @ApiModelProperty(value="项目状态",name="status")
    private String status;

    /**
     * 流程实例ID(内核使用)
     */
    @ApiModelProperty(value="流程实例ID(内核使用)",name="processInstanceId")
    private String processInstanceId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间",name="createTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 创建用户
     */
    @ApiModelProperty(value="创建用户",name="createUser")
    private String createUser;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间",name="updateTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    /**
     * 更新用户
     */
    @ApiModelProperty(value="更新用户",name="updateUser")
    private String updateUser;

    /**
     * 是否删除
     */
    @ApiModelProperty(value="是否删除",name="isDelete")
    private String isDelete;

    /**
     * 数据项ID
     */
    private String dataItemId;

    /**
     * 用户列表字符串 已‘逗号分隔’
     */
    private String userId;

    /**
     * 角色列表字符串 已‘逗号分隔’
     */
    private String roleList;

    /**
     * projectinfo
     */
    private static final long serialVersionUID = 1L;

    public String getDataItemId() {
        return dataItemId;
    }

    public void setDataItemId(String dataItemId) {
        this.dataItemId = dataItemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleList() {
        return roleList;
    }

    public void setRoleList(String roleList) {
        this.roleList = roleList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public String getProjectno() {
        return projectno;
    }

    public void setProjectno(String projectno) {
        this.projectno = projectno == null ? null : projectno.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage == null ? null : stage.trim();
    }

    public String getStagename() {
        return stagename;
    }

    public void setStagename(String stagename) {
        this.stagename = stagename == null ? null : stagename.trim();
    }

    public String getProjecttype() {
        return projecttype;
    }

    public void setProjecttype(String projecttype) {
        this.projecttype = projecttype == null ? null : projecttype.trim();
    }

    public String getProjecttypename() {
        return projecttypename;
    }

    public void setProjecttypename(String projecttypename) {
        this.projecttypename = projecttypename == null ? null : projecttypename.trim();
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getProjectmanager() {
        return projectmanager;
    }

    public void setProjectmanager(String projectmanager) {
        this.projectmanager = projectmanager == null ? null : projectmanager.trim();
    }

    public String getPersonnel() {
        return personnel;
    }

    public void setPersonnel(String personnel) {
        this.personnel = personnel == null ? null : personnel.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /**
     *
     * @mbg.generated 2020-03-09
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectname=").append(projectname);
        sb.append(", projectno=").append(projectno);
        sb.append(", stage=").append(stage);
        sb.append(", projecttype=").append(projecttype);
        sb.append(", begindate=").append(begindate);
        sb.append(", enddate=").append(enddate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-03-09
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ProjectInfo other = (ProjectInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectname() == null ? other.getProjectname() == null : this.getProjectname().equals(other.getProjectname()))
            && (this.getProjectno() == null ? other.getProjectno() == null : this.getProjectno().equals(other.getProjectno()))
            && (this.getStage() == null ? other.getStage() == null : this.getStage().equals(other.getStage()))
            && (this.getProjecttype() == null ? other.getProjecttype() == null : this.getProjecttype().equals(other.getProjecttype()))
            && (this.getBegindate() == null ? other.getBegindate() == null : this.getBegindate().equals(other.getBegindate()))
            && (this.getEnddate() == null ? other.getEnddate() == null : this.getEnddate().equals(other.getEnddate()));
    }

    /**
     *
     * @mbg.generated 2020-03-09
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectname() == null) ? 0 : getProjectname().hashCode());
        result = prime * result + ((getProjectno() == null) ? 0 : getProjectno().hashCode());
        result = prime * result + ((getStage() == null) ? 0 : getStage().hashCode());
        result = prime * result + ((getProjecttype() == null) ? 0 : getProjecttype().hashCode());
        result = prime * result + ((getBegindate() == null) ? 0 : getBegindate().hashCode());
        result = prime * result + ((getEnddate() == null) ? 0 : getEnddate().hashCode());
        return result;
    }
}