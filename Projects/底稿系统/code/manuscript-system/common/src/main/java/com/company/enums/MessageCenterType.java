package com.company.enums;

/**
 * 消息中心表中消息类型枚举类
 * @author yangyanchao
 *
 */
public enum MessageCenterType {
	/**
     * 	系统
     */
	SYSTEM("1","系统"),
	/**
     * 	普通
     */
	GENERAL("2","普通")
    ;

	private String code;

    private String value;

    MessageCenterType(String code, String value) {
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
	public static MessageCenterType getEnumsByCode(String code){
		for(MessageCenterType enums : MessageCenterType.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return GENERAL;
	}
	
	public static void main(String[] args) {
		System.out.println(MessageCenterType.getEnumsByCode("1").getValue());
	}
}
