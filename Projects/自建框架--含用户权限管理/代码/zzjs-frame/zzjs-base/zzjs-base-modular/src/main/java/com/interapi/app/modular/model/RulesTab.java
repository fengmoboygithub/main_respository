/*
*
* RulesTab.java
*                    中证技术公司
* @date 2018-11-28
*/
package com.interapi.app.modular.model;

import com.interapi.app.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class RulesTab extends BaseModel implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 表单项ID
     */
    private Long formItemId;

    /**
     * 验证规则类型
     */
    private String rulesType;

    /**
     * 验证规则类型名称
     */
    private String rulesTypeName;

    /**
     * 必填标识
     */
    private String required;

    /**
     * 验证信息
     */
    private String message;

    /**
     * 触发方式
     */
    private String triggerName;

    /**
     * 验证格式类型
     */
    private String typeId;

    /**
     * 最小值
     */
    private Integer min;

    /**
     * 最大值
     */
    private Integer max;

    /**
     * 长度相等值
     */
    private Integer len;

    /**
     * 自定义验证函数
     */
    private String validator;

    /**
     * 注销标识
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
     * rules_tab
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

    public String getRulesType() {
        return rulesType;
    }

    public void setRulesType(String rulesType) {
        this.rulesType = rulesType == null ? null : rulesType.trim();
    }

    public String getRulesTypeName() {
        return rulesTypeName;
    }

    public void setRulesTypeName(String rulesTypeName) {
        this.rulesTypeName = rulesTypeName == null ? null : rulesTypeName.trim();
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required == null ? null : required.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName == null ? null : triggerName.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public String getValidator() {
        return validator;
    }

    public void setValidator(String validator) {
        this.validator = validator == null ? null : validator.trim();
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
     * @mbg.generated 2018-11-28
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", formItemId=").append(formItemId);
        sb.append(", rulesType=").append(rulesType);
        sb.append(", rulesTypeName=").append(rulesTypeName);
        sb.append(", required=").append(required);
        sb.append(", message=").append(message);
        sb.append(", triggerName=").append(triggerName);
        sb.append(", typeId=").append(typeId);
        sb.append(", min=").append(min);
        sb.append(", max=").append(max);
        sb.append(", len=").append(len);
        sb.append(", validator=").append(validator);
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
     * @mbg.generated 2018-11-28
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
        RulesTab other = (RulesTab) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFormItemId() == null ? other.getFormItemId() == null : this.getFormItemId().equals(other.getFormItemId()))
            && (this.getRulesType() == null ? other.getRulesType() == null : this.getRulesType().equals(other.getRulesType()))
            && (this.getRulesTypeName() == null ? other.getRulesTypeName() == null : this.getRulesTypeName().equals(other.getRulesTypeName()))
            && (this.getRequired() == null ? other.getRequired() == null : this.getRequired().equals(other.getRequired()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getTriggerName() == null ? other.getTriggerName() == null : this.getTriggerName().equals(other.getTriggerName()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getMin() == null ? other.getMin() == null : this.getMin().equals(other.getMin()))
            && (this.getMax() == null ? other.getMax() == null : this.getMax().equals(other.getMax()))
            && (this.getLen() == null ? other.getLen() == null : this.getLen().equals(other.getLen()))
            && (this.getValidator() == null ? other.getValidator() == null : this.getValidator().equals(other.getValidator()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()));
    }

    /**
     *
     * @mbg.generated 2018-11-28
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFormItemId() == null) ? 0 : getFormItemId().hashCode());
        result = prime * result + ((getRulesType() == null) ? 0 : getRulesType().hashCode());
        result = prime * result + ((getRulesTypeName() == null) ? 0 : getRulesTypeName().hashCode());
        result = prime * result + ((getRequired() == null) ? 0 : getRequired().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getTriggerName() == null) ? 0 : getTriggerName().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getMin() == null) ? 0 : getMin().hashCode());
        result = prime * result + ((getMax() == null) ? 0 : getMax().hashCode());
        result = prime * result + ((getLen() == null) ? 0 : getLen().hashCode());
        result = prime * result + ((getValidator() == null) ? 0 : getValidator().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }
}