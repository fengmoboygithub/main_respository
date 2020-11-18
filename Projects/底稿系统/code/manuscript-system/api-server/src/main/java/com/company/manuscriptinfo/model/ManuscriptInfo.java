/*
*
* ManuscriptInfo.java
*                    中证技术公司
* @date 2020-02-04
*/
package com.company.manuscriptinfo.model;

import com.company.base.model.BaseModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
@ApiModel(value="底稿信息对象",description="底稿信息表(MANUSCRIPTINFO)")
public class ManuscriptInfo extends BaseModel implements Serializable {
    /**
     * 主键
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
     * 文件显示名
     */
	@ApiModelProperty(value="文件显示名",name="docname")
    private String docname;

    /**
     * 文件存储名
     */
    @ApiModelProperty(value="文件存储名",name="hashname")
    private String hashname;

    /**
     * 底稿状态
     */
    @ApiModelProperty(value="底稿状态",name="status")
    private String status;

    /**
     * 底稿提交时间
     */
    @ApiModelProperty(value="底稿提交时间",name="uploaddate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date uploaddate;

    /**
     * 提交人
     */
    @ApiModelProperty(value="提交人",name="userid")
    private String userid;

    /**
     * 顺序号
     */
    @ApiModelProperty(value="顺序号",name="orderno")
    private Long orderno;

    /**
     * 是否适用
     */
    @ApiModelProperty(value="是否适用",name="isapp")
    private Integer isapp;

    /**
     * 流程节点(当前)
     */
    @ApiModelProperty(value="流程节点(当前)",name="processnode")
    private String processnode;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注",name="remarks")
    private String remarks;

    /**
     * 文件类型
     */
    @ApiModelProperty(value="文件类型",name="filetype")
    private String filetype;

    /**
     * manuscriptinfo
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

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname == null ? null : docname.trim();
    }

    public String getHashname() {
        return hashname;
    }

    public void setHashname(String hashname) {
        this.hashname = hashname == null ? null : hashname.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(Date uploaddate) {
        this.uploaddate = uploaddate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Long getOrderno() {
        return orderno;
    }

    public void setOrderno(Long orderno) {
        this.orderno = orderno;
    }

    public Integer getIsapp() {
        return isapp;
    }

    public void setIsapp(Integer isapp) {
        this.isapp = isapp;
    }

    public String getProcessnode() {
        return processnode;
    }

    public void setProcessnode(String processnode) {
        this.processnode = processnode == null ? null : processnode.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    /**
     *
     * @mbg.generated 2020-04-28
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
        sb.append(", docname=").append(docname);
        sb.append(", hashname=").append(hashname);
        sb.append(", status=").append(status);
        sb.append(", uploaddate=").append(uploaddate);
        sb.append(", userid=").append(userid);
        sb.append(", orderno=").append(orderno);
        sb.append(", isapp=").append(isapp);
        sb.append(", processnode=").append(processnode);
        sb.append(", remarks=").append(remarks);
        sb.append(", filetype=").append(filetype);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-04-28
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
        ManuscriptInfo other = (ManuscriptInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()))
                && (this.getDirectoryid() == null ? other.getDirectoryid() == null : this.getDirectoryid().equals(other.getDirectoryid()))
                && (this.getDocname() == null ? other.getDocname() == null : this.getDocname().equals(other.getDocname()))
                && (this.getHashname() == null ? other.getHashname() == null : this.getHashname().equals(other.getHashname()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getUploaddate() == null ? other.getUploaddate() == null : this.getUploaddate().equals(other.getUploaddate()))
                && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
                && (this.getOrderno() == null ? other.getOrderno() == null : this.getOrderno().equals(other.getOrderno()))
                && (this.getIsapp() == null ? other.getIsapp() == null : this.getIsapp().equals(other.getIsapp()))
                && (this.getProcessnode() == null ? other.getProcessnode() == null : this.getProcessnode().equals(other.getProcessnode()))
                && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
                && (this.getFiletype() == null ? other.getFiletype() == null : this.getFiletype().equals(other.getFiletype()));
    }

    /**
     *
     * @mbg.generated 2020-04-28
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectid() == null) ? 0 : getProjectid().hashCode());
        result = prime * result + ((getDirectoryid() == null) ? 0 : getDirectoryid().hashCode());
        result = prime * result + ((getDocname() == null) ? 0 : getDocname().hashCode());
        result = prime * result + ((getHashname() == null) ? 0 : getHashname().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUploaddate() == null) ? 0 : getUploaddate().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getOrderno() == null) ? 0 : getOrderno().hashCode());
        result = prime * result + ((getIsapp() == null) ? 0 : getIsapp().hashCode());
        result = prime * result + ((getProcessnode() == null) ? 0 : getProcessnode().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getFiletype() == null) ? 0 : getFiletype().hashCode());
        return result;
    }
}