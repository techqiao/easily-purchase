package com.epc.common;

import com.epc.common.constants.ErrorMessagesEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018/9/9/009 18:07
 * <p>@author : wjq
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "返回数据（Json）对象", description = "接口返回数据对象", discriminator = "吴江桥")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 9219485591159741586L;

    @ApiModelProperty(value = "返回码[0:表示成功; 1表示失败]", example = "1")
    private Integer code;
    @ApiModelProperty(value = "前端页面弹窗内容|该字段为前端弹 窗内容", example = "新增成功！")
    private String msg;
    @ApiModelProperty(value = "返回的数据|该字段为前端渲染数据对象", dataType = "Json")
    private T data;

    public Result() {
    }

    private Result(Integer code){
        this.code = code;
    }
    private Result(Integer code,T data){
        this.code = code;
        this.data = data;
    }

    private Result(Integer code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.code.equals(ResultCode.SUCCESS.getCode());
    }

    public Integer getcode(){
        return code;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }

    public Result setCode(Integer code) {
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

    public static <T> Result<T> error(Integer errorCode,String errorMessage){
        return new Result<T>(errorCode,errorMessage);
    }

    public static <T> Result<T> hystrixError(){
        return new Result<T>(ResultCode.SERVICE_EXCEPTION.getCode(),ResultCode.SERVICE_EXCEPTION.getDesc());
    }

    public static <T> Result<T> error(ErrorMessagesEnum errorMessagesEnum){
        return new Result<T>(errorMessagesEnum.getErrCode(),errorMessagesEnum.getErrInfo());
    }

}
