/*
*
* HandleTupleTmp.java
*                    中证技术公司
* @date 2019-10-31
*/
package com.company.one.handletuple.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class HandleTupleTmp extends BaseModel implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 文件内容表主键
     */
    private Integer fileItemId;

    /**
     * 元组名称
     */
    private String tupleName;

    /**
     * 报送记录号
     */
    private String submissionRecordId;

    /**
     * 元组条目序号
     */
    private Integer tupleItemSort;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 元组条目内容
     */
    private String tupleItemContent;

    /**
     * handle_tuple_tmp
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFileItemId() {
        return fileItemId;
    }

    public void setFileItemId(Integer fileItemId) {
        this.fileItemId = fileItemId;
    }

    public String getTupleName() {
        return tupleName;
    }

    public void setTupleName(String tupleName) {
        this.tupleName = tupleName == null ? null : tupleName.trim();
    }

    public String getSubmissionRecordId() {
        return submissionRecordId;
    }

    public void setSubmissionRecordId(String submissionRecordId) {
        this.submissionRecordId = submissionRecordId == null ? null : submissionRecordId.trim();
    }

    public Integer getTupleItemSort() {
        return tupleItemSort;
    }

    public void setTupleItemSort(Integer tupleItemSort) {
        this.tupleItemSort = tupleItemSort;
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

    public String getTupleItemContent() {
        return tupleItemContent;
    }

    public void setTupleItemContent(String tupleItemContent) {
        this.tupleItemContent = tupleItemContent == null ? null : tupleItemContent.trim();
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
        sb.append(", fileItemId=").append(fileItemId);
        sb.append(", tupleName=").append(tupleName);
        sb.append(", submissionRecordId=").append(submissionRecordId);
        sb.append(", tupleItemSort=").append(tupleItemSort);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", tupleItemContent=").append(tupleItemContent);
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
        HandleTupleTmp other = (HandleTupleTmp) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFileItemId() == null ? other.getFileItemId() == null : this.getFileItemId().equals(other.getFileItemId()))
            && (this.getTupleName() == null ? other.getTupleName() == null : this.getTupleName().equals(other.getTupleName()))
            && (this.getSubmissionRecordId() == null ? other.getSubmissionRecordId() == null : this.getSubmissionRecordId().equals(other.getSubmissionRecordId()))
            && (this.getTupleItemSort() == null ? other.getTupleItemSort() == null : this.getTupleItemSort().equals(other.getTupleItemSort()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getTupleItemContent() == null ? other.getTupleItemContent() == null : this.getTupleItemContent().equals(other.getTupleItemContent()));
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
        result = prime * result + ((getFileItemId() == null) ? 0 : getFileItemId().hashCode());
        result = prime * result + ((getTupleName() == null) ? 0 : getTupleName().hashCode());
        result = prime * result + ((getSubmissionRecordId() == null) ? 0 : getSubmissionRecordId().hashCode());
        result = prime * result + ((getTupleItemSort() == null) ? 0 : getTupleItemSort().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getTupleItemContent() == null) ? 0 : getTupleItemContent().hashCode());
        return result;
    }
}