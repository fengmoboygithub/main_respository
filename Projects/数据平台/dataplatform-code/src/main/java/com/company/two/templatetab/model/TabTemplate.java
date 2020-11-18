/*
*
* TabTemplate.java
*                    中证技术公司
* @date 2019-10-31
*/
package com.company.two.templatetab.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;

public class TabTemplate extends BaseModel implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 模板编号
     */
    private String tTemplateType;

    /**
     * 元素名称
     */
    private String tElementId;

    /**
     * 业务字段名称
     */
    private String tElementName;

    /**
     * 业务校验规则编号
     */
    private String tValidateRules;

    /**
     * 数据库字段名称
     */
    private String dField;

    /**
     * 数据库字段类型
     */
    private String dFieldType;

    /**
     * 对应数据库表名
     */
    private String dTableName;

    /**
     * 是否Tuple
     */
    private String dIsTuple;

    /**
     * 字段状态
     */
    private String status;

    /**
     * 数据字典
     */
    private String dDict;

    /**
     * 备注
     */
    private String remark;

    /**
     * 上级tuple数据库字段名称
     */
    private String dTupleUpName;

    /**
     * 控件类型0|普通元素、1|Tuple子项元素、2|多附件、3|单附件、4|Tuple父元素（虚元素）
     */
    private String tControlType;

    /**
     * 上级tuple xbrl元素名称
     */
    private String dTupleUpXbrlName;

    /**
     * tab_template
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String gettTemplateType() {
        return tTemplateType;
    }

    public void settTemplateType(String tTemplateType) {
        this.tTemplateType = tTemplateType == null ? null : tTemplateType.trim();
    }

    public String gettElementId() {
        return tElementId;
    }

    public void settElementId(String tElementId) {
        this.tElementId = tElementId == null ? null : tElementId.trim();
    }

    public String gettElementName() {
        return tElementName;
    }

    public void settElementName(String tElementName) {
        this.tElementName = tElementName == null ? null : tElementName.trim();
    }

    public String gettValidateRules() {
        return tValidateRules;
    }

    public void settValidateRules(String tValidateRules) {
        this.tValidateRules = tValidateRules == null ? null : tValidateRules.trim();
    }

    public String getdField() {
        return dField;
    }

    public void setdField(String dField) {
        this.dField = dField == null ? null : dField.trim();
    }

    public String getdFieldType() {
        return dFieldType;
    }

    public void setdFieldType(String dFieldType) {
        this.dFieldType = dFieldType == null ? null : dFieldType.trim();
    }

    public String getdTableName() {
        return dTableName;
    }

    public void setdTableName(String dTableName) {
        this.dTableName = dTableName == null ? null : dTableName.trim();
    }

    public String getdIsTuple() {
        return dIsTuple;
    }

    public void setdIsTuple(String dIsTuple) {
        this.dIsTuple = dIsTuple == null ? null : dIsTuple.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getdDict() {
        return dDict;
    }

    public void setdDict(String dDict) {
        this.dDict = dDict == null ? null : dDict.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getdTupleUpName() {
        return dTupleUpName;
    }

    public void setdTupleUpName(String dTupleUpName) {
        this.dTupleUpName = dTupleUpName == null ? null : dTupleUpName.trim();
    }

    public String gettControlType() {
        return tControlType;
    }

    public void settControlType(String tControlType) {
        this.tControlType = tControlType == null ? null : tControlType.trim();
    }

    public String getdTupleUpXbrlName() {
        return dTupleUpXbrlName;
    }

    public void setdTupleUpXbrlName(String dTupleUpXbrlName) {
        this.dTupleUpXbrlName = dTupleUpXbrlName == null ? null : dTupleUpXbrlName.trim();
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
        sb.append(", tTemplateType=").append(tTemplateType);
        sb.append(", tElementId=").append(tElementId);
        sb.append(", tElementName=").append(tElementName);
        sb.append(", tValidateRules=").append(tValidateRules);
        sb.append(", dField=").append(dField);
        sb.append(", dFieldType=").append(dFieldType);
        sb.append(", dTableName=").append(dTableName);
        sb.append(", dIsTuple=").append(dIsTuple);
        sb.append(", status=").append(status);
        sb.append(", dDict=").append(dDict);
        sb.append(", remark=").append(remark);
        sb.append(", dTupleUpName=").append(dTupleUpName);
        sb.append(", tControlType=").append(tControlType);
        sb.append(", dTupleUpXbrlName=").append(dTupleUpXbrlName);
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
        TabTemplate other = (TabTemplate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.gettTemplateType() == null ? other.gettTemplateType() == null : this.gettTemplateType().equals(other.gettTemplateType()))
            && (this.gettElementId() == null ? other.gettElementId() == null : this.gettElementId().equals(other.gettElementId()))
            && (this.gettElementName() == null ? other.gettElementName() == null : this.gettElementName().equals(other.gettElementName()))
            && (this.gettValidateRules() == null ? other.gettValidateRules() == null : this.gettValidateRules().equals(other.gettValidateRules()))
            && (this.getdField() == null ? other.getdField() == null : this.getdField().equals(other.getdField()))
            && (this.getdFieldType() == null ? other.getdFieldType() == null : this.getdFieldType().equals(other.getdFieldType()))
            && (this.getdTableName() == null ? other.getdTableName() == null : this.getdTableName().equals(other.getdTableName()))
            && (this.getdIsTuple() == null ? other.getdIsTuple() == null : this.getdIsTuple().equals(other.getdIsTuple()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getdDict() == null ? other.getdDict() == null : this.getdDict().equals(other.getdDict()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getdTupleUpName() == null ? other.getdTupleUpName() == null : this.getdTupleUpName().equals(other.getdTupleUpName()))
            && (this.gettControlType() == null ? other.gettControlType() == null : this.gettControlType().equals(other.gettControlType()))
            && (this.getdTupleUpXbrlName() == null ? other.getdTupleUpXbrlName() == null : this.getdTupleUpXbrlName().equals(other.getdTupleUpXbrlName()));
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
        result = prime * result + ((gettTemplateType() == null) ? 0 : gettTemplateType().hashCode());
        result = prime * result + ((gettElementId() == null) ? 0 : gettElementId().hashCode());
        result = prime * result + ((gettElementName() == null) ? 0 : gettElementName().hashCode());
        result = prime * result + ((gettValidateRules() == null) ? 0 : gettValidateRules().hashCode());
        result = prime * result + ((getdField() == null) ? 0 : getdField().hashCode());
        result = prime * result + ((getdFieldType() == null) ? 0 : getdFieldType().hashCode());
        result = prime * result + ((getdTableName() == null) ? 0 : getdTableName().hashCode());
        result = prime * result + ((getdIsTuple() == null) ? 0 : getdIsTuple().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getdDict() == null) ? 0 : getdDict().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getdTupleUpName() == null) ? 0 : getdTupleUpName().hashCode());
        result = prime * result + ((gettControlType() == null) ? 0 : gettControlType().hashCode());
        result = prime * result + ((getdTupleUpXbrlName() == null) ? 0 : getdTupleUpXbrlName().hashCode());
        return result;
    }
}