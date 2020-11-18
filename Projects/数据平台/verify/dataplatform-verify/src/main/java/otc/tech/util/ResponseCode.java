package otc.tech.util;

/**
 * 处理响应状态
 * 
 */
public enum ResponseCode{
    /** 用户状态 */
    SUCCESS(0, "操作成功"), 
    paramErr(1, "参数异常"),
    optErr(2, "操作异常"), 
    sysErr(3 ,"系统异常");

    private Integer code;
    private String msg;

    ResponseCode(Integer code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

    
}
