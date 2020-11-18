package com.company.enums;

/**
 * 底稿信息表中状态枚举类
 * @author yangyanchao
 *
 */
public enum ManuscriptInfoStatus {
	/**
     * 	未阅
     */
	NOTREAD("11","未阅"),
	/**
     * 	已阅
     */
	READ("12","已阅"),
    ;
	
	private String code;
	
    private String value;

    ManuscriptInfoStatus(String code, String value) {
    	this.code = code;
        this.value = value;
    }
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * 	根据code值返回枚举类 若没有该code值则返回无参枚举
	 * @param code
	 * @return
	 */
	public static ManuscriptInfoStatus getEnumsByCode(String code){
		for(ManuscriptInfoStatus enums : ManuscriptInfoStatus.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return NOTREAD;
	}
	
	public static void main(String[] args) {
		System.out.println(ManuscriptInfoStatus.getEnumsByCode("11").getValue());
	}
}
