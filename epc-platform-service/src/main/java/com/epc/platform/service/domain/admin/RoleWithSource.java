package com.epc.platform.service.domain.admin;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RoleWithSource extends SysAdminRole {

	private static final long serialVersionUID = 2013847071068967187L;
	
	private Long menuId;

	private String name;

	private Date createAt;

	private Integer isDeleted;

	/**
	 * 资源菜单列表
	 */
	private List<Long> menuIds;


	

}
