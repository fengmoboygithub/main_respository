package com.company.enums;

/**
 * 报送错误枚举类
 * @author yangyanchao
 *
 */
public enum SubmissionError {
	/**
     * 	该报告已上报过，请勿重复上报
     */
	REPEAT(1000,"该报告已上报过，请勿重复上报"),

	/**
     * 	文件名中的机构号与压缩文件中的不一致
     */
	FILEANDZIPATYPISM(1001,"文件名中的机构号与压缩文件中的不一致"),
	/**
     * 	该报告报送记录号中机构号与文件名中的不一致
     */
	FILEANDSUBMISSIONNUMATYPISM(1002,"该报告报送记录号中机构号与文件名中的不一致"),
    ;
	
	private Integer code;
	
    private String value;

    SubmissionError(Integer code, String value) {
    	this.code = code;
        this.value = value;
    }
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
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
	public static SubmissionError getEnumsByCode(Integer code){
		for(SubmissionError enums : SubmissionError.values()){
			if(enums.getCode() == code){
				return enums;
			}
		}
		return REPEAT;
	}
	
	public static void main(String[] args) {
		System.out.println(SubmissionError.getEnumsByCode(11).getValue());
	}
}
