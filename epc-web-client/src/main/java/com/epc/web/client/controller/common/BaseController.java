package com.epc.web.client.controller.common;

import com.alibaba.fastjson.JSONObject;
//import com.epc.administration.facade.admin.handle.LoginHandle;
import com.epc.common.util.CookieUtil;
import com.epc.web.client.controller.loginuser.handle.ClientLoginUser;
import com.github.pagehelper.PageInfo;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 15:46
 * <p>@Author : wjq
 */
public class BaseController {

	protected Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
		Map<String, Object> rspData = new HashMap<>();
		rspData.put("rows", pageInfo.getList());
		rspData.put("total", pageInfo.getTotal());
		return rspData;
	}

	public ClientLoginUser getLoginUser(){
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
		String userJsonStr = CookieUtil.readLoginToken(request);
        ClientLoginUser loginHandle = JSONObject.parseObject(userJsonStr, ClientLoginUser.class);
		return loginHandle;
	}



}
