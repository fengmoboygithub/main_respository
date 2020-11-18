package com.company.enums;

/**
 * 底稿信息表中状态枚举类
 * @author yangyanchao
 *
 */
public enum ManuscriptInfoApply {
	/**
     * 	适用
     */
	YES(1,"适用"),
	/**
     * 	不适用
     */
	NO(2,"不适用"),
    ;

	private Integer code;

    private String value;

    ManuscriptInfoApply(Integer code, String value) {
    	this.code = code;
        this.value = value;
    }
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
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
	public static ManuscriptInfoApply getEnumsByCode(Integer code){
		for(ManuscriptInfoApply enums : ManuscriptInfoApply.values()){
			if(enums.getCode() == code){
				return enums;
			}
		}
		return NO;
	}
	
	public static void main(String[] args) {
		System.out.println(ManuscriptInfoApply.getEnumsByCode(1).getValue());
	}
}
