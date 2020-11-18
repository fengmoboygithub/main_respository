/*
*
* ProcessNodeInfo.java
*                    中证技术公司
* @date 2020-02-03
*/
package com.company.processnodeinfo.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class ProcessNodeInfo extends BaseModel implements Serializable {
    /**
     * 流程节点
     */
    private String processnode;

    /**
     * 流程节点名称
     */
    private String processnodename;

    /**
     * 操作类型
     */
    private String opertype;

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
     * 是否删除
     */
    private String isDelete;

    /**
     * processnodeinfo
     */
    private static final long serialVersionUID = 1L;

    public String getProcessnode() {
        return processnode;
    }

    public void setProcessnode(String processnode) {
        this.processnode = processnode == null ? null : processnode.trim();
    }

    public String getProcessnodename() {
        return processnodename;
    }

    public void setProcessnodename(String processnodename) {
        this.processnodename = processnodename == null ? null : processnodename.trim();
    }

    public String getOpertype() {
        return opertype;
    }

    public void setOpertype(String opertype) {
        this.opertype = opertype == null ? null : opertype.trim();
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

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     *
     * @mbg.generated 2020-02-03
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", processnode=").append(processnode);
        sb.append(", processnodename=").append(processnodename);
        sb.append(", opertype=").append(opertype);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-02-03
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
        ProcessNodeInfo other = (ProcessNodeInfo) that;
        return (this.getProcessnode() == null ? other.getProcessnode() == null : this.getProcessnode().equals(other.getProcessnode()))
            && (this.getProcessnodename() == null ? other.getProcessnodename() == null : this.getProcessnodename().equals(other.getProcessnodename()))
            && (this.getOpertype() == null ? other.getOpertype() == null : this.getOpertype().equals(other.getOpertype()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    /**
     *
     * @mbg.generated 2020-02-03
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProcessnode() == null) ? 0 : getProcessnode().hashCode());
        result = prime * result + ((getProcessnodename() == null) ? 0 : getProcessnodename().hashCode());
        result = prime * result + ((getOpertype() == null) ? 0 : getOpertype().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }
}