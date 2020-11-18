package com.company.enums;

/**
 * 项目目录展示数中类型枚举类
 * @author yangyanchao
 *
 */
public enum ProjectDirectoryType {
	/**
	 * 	根目录
	 */
	ROOT("root","根目录"),
	/**
     * 	目录
     */
	DIR("dir","目录"),
	/**
     * 	文件
     */
	FILE("file","底稿文件"),
    ;

	private String code;

    private String value;

    ProjectDirectoryType(String code, String value) {
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
	public static ProjectDirectoryType getEnumsByCode(String code){
		for(ProjectDirectoryType enums : ProjectDirectoryType.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return DIR;
	}
	
	public static void main(String[] args) {
		System.out.println(ProjectDirectoryType.getEnumsByCode("dir").getValue());
	}
}
