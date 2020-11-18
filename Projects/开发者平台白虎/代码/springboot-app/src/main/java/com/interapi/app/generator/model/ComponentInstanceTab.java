/*
*
* ComponentInstanceTab.java
*                    中证技术公司
* @date 2018-09-09
*/
package com.interapi.app.generator.model;

import java.util.Date;

public class ComponentInstanceTab {
    /**
     * 组件实例ID
     */
    private Long id;

    /**
     * 组件ID
     */
    private Long componentid;

    /**
     * 页面ID
     */
    private Long fileid;

    /**
     * 注销标识
     */
    private String isdelete;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 创建人
     */
    private Long createuser;

    /**
     * 最近修改人
     */
    private Date updatetime;

    /**
     * 最近修改时间
     */
    private Long updateuser;

    /**
     * 组件React代码
     */
    private String htmlcode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getComponentid() {
        return componentid;
    }

    public void setComponentid(Long componentid) {
        this.componentid = componentid;
    }

    public Long getFileid() {
        return fileid;
    }

    public void setFileid(Long fileid) {
        this.fileid = fileid;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete == null ? null : isdelete.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Long createuser) {
        this.createuser = createuser;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(Long updateuser) {
        this.updateuser = updateuser;
    }

    public String getHtmlcode() {
        return htmlcode;
    }

    public void setHtmlcode(String htmlcode) {
        this.htmlcode = htmlcode == null ? null : htmlcode.trim();
    }
}