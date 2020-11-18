package com.company.enums;

/**
 * 流程操作枚举类
 * @author yangyanchao
 *
 */
public enum ProcessNodeOpt {
	/**
     * 	正向
     */
	OBVERSE("1","正向"),
	/**
     * 	逆向
     */
	INVERSE("2","逆向"),
	/**
	 * 	阶段变更
	 */
	CHANGE("4","阶段变更"),
    ;

	private String code;

    private String value;

    ProcessNodeOpt(String code, String value) {
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
	public static ProcessNodeOpt getEnumsByCode(String code){
		for(ProcessNodeOpt enums : ProcessNodeOpt.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return OBVERSE;
	}
	
	public static void main(String[] args) {
		System.out.println(ProcessNodeOpt.getEnumsByCode("11").getValue());
	}
}
