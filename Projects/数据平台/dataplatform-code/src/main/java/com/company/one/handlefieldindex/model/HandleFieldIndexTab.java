/*
*
* HandleFieldIndexTab.java
*                    中证技术公司
* @date 2019-10-31
*/
package com.company.one.handlefieldindex.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;

public class HandleFieldIndexTab extends BaseModel implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 模板编号
     */
    private String tTemplateType;

    /**
     * 业务字段名称
     */
    private String tElementName;

    /**
     * 数据库字段名称
     */
    private String dField;

    /**
     * 上级tuple数据库字段名称
     */
    private String dTupleUpName;

    /**
     * 控件类型0|普通元素、1|Tuple子项元素、2|多附件、3|单附件、4|Tuple父元素（虚元素）
     */
    private String tControlType;

    /**
     * 字段存储的索引值
     */
    private Integer indexValue;

    /**
     * handle_field_index_tab
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

    public String gettElementName() {
        return tElementName;
    }

    public void settElementName(String tElementName) {
        this.tElementName = tElementName == null ? null : tElementName.trim();
    }

    public String getdField() {
        return dField;
    }

    public void setdField(String dField) {
        this.dField = dField == null ? null : dField.trim();
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

    public Integer getIndexValue() {
        return indexValue;
    }

    public void setIndexValue(Integer indexValue) {
        this.indexValue = indexValue;
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
        sb.append(", tElementName=").append(tElementName);
        sb.append(", dField=").append(dField);
        sb.append(", dTupleUpName=").append(dTupleUpName);
        sb.append(", tControlType=").append(tControlType);
        sb.append(", indexValue=").append(indexValue);
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
        HandleFieldIndexTab other = (HandleFieldIndexTab) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.gettTemplateType() == null ? other.gettTemplateType() == null : this.gettTemplateType().equals(other.gettTemplateType()))
            && (this.gettElementName() == null ? other.gettElementName() == null : this.gettElementName().equals(other.gettElementName()))
            && (this.getdField() == null ? other.getdField() == null : this.getdField().equals(other.getdField()))
            && (this.getdTupleUpName() == null ? other.getdTupleUpName() == null : this.getdTupleUpName().equals(other.getdTupleUpName()))
            && (this.gettControlType() == null ? other.gettControlType() == null : this.gettControlType().equals(other.gettControlType()))
            && (this.getIndexValue() == null ? other.getIndexValue() == null : this.getIndexValue().equals(other.getIndexValue()));
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
        result = prime * result + ((gettElementName() == null) ? 0 : gettElementName().hashCode());
        result = prime * result + ((getdField() == null) ? 0 : getdField().hashCode());
        result = prime * result + ((getdTupleUpName() == null) ? 0 : getdTupleUpName().hashCode());
        result = prime * result + ((gettControlType() == null) ? 0 : gettControlType().hashCode());
        result = prime * result + ((getIndexValue() == null) ? 0 : getIndexValue().hashCode());
        return result;
    }
}