package com.epc.common;


import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018/9/9/009 18:08
 * <p>@author : wjq
 */
public enum ResultCode implements Serializable {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT"),
    SERVICE_EXCEPTION(3,"服务异常");

    private final int code;
    private final String desc;
    private static final long serialVersionUID = 1L;

    ResultCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
