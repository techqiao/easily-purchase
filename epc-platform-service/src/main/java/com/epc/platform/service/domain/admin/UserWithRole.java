package com.epc.platform.service.domain.admin;

import java.util.List;

public class UserWithRole extends SysAdminUser {
	
	private static final long serialVersionUID = -5680235862276163462L;
	
	private Long roleId;
	//角色id
	private List<Long> roleIds;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}
	
}