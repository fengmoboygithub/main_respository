/*
*
* DirectoryOpinion.java
*                    中证技术公司
* @date 2020-03-23
*/
package com.company.directoryopinion.model;

import com.company.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class DirectoryOpinion extends BaseModel implements Serializable {
    /**
     * 主键ID
     */
    @ApiModelProperty(value="主键ID",name="id")
    private String id;

    /**
     * 项目ID
     */
    @ApiModelProperty(value="项目ID",name="projectid")
    private String projectid;

    /**
     * 目录ID
     */
    @ApiModelProperty(value="目录ID",name="directoryid")
    private String directoryid;

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
     * 版本(HASH)
     */
    @ApiModelProperty(value="版本(HASH)",name="versionhash")
    private String versionhash;

    /**
     * 是否删除
     */
    @ApiModelProperty(value="是否删除",name="isDelete")
    private String isDelete;

    /**
     * 起点流程节点
     */
    @ApiModelProperty(value="起点流程节点",name="startprocessnode")
    private String startprocessnode;

    /**
     * 终点流程节点
     */
    @ApiModelProperty(value="终点流程节点",name="endprocessnode")
    private String endprocessnode;

    /**
     * 意见内容
     */
    @ApiModelProperty(value="意见内容",name="contents")
    private String contents;

    /**
     * 意见类型：0.草稿，1.正式
     */
    @ApiModelProperty(value="意见类型：0.草稿，1.正式",name="type")
    private String opinionType;


    /**
     * directoryopinion
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

    public String getDirectoryid() {
        return directoryid;
    }

    public void setDirectoryid(String directoryid) {
        this.directoryid = directoryid == null ? null : directoryid.trim();
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
        this.createUser = createUser == null ? null : createUser.trim();
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
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getVersionhash() {
        return versionhash;
    }

    public void setVersionhash(String versionhash) {
        this.versionhash = versionhash == null ? null : versionhash.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public String getStartprocessnode() {
        return startprocessnode;
    }

    public void setStartprocessnode(String startprocessnode) {
        this.startprocessnode = startprocessnode == null ? null : startprocessnode.trim();
    }

    public String getEndprocessnode() {
        return endprocessnode;
    }

    public void setEndprocessnode(String endprocessnode) {
        this.endprocessnode = endprocessnode == null ? null : endprocessnode.trim();
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }

    public String getOpinionType() {
        return opinionType;
    }

    public void setOpinionType(String opinionType) {
        this.opinionType = opinionType;
    }

    /**
     *
     * @mbg.generated 2020-03-23
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectid=").append(projectid);
        sb.append(", directoryid=").append(directoryid);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", versionhash=").append(versionhash);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", startprocessnode=").append(startprocessnode);
        sb.append(", endprocessnode=").append(endprocessnode);
        sb.append(", contents=").append(contents);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-03-23
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
        DirectoryOpinion other = (DirectoryOpinion) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()))
            && (this.getDirectoryid() == null ? other.getDirectoryid() == null : this.getDirectoryid().equals(other.getDirectoryid()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getVersionhash() == null ? other.getVersionhash() == null : this.getVersionhash().equals(other.getVersionhash()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getStartprocessnode() == null ? other.getStartprocessnode() == null : this.getStartprocessnode().equals(other.getStartprocessnode()))
            && (this.getEndprocessnode() == null ? other.getEndprocessnode() == null : this.getEndprocessnode().equals(other.getEndprocessnode()))
            && (this.getContents() == null ? other.getContents() == null : this.getContents().equals(other.getContents()));
    }

    /**
     *
     * @mbg.generated 2020-03-23
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectid() == null) ? 0 : getProjectid().hashCode());
        result = prime * result + ((getDirectoryid() == null) ? 0 : getDirectoryid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getVersionhash() == null) ? 0 : getVersionhash().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getStartprocessnode() == null) ? 0 : getStartprocessnode().hashCode());
        result = prime * result + ((getEndprocessnode() == null) ? 0 : getEndprocessnode().hashCode());
        result = prime * result + ((getContents() == null) ? 0 : getContents().hashCode());
        return result;
    }
}