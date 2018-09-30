package com.epc.platform.service.domain.admin;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class UserWithRole extends SysAdminUser {
	
	private static final long serialVersionUID = -5680235862276163462L;

	private Long userId;
	private String name;
	private String phone;
	private Long deptId;
	private Date createAt;
	private Date updateAt;
	private Integer isDeleted;
	private Long roleId;
	//角色id
	private List<Long> roleIds;





}