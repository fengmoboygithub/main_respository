package com.company.enums;

/**
 * 阿里云产品等级枚举类
 * @author yangyanchao
 *
 */
public enum AliProdusLevel {
	/**
     * 	一般不适用
     */
	YES("1","适用"),
	/**
     * 	一般适用
     */
	BYES("2","一般适用"),
	/**
	 * 	一般不适用
	 */
	NO("3","一般不适用"),
	/**
	 * 	未匹配
	 */
	NOMACTH("4","未匹配"),
    ;

	private String code;

    private String value;

    AliProdusLevel(String code, String value) {
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
	public static AliProdusLevel getEnumsByCode(String code){
		for(AliProdusLevel enums : AliProdusLevel.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return YES;
	}
	
	public static void main(String[] args) {
		System.out.println(AliProdusLevel.getEnumsByCode("11").getValue());
	}
}
