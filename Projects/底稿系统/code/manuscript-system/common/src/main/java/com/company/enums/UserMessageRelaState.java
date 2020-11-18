package com.company.enums;

/**
 * 用户与消息关系中用户对消息操作状态枚举类
 * @author yangyanchao
 *
 */
public enum UserMessageRelaState {
	/**
     * 	未读
     */
	UNREAD("1","未读"),
	/**
     * 	已读
     */
	READ("2","已读"),
	/**
	 * 	回收站
	 */
	RESTORED("3","回收站"),
    ;

	private String code;

    private String value;

    UserMessageRelaState(String code, String value) {
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
	public static UserMessageRelaState getEnumsByCode(String code){
		for(UserMessageRelaState enums : UserMessageRelaState.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return UNREAD;
	}
	
	public static void main(String[] args) {
		System.out.println(UserMessageRelaState.getEnumsByCode("1").getValue());
	}
}
