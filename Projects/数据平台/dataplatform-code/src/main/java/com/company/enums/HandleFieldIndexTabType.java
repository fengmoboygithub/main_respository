package com.company.enums;

/**
 * 字段索引表中控件类型枚举类
 * @author yangyanchao
 *
 */
public enum HandleFieldIndexTabType {
	/**
     * 	普通元素
     */
	PLAIN("0","普通元素"),

	/**
     * 	子项元素
     */
	TUPLESON("1","Tuple子项元素"),
	/**
     * 	多附件
     */
	MULTIPLE("2","多附件"),
	/**
     * 	单附件
     */
	SINGLE("3","单附件"),
	/**
     * 	Tuple父元素
     */
	TUPLEPARENT("4","Tuple父元素")
    ;
	
	private String code;
	
    private String value;

    HandleFieldIndexTabType(String code, String value) {
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
	public static HandleFieldIndexTabType getEnumsByCode(String code){
		for(HandleFieldIndexTabType enums : HandleFieldIndexTabType.values()){
			if(enums.getCode() == code){
				return enums;
			}
		}
		return PLAIN;
	}
}
