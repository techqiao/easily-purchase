package com.epc.web.client.controller.common;

import com.github.pagehelper.PageInfo;

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
}
