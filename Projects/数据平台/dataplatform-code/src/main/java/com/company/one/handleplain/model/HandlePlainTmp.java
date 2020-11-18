/*
*
* HandlePlainTmp.java
*                    中证技术公司
* @date 2019-10-31
*/
package com.company.one.handleplain.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class HandlePlainTmp extends BaseModel implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 处理文件表主键
     */
    private Integer fileId;

    /**
     * 报送记录号
     */
    private String submissionRecordId;

    /**
     * 文件条目序号
     */
    private Integer fileItemSort;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 文件条目内容
     */
    private String fileItemContent;

    /**
     * json数据
     */
    private String dataJson;

    /**
     * handle_plain_tmp
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getSubmissionRecordId() {
        return submissionRecordId;
    }

    public void setSubmissionRecordId(String submissionRecordId) {
        this.submissionRecordId = submissionRecordId == null ? null : submissionRecordId.trim();
    }

    public Integer getFileItemSort() {
        return fileItemSort;
    }

    public void setFileItemSort(Integer fileItemSort) {
        this.fileItemSort = fileItemSort;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getFileItemContent() {
        return fileItemContent;
    }

    public void setFileItemContent(String fileItemContent) {
        this.fileItemContent = fileItemContent == null ? null : fileItemContent.trim();
    }

    public String getDataJson() {
        return dataJson;
    }

    public void setDataJson(String dataJson) {
        this.dataJson = dataJson == null ? null : dataJson.trim();
    }

    /**
     *
     * @mbg.generated 2019-10-31
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fileId=").append(fileId);
        sb.append(", submissionRecordId=").append(submissionRecordId);
        sb.append(", fileItemSort=").append(fileItemSort);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", fileItemContent=").append(fileItemContent);
        sb.append(", dataJson=").append(dataJson);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2019-10-31
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
        HandlePlainTmp other = (HandlePlainTmp) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFileId() == null ? other.getFileId() == null : this.getFileId().equals(other.getFileId()))
            && (this.getSubmissionRecordId() == null ? other.getSubmissionRecordId() == null : this.getSubmissionRecordId().equals(other.getSubmissionRecordId()))
            && (this.getFileItemSort() == null ? other.getFileItemSort() == null : this.getFileItemSort().equals(other.getFileItemSort()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getFileItemContent() == null ? other.getFileItemContent() == null : this.getFileItemContent().equals(other.getFileItemContent()))
            && (this.getDataJson() == null ? other.getDataJson() == null : this.getDataJson().equals(other.getDataJson()));
    }

    /**
     *
     * @mbg.generated 2019-10-31
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFileId() == null) ? 0 : getFileId().hashCode());
        result = prime * result + ((getSubmissionRecordId() == null) ? 0 : getSubmissionRecordId().hashCode());
        result = prime * result + ((getFileItemSort() == null) ? 0 : getFileItemSort().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getFileItemContent() == null) ? 0 : getFileItemContent().hashCode());
        result = prime * result + ((getDataJson() == null) ? 0 : getDataJson().hashCode());
        return result;
    }
}