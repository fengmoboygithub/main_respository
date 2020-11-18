/*
*
* ProjectDirectory.java
*                    中证技术公司
* @date 2020-02-04
*/
package com.company.projectdirectory.view;

import com.company.base.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(value="项目目录信息树对象",description="项目目录信息及底稿信息树类型显示对象")
public class ProjectDirectoryTree extends BaseModel implements Serializable {
    /**
     * 项目编号
     */
	@ApiModelProperty(value="项目编号",name="projectid")
    private String projectid;

    /**
     * 项目类型ID
     */
    @ApiModelProperty(value="项目类型ID",name="projecttype")
    private String projecttype;

    /**
     * 项目阶段
     */
    @ApiModelProperty(value="项目阶段",name="stage")
    private String stage;

    /**
     * 目录或底稿编号
     */
	@ApiModelProperty(value="目录或底稿编号",name="id")
    private String id;

    /**
     * 父级编号
     */
	@ApiModelProperty(value="父级编号",name="pid")
    private String pid;

    /**
     * 目录或底稿名称
     */
	@ApiModelProperty(value="目录或底稿名称",name="name")
    private String name;

    /**
     * status
     */
	@ApiModelProperty(value="状态",name="status")
    private String status;

    /**
     * 是否不显示复选框
     */
    @ApiModelProperty(value="是否不显示复选框",name="nocheck")
    private Boolean nocheck = false;
    
    /**
     * 文件存储名或目录版本
     */
    @ApiModelProperty(value="文件存储名",name="hashname")
    private String hashname;

    /**
     * 流程节点
     */
    @ApiModelProperty(value="流程节点",name="processnode")
    private String processnode;

    /**
     * 流程节点名称
     */
    @ApiModelProperty(value="流程节点名称",name="processnodename")
    private String processnodename;

    /**
     * 类型 dir>>目录 file>>底稿文件
     */
    @ApiModelProperty(value="类型",name="type")
    private String type;

    /**
     * 是否适用
     */
    @ApiModelProperty(value="是否适用",name="isapp")
    private Integer isapp;
    /**
     * 是否禁用复选框
     */
    @ApiModelProperty(value="是否禁用复选框",name="chkDisabled")
    private boolean chkDisabled = true;
    /**
     * 底稿是否可以删除标识
     */
    @ApiModelProperty(value="底稿是否可以删除标识",name="isdel")
    private boolean isdel = false;
    /**
     * 文件类型
     */
    @ApiModelProperty(value="文件类型",name="filetype")
    private String filetype;

    /**
     * 版本组成
     */
    @ApiModelProperty(value="版本组成",name="versioncomposition")
    private String versioncomposition;

    /**
     * projectdirectory
     */
    private static final long serialVersionUID = 1L;

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid == null ? null : projectid.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage == null ? null : stage.trim();
    }

    public String getProjecttype() {
        return projecttype;
    }

    public void setProjecttype(String projecttype) {
        this.projecttype = projecttype == null ? null : projecttype.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
    
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Boolean getNocheck() {
        return nocheck;
    }

    public void setNocheck(Boolean nocheck) {
        this.nocheck = nocheck;
    }

    public String getHashname() {
		return hashname;
	}

	public void setHashname(String hashname) {
		this.hashname = hashname;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIsapp() { return isapp; }

    public void setIsapp(Integer isapp) { this.isapp = isapp; }

    public Boolean getChkDisabled() { return chkDisabled; }

    public void setChkDisabled(Boolean chkDisabled) { this.chkDisabled = chkDisabled; }

    public Boolean getIsdel() { return isdel; }

    public void setIsdel(Boolean isdel) { this.isdel = isdel; }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public boolean isChkDisabled() {
        return chkDisabled;
    }

    public void setChkDisabled(boolean chkDisabled) {
        this.chkDisabled = chkDisabled;
    }

    public boolean isIsdel() {
        return isdel;
    }

    public void setIsdel(boolean isdel) {
        this.isdel = isdel;
    }

    public String getVersioncomposition() {
        return versioncomposition;
    }

    public void setVersioncomposition(String versioncomposition) {
        this.versioncomposition = versioncomposition;
    }

    /**
     *
     * @mbg.generated 2020-02-04
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectid=").append(projectid);
        sb.append(", projecttype=").append(projecttype);
        sb.append(", stage=").append(stage);
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", name=").append(name);
        sb.append(", status=").append(status);
        sb.append(", nocheck=").append(nocheck);
        sb.append(", hashname=").append(hashname);
        sb.append(", processnode=").append(processnode);
        sb.append(", type=").append(type);
        sb.append(", isapp=").append(isapp);
        sb.append(", chkDisabled=").append(chkDisabled);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-02-04
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
        ProjectDirectoryTree other = (ProjectDirectoryTree) that;
        return (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()))
            && (this.getProjecttype() == null ? other.getProjecttype() == null : this.getProjecttype().equals(other.getProjecttype()))
                && (this.getStage() == null ? other.getStage() == null : this.getStage().equals(other.getStage()))
                && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getNocheck() == null ? other.getNocheck() == null : this.getNocheck().equals(other.getNocheck()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getHashname() == null ? other.getHashname() == null : this.getHashname().equals(other.getHashname()))
            && (this.getProcessnode() == null ? other.getProcessnode() == null : this.getProcessnode().equals(other.getProcessnode()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getIsapp() == null ? other.getIsapp() == null : this.getIsapp().equals(other.getIsapp()))
                && (this.getChkDisabled() == null ? other.getChkDisabled() == null : this.getChkDisabled().equals(other.getChkDisabled()));

    }

    /**
     *
     * @mbg.generated 2020-02-04
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectid() == null) ? 0 : getProjectid().hashCode());
        result = prime * result + ((getProjecttype() == null) ? 0 : getProjecttype().hashCode());
        result = prime * result + ((getStage() == null) ? 0 : getStage().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getNocheck() == null) ? 0 : getNocheck().hashCode());
        result = prime * result + ((getHashname() == null) ? 0 : getHashname().hashCode());
        result = prime * result + ((getProcessnode() == null) ? 0 : getProcessnode().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getIsapp() == null) ? 0 : getIsapp().hashCode());
        result = prime * result + ((getChkDisabled() == null) ? 0 : getChkDisabled().hashCode());
        return result;
    }
}