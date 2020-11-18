package com.company.enums;

public enum DirectoryOpinionType {
    /**
     * 	草稿
     */
    DFAFT("0","草稿"),
    /**
     * 	正式
     */
    SUBMIT("1","正式"),
    ;

    private String code;

    private String value;

    DirectoryOpinionType(String code, String value) {
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
    public static DirectoryOpinionType getEnumsByCode(String code){
        for(DirectoryOpinionType enums : DirectoryOpinionType.values()){
            if(enums.getCode().equals(code)){
                return enums;
            }
        }
        return DFAFT;
    }

    public static void main(String[] args) {
        System.out.println(DirectoryOpinionType.DFAFT.getCode());
    }
}
