package com.epc.user.service.common;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Map;

public class BaseResult<T> {

    private Integer code = PageCode.SUCCESS.getCode();
    private String  msg  = PageCode.SUCCESS.getMsg();

    private String  _csrf;
    private T       data;
    private boolean isLogin = false;

    private Map<String, String> fieldErrMsg;

    public BaseResult() {
    }

    public BaseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResult(PageCode pageCode) {
        this.code = pageCode.getCode();
        this.msg = pageCode.getMsg();
    }

    public BaseResult(String _csrf, Integer code, String msg, T data) {
        this._csrf = _csrf;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String get_csrf() {
        return _csrf;
    }

    public void set_csrf(String _csrf) {
        this._csrf = _csrf;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public Map<String, String> getFieldErrMsg() {
        return fieldErrMsg;
    }

    public void setFieldErrMsg(Map<String, String> fieldErrMsg) {
        this.fieldErrMsg = fieldErrMsg;
    }

    public void setPageCode(PageCode code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

     public void setBizCode(BizErrorCode code) {
     this.code = code.getCode();
     this.msg = code.getDesc();
     }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("_csrf",
                                                _csrf).append("code",
                                                              code).append("msg",
                                                                           msg).append("data",
                                                                                       data).append("isLogin",
                                                                                                    isLogin).append("fieldErrMsg",
                                                                                                                    fieldErrMsg).toString();
    }
}
