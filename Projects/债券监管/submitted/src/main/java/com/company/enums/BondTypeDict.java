package com.company.enums;

/**
 * 债券类型枚举类
 * @author yangyanchao
 * 0104 可交换债券
 * 0101 普通公司债
 */
public enum BondTypeDict {
	/**
     * 	0104 可交换债券
     */
	EXCHANGEABLEBOND("0104","可交换债券"),

	/**
     * 	0101 普通公司债
     */
	CORPORATE("0101","普通公司债"),
	
	/**
     * 	空
     */
	EMPTY("","")
    ;
	
	private String code;
	
    private String value;

    BondTypeDict(String code, String value) {
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
	public static BondTypeDict getEnumsByValue(String value){
		if("可交换债券".equals(value)){
			return EXCHANGEABLEBOND;
		} else {
			return CORPORATE;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(BondTypeDict.getEnumsByValue("").getCode());
		System.out.println(BondTypeDict.getEnumsByValue("普通公司债").getCode());
		System.out.println(BondTypeDict.getEnumsByValue("可交换债券").getCode());
	}
}
