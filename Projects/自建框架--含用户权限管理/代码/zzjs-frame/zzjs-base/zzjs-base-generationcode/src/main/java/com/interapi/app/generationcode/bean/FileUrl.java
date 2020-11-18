package com.interapi.app.generationcode.bean;

public class FileUrl {
    private String controllerurl;

    private String serviceurl;
    private String serviceImplurl;
    private String daourl;
    private String beanurl;
    private String exampleurl;
    private String packName;
    private String beanName;
    private String tableName;
    private String cnObjectName;
    private String menuName;
    private String pageSort;
	private String menuSort;

    public String getBeanurl() {
        return beanurl;
    }

    public void setBeanurl(String beanurl) {
        this.beanurl = beanurl;
    }

    public String getControllerurl() {
        return controllerurl;
    }

    public void setControllerurl(String controllerurl) {
        this.controllerurl = controllerurl;
    }

    public String getServiceurl() {
        return serviceurl;
    }

    public void setServiceurl(String serviceurl) {
        this.serviceurl = serviceurl;
    }

    public String getServiceImplurl() {
        return serviceImplurl;
    }

    public void setServiceImplurl(String serviceImplurl) {
        this.serviceImplurl = serviceImplurl;
    }

    public String getDaourl() {
        return daourl;
    }

    public void setDaourl(String daourl) {
        this.daourl = daourl;
    }

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public String getExampleurl() {
		return exampleurl;
	}

	public void setExampleurl(String exampleurl) {
		this.exampleurl = exampleurl;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getCnObjectName() {
		return cnObjectName;
	}

	public void setCnObjectName(String cnObjectName) {
		this.cnObjectName = cnObjectName;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getMenuSort() {
		return menuSort;
	}

	public void setMenuSort(String menuSort) {
		this.menuSort = menuSort;
	}
}
