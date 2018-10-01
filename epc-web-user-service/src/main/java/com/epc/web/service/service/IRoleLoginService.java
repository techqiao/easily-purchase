package com.epc.web.service.service;

import com.epc.common.Result;
import com.epc.web.facade.loginuser.dto.LoginUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author winlin
 */
public interface IRoleLoginService {
     //运营商
     int OPERRATOR=1;
     //代理机构
     int AGENCY=2;
     //供应商
     int SUPPLIER=3;
     //采购人
     int PURCHASER=4;
     //评标专家
     int EXPERT=5;

     /**
      *@param: 页面登录信息传入后端
      *@return: 返回详细信息
      *@date:2018/9/18
      */
     Result login (LoginUser user);

}
