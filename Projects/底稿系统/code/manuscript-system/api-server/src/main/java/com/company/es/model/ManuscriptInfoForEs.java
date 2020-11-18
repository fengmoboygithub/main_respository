/*
*
* ManuscriptInfoForEs.java
*                    中证技术公司
* @date 2020-02-22
*/
package com.company.es.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.company.base.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel(value="底稿信息索引对象",description="底稿信息索引")
@Data
@Document(indexName = "manuscript",type = "manuscriptInfoForEs", shards = 5, replicas = 1)
public class ManuscriptInfoForEs extends BaseModel implements Serializable {
//	Document
//    String indexName();//索引库的名称，个人建议以项目的名称命名
//    String type() default "";//类型，个人建议以实体的名称命名
//    short shards() default 5;//默认分片数
//    short replicas() default 1;//每个分片默认的备份数
//    String refreshInterval() default "1s";//刷新间隔
//    String indexStoreType() default "fs";//索引文件存储类型
//Field
//    FieldType type() default FieldType.Auto;#自动检测属性的类型
//    FieldIndex index() default FieldIndex.analyzed;#默认情况下分词
//    DateFormat format() default DateFormat.none;
//    String pattern() default "";
//    boolean store() default false;#默认情况下不存储原文
//    String searchAnalyzer() default "";#指定字段搜索时使用的分词器
//    String indexAnalyzer() default "";#指定字段建立索引时指定的分词器
//    String[] ignoreFields() default {};#如果某个字段需要被忽略
//    boolean includeInParent() default false;
	/**
     * 底稿ID(主键)或者底稿版本ID(主键)
     */
	@ApiModelProperty(value="底稿ID(主键)",name="id")
    private String id;

