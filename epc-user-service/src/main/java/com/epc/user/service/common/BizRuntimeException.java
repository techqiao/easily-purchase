/*
 * Copyright 2015 linglingqi Group Holding Ltd.
 *
 * 
 */
package com.epc.user.service.common;

public class BizRuntimeException extends RuntimeException {

    //错误码
    private BizErrorCode errorCode;

    public BizRuntimeException(BizErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public BizRuntimeException(BizErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BizRuntimeException(BizErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public BizRuntimeException(BizErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }


    public BizErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(BizErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
