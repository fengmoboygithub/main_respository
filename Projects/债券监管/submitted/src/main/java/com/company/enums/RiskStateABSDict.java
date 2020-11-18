package com.company.enums;

/**
 * 风险状态枚举类
 * @author yangyanchao
 * 违约-0204
 * 高风险-0203
 */
public enum RiskStateABSDict {
	/**
     * 	0204 违约
     */
	EXCHANGEABLEBOND("0204","违约"),

	/**
     * 	0203高风险
     */
	CORPORATE("0203","高风险"),
	
	/**
     * 	空
     */
	EMPTY("","")
    ;
	
	private String code;
	
    private String value;

    RiskStateABSDict(String code, String value) {
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
	public static RiskStateABSDict getEnumsByValue(String value){
		for(RiskStateABSDict enums : RiskStateABSDict.values()){
			if(value.indexOf(enums.getValue()) > -1){
				return enums;
			}
		}
		return EMPTY;
	}
	
	public static void main(String[] args) {
		System.out.println(RiskStateABSDict.getEnumsByValue("").getCode());
		System.out.println(RiskStateABSDict.getEnumsByValue("违约").getCode());
		System.out.println(RiskStateABSDict.getEnumsByValue("高风险").getCode());
	}
}
