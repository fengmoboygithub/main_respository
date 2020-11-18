package com.company.enums;

/**
 * 底稿es中版本枚举类
 * @author yangyanchao
 *
 */
public enum ManuscriptInfoEsVersion {
	/**
     * 	历史版本
     */
	HISTORY("0","历史版本"),
	/**
     * 	当前版本
     */
	CURRENT("1","当前版本"),
    ;

	private String code;

    private String value;

    ManuscriptInfoEsVersion(String code, String value) {
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
	public static ManuscriptInfoEsVersion getEnumsByCode(String code){
		for(ManuscriptInfoEsVersion enums : ManuscriptInfoEsVersion.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return CURRENT;
	}
	
	public static void main(String[] args) {
		System.out.println(ManuscriptInfoEsVersion.getEnumsByCode("11").getValue());
	}
}
