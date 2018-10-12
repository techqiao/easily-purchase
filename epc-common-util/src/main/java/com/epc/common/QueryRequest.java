package com.epc.common;

import com.github.pagehelper.PageInfo;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class QueryRequest implements Serializable {

	protected Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
		Map<String, Object> rspData = new HashMap<>();
		rspData.put("rows", pageInfo.getList());
		rspData.put("total", pageInfo.getTotal());
		return rspData;
	}
	private static final long serialVersionUID = -4869594085374385813L;

	private int pageSize;
	private int pageNum;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("pageSize", pageSize)
				.add("pageNum", pageNum)
				.toString();
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

}
