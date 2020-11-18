/*
*
* DictionaryTab.java
*                    中证技术公司
* @date 2019-09-06
*/
package com.company.dictionarys.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.company.base.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="数据字典对象",description="数据字典表(DICTIONARY_TAB)")
public class DictionaryTab extends BaseModel implements Serializable {
    /**
     * 主键
     */
	@ApiModelProperty(value="主键",name="id")
    private Long id;

    /**
     * 组id
     */
	@ApiModelProperty(value="组ID",name="dicGroupId")
    private Long dicGroupId;

    /**
     * 字典编码
     */
	@ApiModelProperty(value="字典编码",name="dicKey")
    private String dicKey;

    /**
     * 字典值
     */
	@ApiModelProperty(value="字典值",name="dicValue")
    private String dicValue;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序",name="dicSort")
    private Integer dicSort;
	
    /**
     * 下级列表
     */
	@ApiModelProperty(value="下级列表",name="subList")
	private List<DictionaryTab> subList;

    /**
     * 字典描述
     */
    @ApiModelProperty(value="字典描述",name="dicDesc")
    private String dicDesc;

    /**
     * 注销
     */
    @ApiModelProperty(value="注销",name="isDelete")
    private String isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人ID
     */
    private Long createUser;

    /**
     * 最近修改时间
     */
    private Date updateTime;

    /**
     * 最近修改人ID
     */
    private Long updateUser;

    /**
     * dictionary_tab
     */
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDicGroupId() {
        return dicGroupId;
    }

    public void setDicGroupId(Long dicGroupId) {
        this.dicGroupId = dicGroupId;
    }

    public String getDicKey() {
        return dicKey;
    }

    public void setDicKey(String dicKey) {
        this.dicKey = dicKey == null ? null : dicKey.trim();
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue == null ? null : dicValue.trim();
    }

    public Integer getDicSort() {
        return dicSort;
    }

    public void setDicSort(Integer dicSort) {
        this.dicSort = dicSort;
    }

    public String getDicDesc() {
        return dicDesc;
    }

    public List<DictionaryTab> getSubList() {
		return subList;
	}

	public void setSubList(List<DictionaryTab> subList) {
		this.subList = subList;
	}

	public void setDicDesc(String dicDesc) {
        this.dicDesc = dicDesc == null ? null : dicDesc.trim();
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
     * @mbg.generated 2019-09-06
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dicGroupId=").append(dicGroupId);
        sb.append(", dicKey=").append(dicKey);
        sb.append(", dicValue=").append(dicValue);
        sb.append(", dicSort=").append(dicSort);
        sb.append(", dicDesc=").append(dicDesc);
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
     * @mbg.generated 2019-09-06
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
        DictionaryTab other = (DictionaryTab) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDicGroupId() == null ? other.getDicGroupId() == null : this.getDicGroupId().equals(other.getDicGroupId()))
            && (this.getDicKey() == null ? other.getDicKey() == null : this.getDicKey().equals(other.getDicKey()))
            && (this.getDicValue() == null ? other.getDicValue() == null : this.getDicValue().equals(other.getDicValue()))
            && (this.getDicSort() == null ? other.getDicSort() == null : this.getDicSort().equals(other.getDicSort()))
            && (this.getDicDesc() == null ? other.getDicDesc() == null : this.getDicDesc().equals(other.getDicDesc()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()));
    }

    /**
     *
     * @mbg.generated 2019-09-06
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDicGroupId() == null) ? 0 : getDicGroupId().hashCode());
        result = prime * result + ((getDicKey() == null) ? 0 : getDicKey().hashCode());
        result = prime * result + ((getDicValue() == null) ? 0 : getDicValue().hashCode());
        result = prime * result + ((getDicSort() == null) ? 0 : getDicSort().hashCode());
        result = prime * result + ((getDicDesc() == null) ? 0 : getDicDesc().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }
}