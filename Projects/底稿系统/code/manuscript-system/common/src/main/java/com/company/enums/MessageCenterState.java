package com.company.enums;

/**
 * 消息中心表中消息状态枚举类
 * @author yangyanchao
 *
 */
public enum MessageCenterState {
	/**
     * 	草稿
     */
	DRAFT("1","草稿"),
	/**
     * 	发布
     */
	PUBLISH("2","发布"),
    ;
	private String code;

    private String value;

    MessageCenterState(String code, String value) {
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
	public static MessageCenterState getEnumsByCode(String code){
		for(MessageCenterState enums : MessageCenterState.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return DRAFT;
	}
	
	public static void main(String[] args) {
		System.out.println(MessageCenterState.getEnumsByCode("1").getValue());
	}
}
