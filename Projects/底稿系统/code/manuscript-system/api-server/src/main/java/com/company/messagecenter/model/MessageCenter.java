/*
*
* MessageCenter.java
*                    中证技术公司
* @date 2020-07-27
*/
package com.company.messagecenter.model;

import com.company.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
@ApiModel(value="消息中心对象",description="消息中心表(MESSAGECENTER)")
public class MessageCenter extends BaseModel implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="消息ID",name="id")
    private String id;

    /**
     * 消息内容
     */
    @ApiModelProperty(value="消息内容",name="mgcontent")
    private String mgcontent;

    /**
     * 消息类型(1--系统；2--普通)
     */
    @ApiModelProperty(value="消息类型",name="mgtype")
    private String mgtype;

    /**
     * 消息状态(1--草稿；2--发布)
     */
    @ApiModelProperty(value="消息状态",name="mgstate")
    private String mgstate;

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
     * messagecenter
     */
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMgcontent() {
        return mgcontent;
    }

    public void setMgcontent(String mgcontent) {
        this.mgcontent = mgcontent == null ? null : mgcontent.trim();
    }

    public String getMgtype() {
        return mgtype;
    }

    public void setMgtype(String mgtype) {
        this.mgtype = mgtype == null ? null : mgtype.trim();
    }

    public String getMgstate() {
        return mgstate;
    }

    public void setMgstate(String mgstate) {
        this.mgstate = mgstate == null ? null : mgstate.trim();
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
     * @mbg.generated 2020-07-27
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mgcontent=").append(mgcontent);
        sb.append(", mgtype=").append(mgtype);
        sb.append(", mgstate=").append(mgstate);
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
     * @mbg.generated 2020-07-27
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
        MessageCenter other = (MessageCenter) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMgcontent() == null ? other.getMgcontent() == null : this.getMgcontent().equals(other.getMgcontent()))
            && (this.getMgtype() == null ? other.getMgtype() == null : this.getMgtype().equals(other.getMgtype()))
            && (this.getMgstate() == null ? other.getMgstate() == null : this.getMgstate().equals(other.getMgstate()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()));
    }

    /**
     *
     * @mbg.generated 2020-07-27
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMgcontent() == null) ? 0 : getMgcontent().hashCode());
        result = prime * result + ((getMgtype() == null) ? 0 : getMgtype().hashCode());
        result = prime * result + ((getMgstate() == null) ? 0 : getMgstate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }
}