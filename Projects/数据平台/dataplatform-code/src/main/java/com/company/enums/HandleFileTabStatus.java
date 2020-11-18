package com.company.enums;

/**
 * 处理文件表中状态枚举类
 * @author yangyanchao
 *
 */
public enum HandleFileTabStatus {
	/**
     * 	已入库
     */
	WAREHOUSING(10,"已入库"),

	/**
     * 	已校验
     */
	VERIFICATION(20,"已校验"),
	/**
     * 	已上报
     */
	SUBMITTED(30,"已上报"),
	/**
     * 	已应答
     */
	RESPOND(40,"已应答")
    ;
	
	private Integer code;
	
    private String value;

    HandleFileTabStatus(Integer code, String value) {
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
	public static HandleFileTabStatus getEnumsByCode(Integer code){
		for(HandleFileTabStatus enums : HandleFileTabStatus.values()){
			if(enums.getCode() == code){
				return enums;
			}
		}
		return WAREHOUSING;
	}
	
	public static void main(String[] args) {
		System.out.println(HandleFileTabStatus.getEnumsByCode(10).getValue());
		System.out.println(HandleFileTabStatus.RESPOND.getCode());
	}
}
