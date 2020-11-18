package com.company.enums;

/**
 * 底稿es中保存模式
 * @author yangyanchao
 *
 */
public enum ManuscriptInfoEsMode {
	/**
     * 	新增
     */
	ADD("0","新增"),
	/**
     * 	更新
     */
	UPDATE("1","更新"),
    ;

	private String code;

    private String value;

    ManuscriptInfoEsMode(String code, String value) {
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
	public static ManuscriptInfoEsMode getEnumsByCode(String code){
		for(ManuscriptInfoEsMode enums : ManuscriptInfoEsMode.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return ADD;
	}
	
	public static void main(String[] args) {
		System.out.println(ManuscriptInfoEsMode.getEnumsByCode("11").getValue());
	}
}
