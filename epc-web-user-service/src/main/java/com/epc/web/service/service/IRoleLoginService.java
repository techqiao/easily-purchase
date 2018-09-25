package com.epc.web.service.service;

import com.epc.common.Result;
import com.epc.web.facade.loginuser.dto.LoginUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author winlin
 */
public interface IRoleLoginService {
     int OPERRATOR=1;
     int AGENCY=2;
     int SUPPLIER=3;
     int PURCHASER=4;

     /**
      *@param: 页面登录信息传入后端
      *@return: 返回详细信息
      *@date:2018/9/18
      */
     Result login (LoginUser user);

}
