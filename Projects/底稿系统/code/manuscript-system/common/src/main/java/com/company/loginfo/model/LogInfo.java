/*
*
* LogInfo.java
*                    中证技术公司
* @date 2020-04-03
*/
package com.company.loginfo.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class LogInfo extends BaseModel implements Serializable {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 项目ID
     */
    private String projectid;

    /**
     * 请求类型
     */
    private String requesttype;

    /**
     * 请求controller全路径
     */
    private String requestcontrollerpath;

    /**
     * 请求地址
     */
    private String requesturl;

    /**
     * 请求参数
     */
    private String requestparams;

    /**
     * 操作人
     */
    private String userid;

    /**
     * 是否删除
     */
    private String isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新用户
     */
    private String updateUser;

    /**
     * loginfo
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

    public String getRequesttype() {
        return requesttype;
    }

    public void setRequesttype(String requesttype) {
        this.requesttype = requesttype == null ? null : requesttype.trim();
    }

    public String getRequestcontrollerpath() {
        return requestcontrollerpath;
    }

    public void setRequestcontrollerpath(String requestcontrollerpath) {
        this.requestcontrollerpath = requestcontrollerpath == null ? null : requestcontrollerpath.trim();
    }

    public String getRequesturl() {
        return requesturl;
    }

    public void setRequesturl(String requesturl) {
        this.requesturl = requesturl == null ? null : requesturl.trim();
    }

    public String getRequestparams() {
        return requestparams;
    }

    public void setRequestparams(String requestparams) {
        this.requestparams = requestparams == null ? null : requestparams.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
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

    /**
     *
     * @mbg.generated 2020-04-03
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectid=").append(projectid);
        sb.append(", requesttype=").append(requesttype);
        sb.append(", requestcontrollerpath=").append(requestcontrollerpath);
        sb.append(", requesturl=").append(requesturl);
        sb.append(", requestparams=").append(requestparams);
        sb.append(", userid=").append(userid);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-04-03
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
        LogInfo other = (LogInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()))
            && (this.getRequesttype() == null ? other.getRequesttype() == null : this.getRequesttype().equals(other.getRequesttype()))
            && (this.getRequestcontrollerpath() == null ? other.getRequestcontrollerpath() == null : this.getRequestcontrollerpath().equals(other.getRequestcontrollerpath()))
            && (this.getRequesturl() == null ? other.getRequesturl() == null : this.getRequesturl().equals(other.getRequesturl()))
            && (this.getRequestparams() == null ? other.getRequestparams() == null : this.getRequestparams().equals(other.getRequestparams()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()));
    }

    /**
     *
     * @mbg.generated 2020-04-03
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectid() == null) ? 0 : getProjectid().hashCode());
        result = prime * result + ((getRequesttype() == null) ? 0 : getRequesttype().hashCode());
        result = prime * result + ((getRequestcontrollerpath() == null) ? 0 : getRequestcontrollerpath().hashCode());
        result = prime * result + ((getRequesturl() == null) ? 0 : getRequesturl().hashCode());
        result = prime * result + ((getRequestparams() == null) ? 0 : getRequestparams().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }
}