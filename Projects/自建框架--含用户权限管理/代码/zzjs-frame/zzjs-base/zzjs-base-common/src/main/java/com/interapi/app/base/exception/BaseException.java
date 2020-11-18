package com.interapi.app.base.exception;

/**
 * @author yangyanchao
 *
 */
public class BaseException extends Exception {

    private static final long serialVersionUID = 1L;


    protected String          errorCode;
    protected Exception       errorCause;
    protected String          message;
    /**
     * 
     * 创建一个新的实例 BaseException
     *
     * @param errorCode
     */
    public BaseException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
        
    }

    /**
     * 
     * 创建一个新的实例 BaseException
     *
     * @param e
     */
    public BaseException(Exception e) {
        super(e);
        this.errorCause = e;
    }
    /**
     * 
     * 创建一个新的实例 BaseException
     *
     * @param errorCode
     * @param errorMessage
     */
    public BaseException(String errorCode, String errorMessage)
    {
      this.errorCode = errorCode;
      this.message = errorMessage;
    }

    /**
     * 
     * 创建一个新的实例 BaseException
     *
     * @param errorCode
     * @param e
     */
    public BaseException(String errorCode, Exception e) {
        super(errorCode, e);
        this.errorCode = errorCode;
        this.errorCause = e;
    }
    public String getMessage()
    {
      return this.message;
    }
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Exception getErrorCause() {
        return errorCause;
    }

    public void setErrorCause(Exception errorCause) {
        this.errorCause = errorCause;
    }
}
