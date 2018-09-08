package com.epc.user.service.common;

public enum PageCode {
    SUCCESS(200, "成功"),
    SERVER_EXCEPTION(500, "服务端异常"),
    UN_LOGIN(401, "未登陆不能使用"),

    CSRF_TOKEN_ERROR(403, "CSRF TOKEN不正确"),

    FIELD_FAIL(100, "字段信息不正确"),
    IMG_FAIL(110, "图片验证码校验失败"),
    MAX_FAIL(120, "登陆失败次数过多"),
    LOGIN_FAIL(130, "登陆失败"),
    AUTH_CODE_FAIL(140, "短信验证码失败"),
    AUTH_CODE_EXPIRE(150, "短信验证码失效"),
    REGISTER_USER_EXISTED(160, "注册用户存在。"),
    DATABASE_CHANGE(170, "数据库已发生改变。"),
    ;

    PageCode(
            int code, String
            msg)

    {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
