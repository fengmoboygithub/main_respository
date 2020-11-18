package com.company.enums;

/**
 * 流程节点类型枚举类
 * @author yangyanchao
 *
 */
public enum ProcessNodeType {
	/**
     * 	开始
     */
	START("1","默认"),
	/**
     * 	普通
     */
	PLAIN("2","普通"),
	/**
	 * 	结束
	 */
	END("3","结束"),
    ;

	private String code;

    private String value;

    ProcessNodeType(String code, String value) {
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
	public static ProcessNodeType getEnumsByCode(String code){
		for(ProcessNodeType enums : ProcessNodeType.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return START;
	}
	
	public static void main(String[] args) {
		System.out.println(ProcessNodeType.getEnumsByCode("11").getValue());
	}
}
