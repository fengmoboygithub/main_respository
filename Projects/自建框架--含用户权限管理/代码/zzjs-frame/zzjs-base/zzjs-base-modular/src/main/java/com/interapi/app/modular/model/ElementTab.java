/*
*
* ElementTab.java
*                    中证技术公司
* @date 2018-11-23
*/
package com.interapi.app.modular.model;

import com.interapi.app.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class ElementTab extends BaseModel implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 表单项ID
     */
    private Long formItemId;

    /**
     * 查询条件项ID
     */
    private Long queryCriteriaItemId;

    /**
     * 元素类型
     */
    private String elementType;

    /**
     * 元素类型名称
     */
    private String elementTypeName;

    /**
     * 模型名称
     */
    private String modelName;

    /**
     * 样式风格
     */
    private String styleName;

    /**
     * 背景文字
     */
    private String placeholder;

    /**
     * 多选标识
     */
    private String multiple;

    /**
     * 过滤标识
     */
    private String filterable;

    /**
     * 选项集
     */
    private String options;

    /**
     * ‘0’为注销，‘1’为正常
     */
    private String isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 最近修改人
     */
    private Long updateUser;

    /**
     * element_tab
     */
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFormItemId() {
        return formItemId;
    }

    public void setFormItemId(Long formItemId) {
        this.formItemId = formItemId;
    }

    public Long getQueryCriteriaItemId() {
        return queryCriteriaItemId;
    }

    public void setQueryCriteriaItemId(Long queryCriteriaItemId) {
        this.queryCriteriaItemId = queryCriteriaItemId;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType == null ? null : elementType.trim();
    }

    public String getElementTypeName() {
        return elementTypeName;
    }

    public void setElementTypeName(String elementTypeName) {
        this.elementTypeName = elementTypeName == null ? null : elementTypeName.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName == null ? null : styleName.trim();
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder == null ? null : placeholder.trim();
    }

    public String getMultiple() {
        return multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple == null ? null : multiple.trim();
    }

    public String getFilterable() {
        return filterable;
    }

    public void setFilterable(String filterable) {
        this.filterable = filterable == null ? null : filterable.trim();
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options == null ? null : options.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     *
     * @mbg.generated 2018-11-23
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", formItemId=").append(formItemId);
        sb.append(", queryCriteriaItemId=").append(queryCriteriaItemId);
        sb.append(", elementType=").append(elementType);
        sb.append(", elementTypeName=").append(elementTypeName);
        sb.append(", modelName=").append(modelName);
        sb.append(", styleName=").append(styleName);
        sb.append(", placeholder=").append(placeholder);
        sb.append(", multiple=").append(multiple);
        sb.append(", filterable=").append(filterable);
        sb.append(", options=").append(options);
        sb.append(", isDelete=").append(isDelete);
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
     * @mbg.generated 2018-11-23
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
        ElementTab other = (ElementTab) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFormItemId() == null ? other.getFormItemId() == null : this.getFormItemId().equals(other.getFormItemId()))
            && (this.getQueryCriteriaItemId() == null ? other.getQueryCriteriaItemId() == null : this.getQueryCriteriaItemId().equals(other.getQueryCriteriaItemId()))
            && (this.getElementType() == null ? other.getElementType() == null : this.getElementType().equals(other.getElementType()))
            && (this.getElementTypeName() == null ? other.getElementTypeName() == null : this.getElementTypeName().equals(other.getElementTypeName()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getStyleName() == null ? other.getStyleName() == null : this.getStyleName().equals(other.getStyleName()))
            && (this.getPlaceholder() == null ? other.getPlaceholder() == null : this.getPlaceholder().equals(other.getPlaceholder()))
            && (this.getMultiple() == null ? other.getMultiple() == null : this.getMultiple().equals(other.getMultiple()))
            && (this.getFilterable() == null ? other.getFilterable() == null : this.getFilterable().equals(other.getFilterable()))
            && (this.getOptions() == null ? other.getOptions() == null : this.getOptions().equals(other.getOptions()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()));
    }

    /**
     *
     * @mbg.generated 2018-11-23
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFormItemId() == null) ? 0 : getFormItemId().hashCode());
        result = prime * result + ((getQueryCriteriaItemId() == null) ? 0 : getQueryCriteriaItemId().hashCode());
        result = prime * result + ((getElementType() == null) ? 0 : getElementType().hashCode());
        result = prime * result + ((getElementTypeName() == null) ? 0 : getElementTypeName().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getStyleName() == null) ? 0 : getStyleName().hashCode());
        result = prime * result + ((getPlaceholder() == null) ? 0 : getPlaceholder().hashCode());
        result = prime * result + ((getMultiple() == null) ? 0 : getMultiple().hashCode());
        result = prime * result + ((getFilterable() == null) ? 0 : getFilterable().hashCode());
        result = prime * result + ((getOptions() == null) ? 0 : getOptions().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }
}