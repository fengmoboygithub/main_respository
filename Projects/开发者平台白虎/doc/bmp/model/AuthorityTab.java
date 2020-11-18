/*
*
* AuthorityTab.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AuthorityTab  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5232095061876139996L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 标识
     */
    private String flag;
    
    /**
     * 接口资源列表
     */
    private List<ResourceTab> resourceTabList;
    
    /**
     * 菜单页面列表
     */
    private List<PageTab> pageTabList;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public List<ResourceTab> getResourceTabList() {
		return resourceTabList;
	}

	public void setResourceTabList(List<ResourceTab> resourceTabList) {
		this.resourceTabList = resourceTabList;
	}

	public List<PageTab> getPageTabList() {
		return pageTabList;
	}

	public void setPageTabList(List<PageTab> pageTabList) {
		this.pageTabList = pageTabList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
}