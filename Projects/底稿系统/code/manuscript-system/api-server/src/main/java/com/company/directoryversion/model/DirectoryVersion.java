/*
*
* DirectoryVersion.java
*                    中证技术公司
* @date 2020-03-10
*/
package com.company.directoryversion.model;

import com.company.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class DirectoryVersion extends BaseModel implements Serializable {
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
     * 目录版本(HASH)
     */
    @ApiModelProperty(value="目录版本(HASH)",name="versionhash")
    private String versionhash;

    /**
     * 是否删除
     */
    @ApiModelProperty(value="是否删除",name="isDelete")
    private String isDelete;

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
     * 版本组成
     */
    @ApiModelProperty(value="版本组成",name="versioncomposition")
    private String versioncomposition;

    /**
     * directoryversion
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

    public String getVersioncomposition() {
        return versioncomposition;
    }

    public void setVersioncomposition(String versioncomposition) {
        this.versioncomposition = versioncomposition == null ? null : versioncomposition.trim();
    }

    /**
     *
     * @mbg.generated 2020-03-10
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
        sb.append(", versionhash=").append(versionhash);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", versioncomposition=").append(versioncomposition);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-03-10
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
        DirectoryVersion other = (DirectoryVersion) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()))
            && (this.getDirectoryid() == null ? other.getDirectoryid() == null : this.getDirectoryid().equals(other.getDirectoryid()))
            && (this.getVersionhash() == null ? other.getVersionhash() == null : this.getVersionhash().equals(other.getVersionhash()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getVersioncomposition() == null ? other.getVersioncomposition() == null : this.getVersioncomposition().equals(other.getVersioncomposition()));
    }

    /**
     *
     * @mbg.generated 2020-03-10
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectid() == null) ? 0 : getProjectid().hashCode());
        result = prime * result + ((getDirectoryid() == null) ? 0 : getDirectoryid().hashCode());
        result = prime * result + ((getVersionhash() == null) ? 0 : getVersionhash().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getVersioncomposition() == null) ? 0 : getVersioncomposition().hashCode());
        return result;
    }
}