package com.company.enums;

/**
 * 处理明细表中状态枚举类
 * @author yangyanchao
 *
 */
public enum HandleDetailTabStatus {
	/**
     * 	已入库
     */
	WAREHOUSING(11,"已入库"),

	/**
     * 	校验通过
     */
	VERIFICATIONSUCCESS(21,"校验通过"),
	/**
     * 	校验未通过
     */
	VERIFICATIONERROR(22,"校验未通过"),
	/**
     * 	上报成功
     */
	SUBMITTEDSUCCESS(31,"上报成功"),
	/**
     * 	上报失败
     */
	SUBMITTEDERROR(32,"上报失败")
    ;
	
	private Integer code;
	
    private String value;

    HandleDetailTabStatus(Integer code, String value) {
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
	public static HandleDetailTabStatus getEnumsByCode(Integer code){
		for(HandleDetailTabStatus enums : HandleDetailTabStatus.values()){
			if(enums.getCode() == code){
				return enums;
			}
		}
		return WAREHOUSING;
	}
	
	public static void main(String[] args) {
		System.out.println(HandleDetailTabStatus.getEnumsByCode(11).getValue());
	}
}
