package com.epc.web.service.controller;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luozhixin
 * @date 2018-9-19 19:02:33
 */
public class BaseController {

	protected Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
		Map<String, Object> rspData = new HashMap<>(16);
		rspData.put("rows", pageInfo.getList());
		rspData.put("total", pageInfo.getTotal());
		return rspData;
	}

}
