package com.company.enums;

/**
 * 企业性质枚举类
 * 中央国企-01
 * 地方国企-02
 * 外商独资-04
 * 民企-03
 * 中外合资-05
 * 中外合作-06
 * @author yangyanchao
 *
 */
public enum NatureDict {
	/**
     * 	中央国企-01
     */
	ONE("01","中央国企"),

	/**
     * 	地方国企-02
     */
	TWO("02","地方国企"),
	
	/**
     * 	外商独资-04
     */
	FOUR("04","外商独资"),

	/**
     * 	民企-03
     */
	THREE("03","民企"),
	
	/**
     * 	中外合资-05
     */
	FIVE("05","中外合资"),
	
	/**
     * 	中外合作-06
     */
	SIX("06","中外合作"),
	
	/**
     * 	空
     */
	EMPTY("","")
    ;
	
	private String code;
	
    private String value;

    NatureDict(String code, String value) {
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
	public static NatureDict getEnumsByValue(String value){
		for(NatureDict enums : NatureDict.values()){
			if(value.indexOf(enums.getValue()) > -1){
				return enums;
			}
		}
		return EMPTY;
	}
	
	public static void main(String[] args) {
		System.out.println(NatureDict.getEnumsByValue("").getCode());
		System.out.println(NatureDict.getEnumsByValue("民企").getCode());
		System.out.println(NatureDict.getEnumsByValue("中外合作").getCode());
	}
}
