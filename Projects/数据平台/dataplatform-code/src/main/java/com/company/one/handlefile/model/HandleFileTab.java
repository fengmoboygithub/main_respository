/*
*
* HandleFileTab.java
*                    中证技术公司
* @date 2019-10-31
*/
package com.company.one.handlefile.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class HandleFileTab extends BaseModel implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 压缩包文件名
     */
    private String zipFileName;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件内容哈希值
     */
    private String hashFileEntity;

    /**
     * 文件创建人代码
     */
    private String fileCreaterCode;

    /**
     * 文件接收人代码
     */
    private String fileReceiverCode;

    /**
     * 接口标识
     */
    private String interfaceId;

    /**
     * 报送日期
     */
    private String submissionDate;

    /**
     * 文件序号
     */
    private String fileNum;

    /**
     * 操作标识
     */
    private String operationId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * handle_file_tab
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZipFileName() {
        return zipFileName;
    }

    public void setZipFileName(String zipFileName) {
        this.zipFileName = zipFileName == null ? null : zipFileName.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getHashFileEntity() {
        return hashFileEntity;
    }

    public void setHashFileEntity(String hashFileEntity) {
        this.hashFileEntity = hashFileEntity == null ? null : hashFileEntity.trim();
    }

    public String getFileCreaterCode() {
        return fileCreaterCode;
    }

    public void setFileCreaterCode(String fileCreaterCode) {
        this.fileCreaterCode = fileCreaterCode == null ? null : fileCreaterCode.trim();
    }

    public String getFileReceiverCode() {
        return fileReceiverCode;
    }

    public void setFileReceiverCode(String fileReceiverCode) {
        this.fileReceiverCode = fileReceiverCode == null ? null : fileReceiverCode.trim();
    }

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId == null ? null : interfaceId.trim();
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate == null ? null : submissionDate.trim();
    }

    public String getFileNum() {
        return fileNum;
    }

    public void setFileNum(String fileNum) {
        this.fileNum = fileNum == null ? null : fileNum.trim();
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId == null ? null : operationId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        sb.append(", zipFileName=").append(zipFileName);
        sb.append(", fileName=").append(fileName);
        sb.append(", hashFileEntity=").append(hashFileEntity);
        sb.append(", fileCreaterCode=").append(fileCreaterCode);
        sb.append(", fileReceiverCode=").append(fileReceiverCode);
        sb.append(", interfaceId=").append(interfaceId);
        sb.append(", submissionDate=").append(submissionDate);
        sb.append(", fileNum=").append(fileNum);
        sb.append(", operationId=").append(operationId);
        sb.append(", status=").append(status);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
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
        HandleFileTab other = (HandleFileTab) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getZipFileName() == null ? other.getZipFileName() == null : this.getZipFileName().equals(other.getZipFileName()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getHashFileEntity() == null ? other.getHashFileEntity() == null : this.getHashFileEntity().equals(other.getHashFileEntity()))
            && (this.getFileCreaterCode() == null ? other.getFileCreaterCode() == null : this.getFileCreaterCode().equals(other.getFileCreaterCode()))
            && (this.getFileReceiverCode() == null ? other.getFileReceiverCode() == null : this.getFileReceiverCode().equals(other.getFileReceiverCode()))
            && (this.getInterfaceId() == null ? other.getInterfaceId() == null : this.getInterfaceId().equals(other.getInterfaceId()))
            && (this.getSubmissionDate() == null ? other.getSubmissionDate() == null : this.getSubmissionDate().equals(other.getSubmissionDate()))
            && (this.getFileNum() == null ? other.getFileNum() == null : this.getFileNum().equals(other.getFileNum()))
            && (this.getOperationId() == null ? other.getOperationId() == null : this.getOperationId().equals(other.getOperationId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
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
        result = prime * result + ((getZipFileName() == null) ? 0 : getZipFileName().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getHashFileEntity() == null) ? 0 : getHashFileEntity().hashCode());
        result = prime * result + ((getFileCreaterCode() == null) ? 0 : getFileCreaterCode().hashCode());
        result = prime * result + ((getFileReceiverCode() == null) ? 0 : getFileReceiverCode().hashCode());
        result = prime * result + ((getInterfaceId() == null) ? 0 : getInterfaceId().hashCode());
        result = prime * result + ((getSubmissionDate() == null) ? 0 : getSubmissionDate().hashCode());
        result = prime * result + ((getFileNum() == null) ? 0 : getFileNum().hashCode());
        result = prime * result + ((getOperationId() == null) ? 0 : getOperationId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}