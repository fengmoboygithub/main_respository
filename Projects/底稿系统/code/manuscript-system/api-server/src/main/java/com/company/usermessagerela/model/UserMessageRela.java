/*
*
* UserMessageRela.java
*                    中证技术公司
* @date 2020-07-27
*/
package com.company.usermessagerela.model;

import com.company.base.model.BaseModel;
import com.company.enums.MessageCenterType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
@ApiModel(value="用户与消息关系对象",description="用户与消息关系表(USERMESSAGERELA)")
public class UserMessageRela extends BaseModel implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="关系ID",name="id")
    private String id;

    /**
     * 消息可见人ID
     */
    @ApiModelProperty(value="消息可见人ID",name="userid")
    private String userid;

    /**
     * 消息可见人
     */
    @ApiModelProperty(value="消息可见人",name="username")
    private String username;

    /**
     * 消息ID
     */
    @ApiModelProperty(value="消息ID",name="mgid")
    private String mgid;

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
     * 消息内容
     */
    @ApiModelProperty(value="消息内容",name="mgcontent")
    private String mgcontent;

    /**
     * 用户对消息操作状态(1--未读；2--已读；3--待还原)
     */
    @ApiModelProperty(value="用户对消息操作状态",name="usermgstate")
    private String usermgstate;


    /**
     * 用户对消息操作状态(前)(1--未读；2--已读；3--待还原)
     */
    @ApiModelProperty(value="用户对消息操作状态(前)",name="usermgstatebefore")
    private String usermgstatebefore;

    /**
     * 消息列表
     */
    @ApiModelProperty(value="消息列表",name="mgList")
    private List<String> mgList;

    /**
     * 用户列表
     */
    @ApiModelProperty(value="用户列表",name="userList")
    private List<String> userList;

    /**
     * 用户MAP列表
     */
    @ApiModelProperty(value="用户MAP列表",name="userMapList")
    private List<Map<String, String>> userMapList;


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
     * usermessagerela
     */
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getMgid() {
        return mgid;
    }

    public void setMgid(String mgid) {
        this.mgid = mgid == null ? null : mgid.trim();
    }

    public String getMgcontent() {
        String str = mgcontent;
        if(MessageCenterType.SYSTEM.getCode().equals(getMgtype())){
            str = "【系统通知】" + mgcontent;
        }
        return str;
    }

    public void setMgcontent(String mgcontent) {
        this.mgcontent = mgcontent == null ? null : mgcontent.trim();
    }

    public String getUsermgstate() {
        return usermgstate;
    }

    public void setUsermgstate(String usermgstate) {
        this.usermgstate = usermgstate == null ? null : usermgstate.trim();
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

    public List<String> getMgList() {
        return mgList;
    }

    public void setMgList(List<String> mgList) {
        this.mgList = mgList;
    }

    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
    }

    public List<Map<String, String>> getUserMapList() {
        return userMapList;
    }

    public void setUserMapList(List<Map<String, String>> userMapList) {
        this.userMapList = userMapList;
    }

    public String getMgtype() {
        return mgtype;
    }

    public void setMgtype(String mgtype) {
        this.mgtype = mgtype;
    }

    public String getMgstate() {
        return mgstate;
    }

    public void setMgstate(String mgstate) {
        this.mgstate = mgstate;
    }

    public String getUsermgstatebefore() {
        return usermgstatebefore;
    }

    public void setUsermgstatebefore(String usermgstatebefore) {
        this.usermgstatebefore = usermgstatebefore;
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
        sb.append(", userid=").append(userid);
        sb.append(", username=").append(username);
        sb.append(", mgid=").append(mgid);
        sb.append(", usermgstate=").append(usermgstate);
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
        UserMessageRela other = (UserMessageRela) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getMgid() == null ? other.getMgid() == null : this.getMgid().equals(other.getMgid()))
            && (this.getUsermgstate() == null ? other.getUsermgstate() == null : this.getUsermgstate().equals(other.getUsermgstate()))
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
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getMgid() == null) ? 0 : getMgid().hashCode());
        result = prime * result + ((getUsermgstate() == null) ? 0 : getUsermgstate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }
}