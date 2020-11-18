package com.interapi.app.generationcode.bean;

public class FileUrl {
    private String controllerurl;

    private String serviceurl;
    private String serviceImplurl;
    private String daourl;
    private String beanurl;
    private String exampleurl;
    private String packName;

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
}
