/*
*
* InternalAuditReviewResult.java
*                    中证技术公司
* @date 2020-05-12
*/
package com.company.internalauditreviewresult.model;

import com.company.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class InternalAuditReviewResult extends BaseModel implements Serializable {
    /**
     * 主键ID
     */
    @ApiModelProperty(value="主键",name="id")
    private String id;

    /**
     * 项目ID
     */
    @ApiModelProperty(value="项目ID",name="projectid")
    private String projectid;

    /**
     * 项目阶段
     */
    @ApiModelProperty(value="项目阶段",name="projectstage")
    private String projectstage;

    /**
     * 是否同意
     */
    @ApiModelProperty(value="是否同意",name="isagree")
    private String isagree;

    /**
     * 是否删除
     */
    @ApiModelProperty(value="是否删除",name="isDelete")
    private String isDelete;

    /**
     * 创建用户
     */
    @ApiModelProperty(value="创建用户",name="createUser")
    private String createUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间",name="createTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 更新用户
     */
    @ApiModelProperty(value="更新用户",name="updateUser")
    private String updateUser;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间",name="updateTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    /**
     * 意见内容
     */
    @ApiModelProperty(value="意见内容",name="contents")
    private String contents;

    /**
     * internalauditreviewresult
     */
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid == null ? null : projectid.trim();
    }

    public String getProjectstage() {
        return projectstage;
    }

    public void setProjectstage(String projectstage) {
        this.projectstage = projectstage == null ? null : projectstage.trim();
    }

    public String getIsagree() {
        return isagree;
    }

    public void setIsagree(String isagree) {
        this.isagree = isagree == null ? null : isagree.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }

    /**
     *
     * @mbg.generated 2020-05-12
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectid=").append(projectid);
        sb.append(", projectstage=").append(projectstage);
        sb.append(", isagree=").append(isagree);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", contents=").append(contents);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-05-12
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
        InternalAuditReviewResult other = (InternalAuditReviewResult) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()))
            && (this.getProjectstage() == null ? other.getProjectstage() == null : this.getProjectstage().equals(other.getProjectstage()))
            && (this.getIsagree() == null ? other.getIsagree() == null : this.getIsagree().equals(other.getIsagree()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getContents() == null ? other.getContents() == null : this.getContents().equals(other.getContents()));
    }

    /**
     *
     * @mbg.generated 2020-05-12
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectid() == null) ? 0 : getProjectid().hashCode());
        result = prime * result + ((getProjectstage() == null) ? 0 : getProjectstage().hashCode());
        result = prime * result + ((getIsagree() == null) ? 0 : getIsagree().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getContents() == null) ? 0 : getContents().hashCode());
        return result;
    }
}