	//  分词器:
	//    	standard   :(默认的) 会将词汇转化为小写 并去除停用词标点符号,支持中文采用的方式是单字切片。
	//    	simple ：首先通过非字母进行分割，然后转化为小写，会去掉数字类型的字符。
	//    	whitespace :仅仅是去除空格
	//    	language:特定语言的分词器,不支持中文。
	//    	analysis-ik ：中文分词器    下面分为两种   ik_max_word   是尽可能多的分词    ik_smart   粗略的分词
	//	是否需要分词？  Text 表示文本，可被分词也可以被索引，keyword表示为关键字，
	//			不分词，但可以被索引，只是String可被分词
	//	是否需要索引？  index为true表示可被索引，为false表示不可被索引
	//	是否需要存储？  store为true表示可被存储，为false表示不可被存储
	/**
     * 文件显示名
     */
	@Field(type = FieldType.text, analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
	@ApiModelProperty(value="文件显示名",name="docname")
    private String docname;

	/**
	 * 全文检索
	 */
	@Field(type = FieldType.text, analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
	@ApiModelProperty(value="全文检索",name="keyword")
	private String keyword;

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
    @ApiModelProperty(value="底稿提交时间",name="uploadtime")
	@Field(type = FieldType.text, fielddata=true)
    private String uploadtime;

    /**
     * 提交人
     */
    @ApiModelProperty(value="提交人",name="userid")
    private String userid;

	/**
	 * 文件类型
	 */
//	@ApiModelProperty(value="文件类型",name="filetype")
//	private String filetype;

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
     * 是否最新版  0为旧版；1位新版
     */
    @ApiModelProperty(value="是否最新版",name="newversionflag")
    private String newversionflag;

    /**
     * 底稿版本
     */
    @ApiModelProperty(value="底稿版本",name="version")
    private String version;

    /**
     * 目录ID
     */
    @ApiModelProperty(value="目录ID",name="directoryid")
    private String directoryid;

    /**
     * 目录简称
     */
    @ApiModelProperty(value="目录简称",name="directorysname")
    private String directorysname;

    /**
     * 目录全称
     */
    @ApiModelProperty(value="目录全称",name="directoryfullname")
    private String directoryfullname;

    /**
     * 项目ID
     */
	@ApiModelProperty(value="项目ID",name="projectid")
    private String projectid;

	/**
     * 项目名称
     */
    @ApiModelProperty(value="项目名称",name="projectname")
    private String projectname;

    /**
     * 项目阶段
     */
    @ApiModelProperty(value="项目阶段",name="projectstage")
    private String projectstage;

    /**
     * 项目类型
     */
    @ApiModelProperty(value="项目类型",name="projecttype")
    private String projecttype;

    /**
     * 项目开始时间
     */
    @ApiModelProperty(value="项目开始时间",name="projectstarttime")
    private String projectstarttime;

    /**
     * 项目结束时间
     */
    @ApiModelProperty(value="项目结束时间",name="projectendtime")
    private String projectendtime;

    /**
     * ManuscriptInfoForEs
     */
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname == null ? null : docname.trim();
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword == null ? null : keyword.trim();
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

	public String getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime == null ? null : uploadtime.trim();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

//	public String getFiletype() { return filetype; }
//
//	public void setFiletype(String filetype) {
//		this.filetype = filetype == null ? null : filetype.trim();
//	}

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

	public String getNewversionflag() {
		return newversionflag;
	}

	public void setNewversionflag(String newversionflag) {
		this.newversionflag = newversionflag == null ? null : newversionflag.trim();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version == null ? null : version.trim();
	}

	public String getDirectoryid() {
		return directoryid;
	}

	public void setDirectoryid(String directoryid) {
		this.directoryid = directoryid == null ? null : directoryid.trim();
	}

	public String getDirectorysname() {
		return directorysname;
	}

	public void setDirectorysname(String directorysname) {
		this.directorysname = directorysname == null ? null : directorysname.trim();
	}

	public String getDirectoryfullname() {
		return directoryfullname;
	}

	public void setDirectoryfullname(String directoryfullname) {
		this.directoryfullname = directoryfullname == null ? null : directoryfullname.trim();
	}

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid == null ? null : projectid.trim();
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname == null ? null : projectname.trim();
	}

	public String getProjectstage() {
		return projectstage;
	}

	public void setProjectstage(String projectstage) {
		this.projectstage = projectstage == null ? null : projectstage.trim();
	}

	public String getProjecttype() {
		return projecttype;
	}

	public void setProjecttype(String projecttype) {
		this.projecttype = projecttype == null ? null : projecttype.trim();
	}

	public String getProjectstarttime() {
		return projectstarttime;
	}

	public void setProjectstarttime(String projectstarttime) {
		this.projectstarttime = projectstarttime == null ? null : projectstarttime.trim();
	}

	public String getProjectendtime() {
		return projectendtime;
	}

	public void setProjectendtime(String projectendtime) {
		this.projectendtime = projectendtime == null ? null : projectendtime.trim();
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
        sb.append(", id=").append(id);
        sb.append(", docname=").append(docname);
		sb.append(", hashname=").append(hashname);
		sb.append(", status=").append(status);
		sb.append(", uploadtime=").append(uploadtime);
		sb.append(", userid=").append(userid);
		sb.append(", orderno=").append(orderno);
		sb.append(", isapp=").append(isapp);
		sb.append(", processnode=").append(processnode);
		sb.append(", newversionflag=").append(newversionflag);
		sb.append(", version=").append(version);
		sb.append(", directoryid=").append(directoryid);
		sb.append(", directorysname=").append(directorysname);
		sb.append(", directoryfullname=").append(directoryfullname);
		sb.append(", projectid=").append(projectid);
		sb.append(", projectname=").append(projectname);
		sb.append(", projectstage=").append(projectstage);
        sb.append(", projectstarttime=").append(projectstarttime);
		sb.append(", projectendtime=").append(projectendtime);
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
        ManuscriptInfoForEs other = (ManuscriptInfoForEs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        		&& (this.getDocname() == null ? other.getDocname() == null : this.getDocname().equals(other.getDocname()))
        		&& (this.getHashname() == null ? other.getHashname() == null : this.getHashname().equals(other.getHashname()))
        		&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
        		&& (this.getUploadtime() == null ? other.getUploadtime() == null : this.getUploadtime().equals(other.getUploadtime()))
        		&& (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
        		&& (this.getOrderno() == null ? other.getOrderno() == null : this.getOrderno().equals(other.getOrderno()))
        		&& (this.getIsapp() == null ? other.getIsapp() == null : this.getIsapp().equals(other.getIsapp()))
        		&& (this.getProcessnode() == null ? other.getProcessnode() == null : this.getProcessnode().equals(other.getProcessnode()))
        		&& (this.getNewversionflag() == null ? other.getNewversionflag() == null : this.getNewversionflag().equals(other.getNewversionflag()))
        		&& (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
        		&& (this.getDirectoryid() == null ? other.getDirectoryid() == null : this.getDirectoryid().equals(other.getDirectoryid()))
        		&& (this.getDirectorysname() == null ? other.getDirectorysname() == null : this.getDirectorysname().equals(other.getDirectorysname()))
        		&& (this.getDirectoryfullname() == null ? other.getDirectoryfullname() == null : this.getDirectoryfullname().equals(other.getDirectoryfullname()))
        		&& (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()))
        		&& (this.getProjectname() == null ? other.getProjectname() == null : this.getProjectname().equals(other.getProjectname()))
        		&& (this.getProjectstage() == null ? other.getProjectstage() == null : this.getProjectstage().equals(other.getProjectstage()))
        		&& (this.getProjecttype() == null ? other.getProjecttype() == null : this.getProjecttype().equals(other.getProjecttype()))
        		&& (this.getProjectstarttime() == null ? other.getProjectstarttime() == null : this.getProjectstarttime().equals(other.getProjectstarttime()))
        		&& (this.getProjectendtime() == null ? other.getProjectendtime() == null : this.getProjectendtime().equals(other.getProjectendtime()));
    }

    /**
     *
     * @mbg.generated 2020-02-04
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDocname() == null) ? 0 : getDocname().hashCode());
        result = prime * result + ((getHashname() == null) ? 0 : getHashname().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUploadtime() == null) ? 0 : getUploadtime().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getOrderno() == null) ? 0 : getOrderno().hashCode());
        result = prime * result + ((getIsapp() == null) ? 0 : getIsapp().hashCode());
        result = prime * result + ((getProcessnode() == null) ? 0 : getProcessnode().hashCode());
        result = prime * result + ((getNewversionflag() == null) ? 0 : getNewversionflag().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getDirectoryid() == null) ? 0 : getDirectoryid().hashCode());
        result = prime * result + ((getDirectorysname() == null) ? 0 : getDirectorysname().hashCode());
        result = prime * result + ((getDirectoryfullname() == null) ? 0 : getDirectoryfullname().hashCode());
        result = prime * result + ((getProjectid() == null) ? 0 : getProjectid().hashCode());
        result = prime * result + ((getProjectname() == null) ? 0 : getProjectname().hashCode());
        result = prime * result + ((getProjectstage() == null) ? 0 : getProjectstage().hashCode());
        result = prime * result + ((getProjecttype() == null) ? 0 : getProjecttype().hashCode());
        result = prime * result + ((getProjectstarttime() == null) ? 0 : getProjectstarttime().hashCode());
        result = prime * result + ((getProjectendtime() == null) ? 0 : getProjectendtime().hashCode());
        return result;
    }
}