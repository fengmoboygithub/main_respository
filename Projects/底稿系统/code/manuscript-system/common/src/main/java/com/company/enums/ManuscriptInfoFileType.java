package com.company.enums;

/**
 * 底稿信息表中文件类型枚举类
 * @author yangyanchao
 *
 */
public enum ManuscriptInfoFileType {
	/**
     * 	PDF
     */
	PDF("11","PDF"),
	/**
	 * 	音频
	 */
	AUDIO("12","音频"),
	/**
	 * 	视频
	 */
	VIDEO("13","视频"),
    ;

	private String code;

    private String value;

    ManuscriptInfoFileType(String code, String value) {
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
	public static ManuscriptInfoFileType getEnumsByCode(String code){
		for(ManuscriptInfoFileType enums : ManuscriptInfoFileType.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return PDF;
	}
	
	public static void main(String[] args) {
		System.out.println(ManuscriptInfoFileType.getEnumsByCode("11").getValue());
	}
}
