package com.epc.common.constants;


/**
 * <p>Description : 常量
 * <p>Date : 2018-09-12 16:17
 * <p>@Author : wjq
 */
public enum ErrorMessagesEnum {
    
    HTTPCLIENT_ERROR("HTTPCLIENT_ERROR","http链接失败"),
    NOT_AUTHORIZED("401","身份验证失败"),
    LOGIN_USER_LOGOUT_ERROR("LOGIN_USER_LOGOUT_ERROR","登出失败"),
	LOGIN_NAME_OR_PSW_MISTAKE("LoginName or psw mistake","登录名或密码错误"),
	LOGINNAME_DOES_NOT_EXIST("LoginName does not exist","登录账号不存在"),
	LOGINNAME_EXIST("LoginName  exist","账号已存在"),
	LOGINNAME_DISABLED("Has been disabled, please contact the administrator","已禁用，请联系管理员"),
	PASSWORD_ERROR("Password error","密码错误"),
	LOGIN_USER_LOGIN_ERROR("Login user login error","登陆异常"),
	ORIGINAL_PASSWORD_INPUT_ERROR("Original password input error","原始密码输入错误"),
    FAILURE("Operation failed","操作失败"),
    INSERT_FAILURE("Increase failed","增加失败"),
    UPDATE_FAILURE("Update failed","更改失败"),
    SELECT_FAILURE("Search failed","查询失败"),
    DELETE_FAILURE("Delete failed","删除失败"),
    CHANGE_FAILURE("Switch views","转换失败"),
    COOKIE_SEARCH_FAILUE("Cookie search failed","cookie查询失败"),
    INSTANCE_NOT_EXIST("Instance not exist","对象为空"),
    CATCODE_IS_EXIST("CATCODE_IS_EXIST","编码已存在"),
    ID_ILLEAGAL("ID illeagal","ID非法"),
    PARAMETER_IS_NULL("Parameter list is empty","参数列表为空"),
    INCOMPLETE_PARAMETER("Incomplete parameter","参数不全"),
    RECORD_IS_NULL("Record is null","数据不存在"),
    LOGINNAME_NUMBER_EXIST("LoginName number exist","账号已存在"),
    REOCRD_IS_DELETE("REOCRD_IS_DELETE","数据已删除"),
    FILE_UPLOAD_ERROR("FILE_UPLOAD_ERROR","文件上传失败"),
    IDENTIFYING_CODE_SEND_ERROR("IDENTIFYING_CODE_SEND_ERROR","验证码发送失败"),
    FILE_EMPTY("FILE_EMPTY","无文件信息"),
    BANKCARD_NO_IS_EXIST("BANKCARD_NO_IS_EXIST","银行卡号已添加"),
    ;
    private final String errCode;
    private final String errInfo;
    
    ErrorMessagesEnum(String errCode, String errInfo){
        this.errInfo = errInfo;
        this.errCode = errCode;
    }

	public String getErrCode() {
		return errCode;
	}

	public String getErrInfo() {
		return errInfo;
	}

    
    
}
