package com.epc.platform.service.domain.admin;

import java.util.List;

public class RoleWithSource extends SysAdminRole {

	private static final long serialVersionUID = 2013847071068967187L;
	
	private Long menuId;

	/**
	 * 资源菜单列表
	 */
	private List<Long> menuIds;

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public List<Long> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<Long> menuIds) {
		this.menuIds = menuIds;
	}
	
	

}
