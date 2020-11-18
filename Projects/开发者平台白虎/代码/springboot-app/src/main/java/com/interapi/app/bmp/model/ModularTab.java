/*
*
* ModularTab.java
*                    中证技术公司
* @date 2018-09-18
*/
package com.interapi.app.bmp.model;

import java.util.Date;

public class ModularTab {
    /**
     * 主键
     */
    private Long id;

    /**
     * 模块名称
     */
    private String name;

    /**
     * 命名空间 例如：用户模块为UserTab
     */
    private String namespace;

    /**
     * 映射表名 例如：用户模块为user_tab
     */
    private String maping;

    /**
     * 所属菜单
     */
    private Long menuId;

    /**
     * 所属数据源
     */
    private Long dataSourceId;

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

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace == null ? null : namespace.trim();
    }

    public String getMaping() {
        return maping;
    }

    public void setMaping(String maping) {
        this.maping = maping == null ? null : maping.trim();
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(Long dataSourceId) {
        this.dataSourceId = dataSourceId;
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