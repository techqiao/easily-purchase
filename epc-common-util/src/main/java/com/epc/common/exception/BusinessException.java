package com.epc.common.exception;

import com.epc.common.constants.ErrorMessagesEnum;

/**
 * <p>Description : 业务异常
 * <p>Date : 2018-09-12 16:10
 * <p>@Author : wjq
 */
public class BusinessException extends RuntimeException {

    private ErrorMessagesEnum error;

    private static final long serialVersionUID = 1L;

    public BusinessException(ErrorMessagesEnum error){
        super(error.getErrInfo());
        this.error = error;
    }

    public BusinessException(ErrorMessagesEnum error, Throwable t){
        super(t);
        this.error = error;
    }

    public ErrorMessagesEnum getError() {
        return error;
    }

    public void setError(ErrorMessagesEnum error) {
        this.error = error;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
