package com.company.enums;

/**
 * 数据权限返回值对应查询字段枚举类
 * @author zhujiang
 */
public enum DataPermission {
    /**
     * 	已通过
     */
    PROJECT("project","projectId"),
    /**
     * 	未通过
     */
    DIRECTORY("directory","directoryId"),
    ;

    private String code;

    private String value;

    DataPermission(String code, String value) {
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
    public static DataPermission getEnumsByCode(String code){
        for(DataPermission enums : DataPermission.values()){
            if(enums.getCode().equals(code)){
                return enums;
            }
        }
        return PROJECT;
    }

    public static void main(String[] args) {
        System.out.println(DataPermission.getEnumsByCode("project").getValue());
    }
}
