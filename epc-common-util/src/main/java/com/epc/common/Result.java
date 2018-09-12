package com.epc.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018/9/9/009 18:07
 * <p>@author : wjq
 */
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 9219485591159741586L;

    private int code;
    private String msg;
    private T data;

    private Result(int code){
        this.code = code;
    }
    private Result(int code,T data){
        this.code = code;
        this.data = data;
    }

    private Result(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.code == ResultCode.SUCCESS.getCode();
    }

    public int getcode(){
        return code;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> Result<T> success(){
        return new Result<T>(ResultCode.SUCCESS.getCode());
    }

    public static <T> Result<T> success(String msg){
        return new Result<T>(ResultCode.SUCCESS.getCode(),msg);
    }

    public static <T> Result<T> success(T data){
        return new Result<T>(ResultCode.SUCCESS.getCode(),data);
    }

    public static <T> Result<T> success(String msg,T data){
        return new Result<T>(ResultCode.SUCCESS.getCode(),msg,data);
    }


    public static <T> Result<T> error(){
        return new Result<T>(ResultCode.ERROR.getCode(),ResultCode.ERROR.getDesc());
    }


    public static <T> Result<T> error(String errorMessage){
        return new Result<T>(ResultCode.ERROR.getCode(),errorMessage);
    }

    public static <T> Result<T> error(int errorCode,String errorMessage){
        return new Result<T>(errorCode,errorMessage);
    }

    public static <T> Result<T> hystrixError(){
        return new Result<T>(ResultCode.SERVICE_EXCEPTION.getCode(),ResultCode.SERVICE_EXCEPTION.getDesc());
    }

}