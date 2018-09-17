package com.epc.platform.service.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.epc.common.util.CookieUtil;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.platform.service.domain.admin.SysAdminUser;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

	protected Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
		Map<String, Object> rspData = new HashMap<>();
		rspData.put("rows", pageInfo.getList());
		rspData.put("total", pageInfo.getTotal());
		return rspData;
	}

	public SysAdminUser getCurrentUser(HttpServletRequest httpServletRequest) {
		String loginToken = CookieUtil.readLoginToken(httpServletRequest);
		String userJsonStr = RedisShardedPoolUtil.get(loginToken);
		return JSONObject.parseObject(userJsonStr, SysAdminUser.class);
	}
}
