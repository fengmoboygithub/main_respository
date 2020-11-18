package com.company.enums;

/**
 * 项目信息表中状态枚举类
 * @author yangyanchao
 *
 */
public enum ProjectInfoStatus {
	/**
	 * 	正常
	 */
	NORMAL("11","正常"),
	/**
     * 	暂停
     */
	SUSPEND("12","暂停"),
	/**
     * 	异常终止
     */
	ABEND("13","异常终止"),
	/**
	 * 	终止
	 */
	STOP("14","终止"),
    ;

	private String code;

    private String value;

    ProjectInfoStatus(String code, String value) {
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
	public static ProjectInfoStatus getEnumsByCode(String code){
		for(ProjectInfoStatus enums : ProjectInfoStatus.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return NORMAL;
	}
	
	public static void main(String[] args) {
		System.out.println(ProjectInfoStatus.getEnumsByCode("11").getValue());
	}
}
