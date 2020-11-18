package com.company.enums;

/**
 * 项目目录表中状态枚举类
 * @author yangyanchao
 *
 */
public enum ProjectDirectoryStatus {
	/**
     * 	已通过
     */
	ADOPT("11","已通过"),
	/**
     * 	未通过
     */
	NOADOPT("12","未通过"),
    ;
	
	private String code;
	
    private String value;

    ProjectDirectoryStatus(String code, String value) {
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
	public static ProjectDirectoryStatus getEnumsByCode(String code){
		for(ProjectDirectoryStatus enums : ProjectDirectoryStatus.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return ADOPT;
	}
	
	public static void main(String[] args) {
		System.out.println(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
	}
}
