/*
*
* HandleDetailTab.java
*                    中证技术公司
* @date 2019-10-31
*/
package com.company.one.handledetail.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class HandleDetailTab extends BaseModel implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 处理文件表id
     */
    private Integer fileId;

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
     * 报送记录号
     */
    private String submissionRecordId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 报送返回提示信息
     */
    private String submissionMsg;

    /**
     * 报送返回错误信息
     */
    private String submissionError;

    /**
     * 报送返回报告业务编号
     */
    private String submissionBizid;

    /**
     * 报送返回协议编号
     */
    private String submissionProtcolid;

    /**
     * 报送返回附加信息
     */
    private String submissionData;

    /**
     * 应答信息
     */
    private String responseMsg;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * json数据
     */
    private String dataJson;

    /**
     * handle_detail_tab
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

    public String getSubmissionRecordId() {
        return submissionRecordId;
    }

    public void setSubmissionRecordId(String submissionRecordId) {
        this.submissionRecordId = submissionRecordId == null ? null : submissionRecordId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSubmissionMsg() {
        return submissionMsg;
    }

    public void setSubmissionMsg(String submissionMsg) {
        this.submissionMsg = submissionMsg == null ? null : submissionMsg.trim();
    }

    public String getSubmissionError() {
        return submissionError;
    }

    public void setSubmissionError(String submissionError) {
        this.submissionError = submissionError == null ? null : submissionError.trim();
    }

    public String getSubmissionBizid() {
        return submissionBizid;
    }

    public void setSubmissionBizid(String submissionBizid) {
        this.submissionBizid = submissionBizid == null ? null : submissionBizid.trim();
    }

    public String getSubmissionProtcolid() {
        return submissionProtcolid;
    }

    public void setSubmissionProtcolid(String submissionProtcolid) {
        this.submissionProtcolid = submissionProtcolid == null ? null : submissionProtcolid.trim();
    }

    public String getSubmissionData() {
        return submissionData;
    }

    public void setSubmissionData(String submissionData) {
        this.submissionData = submissionData == null ? null : submissionData.trim();
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg == null ? null : responseMsg.trim();
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
        sb.append(", fileCreaterCode=").append(fileCreaterCode);
        sb.append(", fileReceiverCode=").append(fileReceiverCode);
        sb.append(", interfaceId=").append(interfaceId);
        sb.append(", submissionDate=").append(submissionDate);
        sb.append(", fileNum=").append(fileNum);
        sb.append(", operationId=").append(operationId);
        sb.append(", submissionRecordId=").append(submissionRecordId);
        sb.append(", status=").append(status);
        sb.append(", submissionMsg=").append(submissionMsg);
        sb.append(", submissionError=").append(submissionError);
        sb.append(", submissionBizid=").append(submissionBizid);
        sb.append(", submissionProtcolid=").append(submissionProtcolid);
        sb.append(", submissionData=").append(submissionData);
        sb.append(", responseMsg=").append(responseMsg);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
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
        HandleDetailTab other = (HandleDetailTab) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFileId() == null ? other.getFileId() == null : this.getFileId().equals(other.getFileId()))
            && (this.getFileCreaterCode() == null ? other.getFileCreaterCode() == null : this.getFileCreaterCode().equals(other.getFileCreaterCode()))
            && (this.getFileReceiverCode() == null ? other.getFileReceiverCode() == null : this.getFileReceiverCode().equals(other.getFileReceiverCode()))
            && (this.getInterfaceId() == null ? other.getInterfaceId() == null : this.getInterfaceId().equals(other.getInterfaceId()))
            && (this.getSubmissionDate() == null ? other.getSubmissionDate() == null : this.getSubmissionDate().equals(other.getSubmissionDate()))
            && (this.getFileNum() == null ? other.getFileNum() == null : this.getFileNum().equals(other.getFileNum()))
            && (this.getOperationId() == null ? other.getOperationId() == null : this.getOperationId().equals(other.getOperationId()))
            && (this.getSubmissionRecordId() == null ? other.getSubmissionRecordId() == null : this.getSubmissionRecordId().equals(other.getSubmissionRecordId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSubmissionMsg() == null ? other.getSubmissionMsg() == null : this.getSubmissionMsg().equals(other.getSubmissionMsg()))
            && (this.getSubmissionError() == null ? other.getSubmissionError() == null : this.getSubmissionError().equals(other.getSubmissionError()))
            && (this.getSubmissionBizid() == null ? other.getSubmissionBizid() == null : this.getSubmissionBizid().equals(other.getSubmissionBizid()))
            && (this.getSubmissionProtcolid() == null ? other.getSubmissionProtcolid() == null : this.getSubmissionProtcolid().equals(other.getSubmissionProtcolid()))
            && (this.getSubmissionData() == null ? other.getSubmissionData() == null : this.getSubmissionData().equals(other.getSubmissionData()))
            && (this.getResponseMsg() == null ? other.getResponseMsg() == null : this.getResponseMsg().equals(other.getResponseMsg()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
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
        result = prime * result + ((getFileCreaterCode() == null) ? 0 : getFileCreaterCode().hashCode());
        result = prime * result + ((getFileReceiverCode() == null) ? 0 : getFileReceiverCode().hashCode());
        result = prime * result + ((getInterfaceId() == null) ? 0 : getInterfaceId().hashCode());
        result = prime * result + ((getSubmissionDate() == null) ? 0 : getSubmissionDate().hashCode());
        result = prime * result + ((getFileNum() == null) ? 0 : getFileNum().hashCode());
        result = prime * result + ((getOperationId() == null) ? 0 : getOperationId().hashCode());
        result = prime * result + ((getSubmissionRecordId() == null) ? 0 : getSubmissionRecordId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSubmissionMsg() == null) ? 0 : getSubmissionMsg().hashCode());
        result = prime * result + ((getSubmissionError() == null) ? 0 : getSubmissionError().hashCode());
        result = prime * result + ((getSubmissionBizid() == null) ? 0 : getSubmissionBizid().hashCode());
        result = prime * result + ((getSubmissionProtcolid() == null) ? 0 : getSubmissionProtcolid().hashCode());
        result = prime * result + ((getSubmissionData() == null) ? 0 : getSubmissionData().hashCode());
        result = prime * result + ((getResponseMsg() == null) ? 0 : getResponseMsg().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getDataJson() == null) ? 0 : getDataJson().hashCode());
        return result;
    }
}