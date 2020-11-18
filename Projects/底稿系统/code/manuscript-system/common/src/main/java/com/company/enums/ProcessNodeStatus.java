package com.company.enums;

/**
 * 流程节点状态码枚举类
 * @author yangyanchao
 *
 */
public enum ProcessNodeStatus {
	/**
     * 	默认
     */
	DEFAULT("1","默认"),
	/**
     * 	结束节点的状态码
     */
	END("9","结束"),
    ;

	private String code;

    private String value;

    ProcessNodeStatus(String code, String value) {
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
	public static ProcessNodeStatus getEnumsByCode(String code){
		for(ProcessNodeStatus enums : ProcessNodeStatus.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return DEFAULT;
	}
	
	public static void main(String[] args) {
		System.out.println(ProcessNodeStatus.getEnumsByCode("11").getValue());
	}
}
