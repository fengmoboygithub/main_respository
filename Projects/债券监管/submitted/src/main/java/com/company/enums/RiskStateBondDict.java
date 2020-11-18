package com.company.enums;

/**
 * 风险状态枚举类
 * @author yangyanchao
 * 违约-0104
 * 高风险-0103
 */
public enum RiskStateBondDict {
	/**
     * 	0104 违约
     */
	EXCHANGEABLEBOND("0104","违约"),

	/**
     * 	0103高风险
     */
	CORPORATE("0103","高风险"),
	
	/**
     * 	空
     */
	EMPTY("","")
    ;
	
	private String code;
	
    private String value;

    RiskStateBondDict(String code, String value) {
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
	public static RiskStateBondDict getEnumsByValue(String value){
		for(RiskStateBondDict enums : RiskStateBondDict.values()){
			if(value.indexOf(enums.getValue()) > -1){
				return enums;
			}
		}
		return EMPTY;
	}
	
	public static void main(String[] args) {
		System.out.println(RiskStateBondDict.getEnumsByValue("").getCode());
		System.out.println(RiskStateBondDict.getEnumsByValue("违约").getCode());
		System.out.println(RiskStateBondDict.getEnumsByValue("高风险").getCode());
	}
}
