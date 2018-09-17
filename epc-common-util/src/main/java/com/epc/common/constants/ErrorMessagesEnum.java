package com.epc.common.constants;


/**
 * <p>Description : 常量
 * <p>Date : 2018-09-12 16:17
 * <p>@Author : wjq
 */
public enum ErrorMessagesEnum {
    
    HTTPCLIENT_ERROR(10001,"http链接失败"),
    NOT_AUTHORIZED(1002,"身份验证失败"),
    LOGIN_USER_LOGOUT_ERROR(1003,"登出失败"),
	LOGIN_NAME_OR_PSW_MISTAKE(1004,"登录名或密码错误"),
	LOGINNAME_DOES_NOT_EXIST(10005,"登录账号不存在"),
	LOGINNAME_EXIST(1006,"账号已存在"),
	LOGINNAME_DISABLED(1007,"已禁用，请联系管理员"),
	PASSWORD_ERROR(1008,"密码错误"),
	LOGIN_USER_LOGIN_ERROR(1009,"登陆异常"),
	ORIGINAL_PASSWORD_INPUT_ERROR(1010,"原始密码输入错误"),
    FAILURE(1011,"操作失败"),
    INSERT_FAILURE(1012,"增加失败"),
    UPDATE_FAILURE(1013,"更改失败"),
    SELECT_FAILURE(1014,"查询失败"),
    DELETE_FAILURE(1015,"删除失败"),
    CHANGE_FAILURE(1016,"转换失败"),
    COOKIE_SEARCH_FAILUE(1017,"cookie查询失败"),
    INSTANCE_NOT_EXIST(1018,"对象为空"),
    CATCODE_IS_EXIST(1019,"编码已存在"),
    ID_ILLEAGAL(1020,"ID非法"),
    PARAMETER_IS_NULL(1021,"参数列表为空"),
    INCOMPLETE_PARAMETER(1022,"参数不全"),
    RECORD_IS_NULL(1023,"数据不存在"),
    LOGINNAME_NUMBER_EXIST(1024,"账号已存在"),
    REOCRD_IS_DELETE(1025,"数据已删除"),
    FILE_UPLOAD_ERROR(1026,"文件上传失败"),
    IDENTIFYING_CODE_SEND_ERROR(1027,"验证码发送失败"),
    FILE_EMPTY(1028,"无文件信息"),
    BANKCARD_NO_IS_EXIST(1029,"银行卡号已添加"),
    ;
    private final Integer errCode;
    private final String errInfo;
    
    ErrorMessagesEnum(Integer errCode, String errInfo){
        this.errInfo = errInfo;
        this.errCode = errCode;
    }

	public Integer getErrCode() {
		return errCode;
	}

	public String getErrInfo() {
		return errInfo;
	}

    
    
}
