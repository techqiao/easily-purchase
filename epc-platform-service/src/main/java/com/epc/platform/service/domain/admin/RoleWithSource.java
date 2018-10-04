package com.epc.platform.service.domain.admin;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RoleWithSource extends SysAdminRole {

	private static final long serialVersionUID = 2013847071068967187L;

	/**
	 * 菜单id
	 */
	private Long menuId;

	/**
	 * 菜单名
	 */
	private String name;

	/**
	 * 创建时间
	 */
	private Date createAt;

	/**
	 * 是否删除 0 展示 1 删除
	 */
	private Integer isDeleted;

	/**
	 * 资源菜单列表
	 */
	private List<Long> menuIds;


	

}
