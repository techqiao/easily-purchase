-- ***********************************************************************
-- 易建采平台
-- ***********************************************************************

-- 平台(管理后台)

DROP TABLE IF EXISTS `sys_admin_user`;
CREATE TABLE `sys_admin_user` (
  `id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(256) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `password` CHAR(32) DEFAULT NULL COMMENT '密码',
  `dept_id` BIGINT(11) NOT NULL COMMENT '部门id',
  `create_at` DATETIME NOT NULL COMMENT '创建时间',
  `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
  `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台:用户表';

DROP TABLE IF EXISTS `sys_admin_role`;
CREATE TABLE `sys_admin_role` (
  `id` BIGINT(11) AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL COMMENT '角色名称',
  `memo` varchar(1024) DEFAULT NULL COMMENT '备注',
  `create_at` DATETIME NOT NULL COMMENT '创建时间',
  `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
  `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='平台:角色表';

-- INSERT INTO `sys_admin_role` VALUES ('1', '管理员', '管理员', '', '');
-- INSERT INTO `sys_admin_role` VALUES ('2', '注册账户', '注册账户，只可查看，不可操作', '', '');

DROP TABLE IF EXISTS `sys_admin_user_role`;
CREATE TABLE `sys_admin_user_role` (
  `id` BIGINT(11) AUTO_INCREMENT ,
  `admin_user_id` BIGINT(11) DEFAULT NULL,
  `admin_role_id` BIGINT(11) DEFAULT NULL,
  `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_role_index` (`admin_user_id`,`admin_role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台:用户角色关联表';

DROP TABLE IF EXISTS `sys_admin_resource`;
CREATE TABLE `sys_admin_resource` (
  `id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父资源ID',
  `name` varchar(128) DEFAULT NULL COMMENT '资源名称',
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `type` varchar(32) DEFAULT NULL COMMENT '类型,page:页面，action:功能',
  `url` varchar(1024) DEFAULT NULL COMMENT '资源路径',
  `create_at` DATETIME NOT NULL COMMENT '创建时间',
  `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
  `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台:资源表';

DROP TABLE IF EXISTS `sys_admin_role_resource`;
CREATE TABLE `sys_admin_role_resource` (
  `id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
  `amdin_role_id` BIGINT(11) NOT NULL COMMENT '用户角色ID',
  `admin_resource_id` BIGINT(11) NOT NULL COMMENT '用户资源ID',
  `create_at` DATETIME NOT NULL COMMENT '创建时间',
  `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
  `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台:角色资源关联表';


DROP TABLE IF EXISTS `sys_admin_dept`;
CREATE TABLE `sys_admin_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `parent_id` bigint(20) NOT NULL COMMENT '上级部门ID',
  `dept_name` varchar(100) NOT NULL COMMENT '部门名称',
  `order_num` bigint(20) DEFAULT NULL COMMENT '排序',
  `create_at` DATETIME NOT NULL COMMENT '创建时间',
  `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
  `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='系统：部门表';

DROP TABLE IF EXISTS `sys_admin_user_operator`;
CREATE TABLE `sys_admin_user_operator` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`admin_user_id` BIGINT(11) UNSIGNED COMMENT '平台用户ID',
	`admin_user_name` VARCHAR(32) COMMENT '平台用户名称',
	`operator_id` BIGINT(11) UNSIGNED COMMENT '运营商ID',
	`comany_name` VARCHAR(64) COMMENT '运营商名称',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT  '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台:员工拉取运营商记录表';

-- 运营商 注册
DROP TABLE IF EXISTS `t_operator_basic_info`;
CREATE TABLE `t_operator_basic_info` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号',
	`password` CHAR(32) DEFAULT NULL COMMENT '登录密码',
	`name` VARCHAR(16) DEFAULT NULL COMMENT '运营商员工姓名',
	`operator_id` BIGINT(11) UNSIGNED COMMENT '运营商(法人)ID',
	`state` INT(3) UNSIGNED COMMENT '1-拉取 2-完善信息 3-审核中 4-禁用 5-审核通过',
	`role` INT(2)  COMMENT '用户角色:0-法人,1-管理员,2-普通员工',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
			`is_forbidden` INT(1) DEFAULT '0' COMMENT '是否禁用: 0-启用,1-禁用',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运营商:法人及其员工基本(登录)信息';

-- 运营商 详情
DROP TABLE IF EXISTS `t_operator_detail_info`;
CREATE TABLE `t_operator_detail_info` (
    `id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
    `operator_id` BIGINT(11) UNSIGNED COMMENT '运营商法人ID',
  	`company_name` varchar(64) DEFAULT NULL COMMENT '公司名称',
	   `company_address` varchar(128) DEFAULT NULL COMMENT '公司地址',
    `uniform_credit_code` varchar(64) DEFAULT NULL COMMENT '统一信用代码',
    `public_bank_name` varchar(32) DEFAULT NULL COMMENT '对公银行名称',
    `public_ban_account_number` varchar(32) DEFAULT NULL COMMENT '对公银行账号',
    `create_at` DATETIME NOT NULL COMMENT '创建时间',
    `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
    `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
    PRIMARY KEY (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='运营商:审核所需详细信息';

-- 运营商 附件
DROP TABLE IF EXISTS `t_operator_attachment`;
CREATE TABLE  `t_operator_attachment`(
    `id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`operator_id` BIGINT(11) UNSIGNED COMMENT '运营商法人ID',
	`certificate_type` varchar(64) DEFAULT NULL COMMENT '附件类型',
	`certificate_file_path` varchar(200) NOT NULL COMMENT '附件url',
	`certificate_number` varchar(64) DEFAULT NULL COMMENT '附件号码',
	`certificate_name` varchar(64) DEFAULT NULL COMMENT '附件对应证书名称',
	`create_at` datetime NOT NULL COMMENT '创建时间',
	`update_at` datetime NOT NULL COMMENT '最后修改时间',
	`is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='运营商:附件信息';





-- 私库 运营商添加供应商
DROP TABLE IF EXISTS `t_operator_supplier`;
CREATE TABLE `t_operator_supplier` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号(登录账号)',
	`state` INT(1) UNSIGNED COMMENT '0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败',
	`supplier_id` BIGINT(11)  NOT NULL COMMENT '角色Id',
	`supplier_name` VARCHAR(16) NOT NULL COMMENT '供应商姓名',
	`uniform_credit_code` varchar(64) DEFAULT NULL COMMENT '统一信用代码',
	`public_bank_name` varchar(32) DEFAULT NULL COMMENT '对公银行名称',
	`public_ban_account_number` varchar(32) DEFAULT NULL COMMENT '对公银行账号',
	`source` CHAR(32)  NOT NULL COMMENT '来源(public,private)',
	`operator_id` BIGINT(11) NOT NULL COMMENT '运营商ID',
	`creater_id` BIGINT(11) NOT NULL COMMENT '操作人ID',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商-采购人:私库';



-- 供应商 注册
DROP TABLE IF EXISTS `t_supplier_basic_info`;
CREATE TABLE `t_supplier_basic_info` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`name` VARCHAR(16) DEFAULT NULL COMMENT '员工姓名',
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号',
	`password` CHAR(32) DEFAULT NULL COMMENT '登录密码',
	`supplier_id` BIGINT(11) UNSIGNED COMMENT '供应商(法人)ID',
	`inviter_type` INT(3) DEFAULT NULL COMMENT '邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构，4-平台',
	`inviter_id` BIGINT(11) DEFAULT NULL COMMENT '邀请人Id',
	`inviter_company_id` BIGINT(11) DEFAULT NULL COMMENT '邀请人机构ID',
	`state` INT(3) UNSIGNED COMMENT '1-拉取 2-完善信息 3-审核中 4-禁用 5-审核通过',
	`role` INT(2)  COMMENT '用户角色:0-法人,1-管理员,2-普通员工',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_forbidden` INT(1) DEFAULT '0' COMMENT '是否禁用: 0-启用,1-禁用',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商:法人及其员工基本(登录)信息';


-- 供应商 详情
DROP TABLE IF EXISTS `t_supplier_detail_info`;
CREATE TABLE `t_supplier_detail_info` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`supplier_id` BIGINT(11) UNSIGNED COMMENT '采购人(法人)ID',
	`company_name` varchar(64) DEFAULT NULL COMMENT '公司名称',
	 `company_address` varchar(128) DEFAULT NULL COMMENT '公司地址',
    `uniform_credit_code` varchar(64) DEFAULT NULL COMMENT '统一信用代码',
    `public_bank_name` varchar(32) DEFAULT NULL COMMENT '对公银行名称',
    `public_ban_account_number` varchar(32) DEFAULT NULL COMMENT '对公银行账号',
    `create_at` DATETIME NOT NULL COMMENT '创建时间',
    `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
    `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商:审核所需详细信息';


-- 供应商 附件
DROP TABLE IF EXISTS `t_supplier_attachment`;
CREATE TABLE  `t_supplier_attachment`(
    `id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`supplier_id` BIGINT(11) UNSIGNED COMMENT '运营商法人ID',
	`certificate_type` varchar(64) DEFAULT NULL COMMENT '附件类型',
	`certificate_file_path` varchar(200) NOT NULL COMMENT '附件url',
	`certificate_number` varchar(64) DEFAULT NULL COMMENT '附件号码',
	`certificate_name` varchar(64) DEFAULT NULL COMMENT '附件对应证书名称',
	`create_at` datetime NOT NULL COMMENT '创建时间',
	`update_at` datetime NOT NULL COMMENT '最后修改时间',
	`is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商:附件信息';


-- 采购人 注册
DROP TABLE IF EXISTS `t_purchaser_basic_info`;
CREATE TABLE `t_purchaser_basic_info` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`name` VARCHAR(16) DEFAULT NULL COMMENT '采购人员工姓名',
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号',
	`password` CHAR(32) DEFAULT NULL COMMENT '登录密码',
	`purchaser_id` BIGINT(11) UNSIGNED COMMENT '采购人(法人)ID',
	`inviter_type` INT(3) DEFAULT NULL COMMENT '邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构，4-平台',
	`inviter_id` BIGINT(11) DEFAULT NULL COMMENT '邀请人Id',
	`inviter_company_id` BIGINT(11) DEFAULT NULL COMMENT '邀请人机构ID',
	`state` INT(3) UNSIGNED COMMENT '1-拉取 2-完善信息 3-审核中 4-禁用 5-审核通过',
	`role` INT(2)  COMMENT '用户角色:0-法人,1-管理员,2-普通员工',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_forbidden` INT(1) DEFAULT '0' COMMENT '是否禁用: 0-启用,1-禁用',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购人:法人及其员工基本(登录)信息';

-- 采购人 详情
DROP TABLE IF EXISTS `t_purchaser_detail_info`;
CREATE TABLE `t_purchaser_detail_info` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`purchaser_id` BIGINT(11) UNSIGNED COMMENT '采购人(法人)ID',
	`company_name` varchar(64) DEFAULT NULL COMMENT '公司名称',
	 `company_address` varchar(128) DEFAULT NULL COMMENT '公司地址',
	`uniform_credit_code` varchar(64) DEFAULT NULL COMMENT '统一信用代码',
	`public_bank_name` varchar(32) DEFAULT NULL COMMENT '对公银行名称',
	`public_ban_account_number` varchar(32) DEFAULT NULL COMMENT '对公银行账号',
	`extended_field` varchar(128) DEFAULT NULL COMMENT '扩展字段',
    `create_at` DATETIME NOT NULL COMMENT '创建时间',
    `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
    `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购人:审核所需详细信息';


-- 私库：采购人--供应商(9.29)
DROP TABLE IF EXISTS `t_purchaser_supplier` ;
CREATE TABLE `t_purchaser_supplier` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`state` INT(3) DEFAULT '0'  COMMENT '0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败',
	`purchaser_id` BIGINT(11) UNSIGNED COMMENT '采购人(法人)ID',
	`supplier_id` BIGINT(11)  NOT NULL COMMENT '角色Id',
  `supplier_type` varchar(32) DEFAULT NULL COMMENT '白名单，white_list,黑名单：blank_list',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`source` CHAR(32)  NOT NULL COMMENT '来源(public,private)',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购人-供应商:私库';


-- 私库：采购人--招标代理机构(9.29)
DROP TABLE IF EXISTS `t_purchaser_agency`;
CREATE TABLE `t_purchaser_agency` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`state` INT(1) UNSIGNED COMMENT '0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败',
	`agency_id` BIGINT(11)  NOT NULL COMMENT '角色Id',
	`purchaser_id` BIGINT(11) NOT NULL COMMENT '采购机构ID',
	`creater_id` BIGINT(11) NOT NULL COMMENT '操作人ID',
	`source` CHAR(32)  NOT NULL COMMENT '来源(public,private)',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购人-供应商:私库';


-- 私库：采购人--专家(9.29)
DROP TABLE IF EXISTS `t_purchaser_expert`;
CREATE TABLE `t_purchaser_expert` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`state` INT(1) UNSIGNED COMMENT '0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败',
	`expert_id` BIGINT(11)  NOT NULL COMMENT '角色Id',
	`purchaser_id` CHAR(32) NOT NULL COMMENT '采购机构ID',
	`creater_id` BIGINT(11) NOT NULL COMMENT '操作人ID',
	`source` CHAR(32)  NOT NULL COMMENT '来源(public,private)',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购人-专家:私库';


-- 采购人 附件表
DROP TABLE IF EXISTS `t_purchaser_attachment`;
CREATE TABLE  `t_purchaser_attachment`(
    `id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`purchaser_id` BIGINT(11) UNSIGNED COMMENT '采购人法人ID',
	`certificate_type` varchar(64) DEFAULT NULL COMMENT '附件类型',
	`certificate_file_path` varchar(200) NOT NULL COMMENT '附件url',
	`certificate_number` varchar(64) DEFAULT NULL COMMENT '附件号码',
	`certificate_name` varchar(64) DEFAULT NULL COMMENT '附件对应证书名称',
	`create_at` datetime NOT NULL COMMENT '创建时间',
	`update_at` datetime NOT NULL COMMENT '最后修改时间',
	`is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购人:附件表';


-- 招标(采购)代理机构 注册
DROP TABLE IF EXISTS `t_agency_basic_info`;
CREATE TABLE `t_agency_basic_info` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`name` VARCHAR(16) DEFAULT NULL COMMENT '招标代理机构员工姓名',
	`agency_id` BIGINT(11) UNSIGNED COMMENT '招标(采购)代理机构 ID',
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号',
	`password` CHAR(32) DEFAULT NULL COMMENT '登录密码',
	`inviter_type` INT(3) DEFAULT NULL COMMENT '邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构,4-平台',
	`inviter_id` BIGINT(11) DEFAULT NULL COMMENT '邀请人Id',
	`inviter_company_id` BIGINT(11) DEFAULT NULL COMMENT '邀请人机构ID',
	`state` INT(3) UNSIGNED COMMENT '1-拉取 2-完善信息 3-审核中 4-禁用 5-审核通过',
	`role` INT(2)  COMMENT '用户角色:0-法人,1-管理员,2-普通员工',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_forbidden` INT(1) DEFAULT '0' COMMENT '是否禁用: 0-启用,1-禁用',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标(采购)代理机构:法人及其员工基本(登录)信息';


-- 招标(采购)代理机构 详情
DROP TABLE IF EXISTS `t_agency_detail_info`;
CREATE TABLE `t_agency_detail_info` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`agency_id` BIGINT(11) UNSIGNED COMMENT '招标代理机构(法人)ID',
	`company_name` varchar(64) DEFAULT NULL COMMENT '公司名称',
	 `company_address` varchar(128) DEFAULT NULL COMMENT '公司地址',
    `uniform_credit_code` varchar(64) DEFAULT NULL COMMENT '统一信用代码',
    `public_bank_name` varchar(32) DEFAULT NULL COMMENT '对公银行名称',
    `public_ban_account_number` varchar(32) DEFAULT NULL COMMENT '对公银行账号',
    `create_at` DATETIME NOT NULL COMMENT '创建时间',
    `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
    `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标(采购)代理机构:审核所需详细信息';



-- 招标(采购)代理机构 附件
DROP TABLE IF EXISTS `t_agency_attachment`;
CREATE TABLE  `t_agency_attachment`(
    `id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`agency_id` BIGINT(11) UNSIGNED COMMENT '招标(采购)代理机构 ID',
	`certificate_type` varchar(64) DEFAULT NULL COMMENT '附件类型',
	`certificate_file_path` varchar(200) NOT NULL COMMENT '附件url',
	`certificate_number` varchar(64) DEFAULT NULL COMMENT '附件号码',
	`certificate_name` varchar(64) DEFAULT NULL COMMENT '附件对应证书名称',
	`create_at` datetime NOT NULL COMMENT '创建时间',
	`update_at` datetime NOT NULL COMMENT '最后修改时间',
	`is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标(采购)代理机构:附件信息';

-- 评标专家 注册（10.7）
DROP TABLE IF EXISTS `t_expert_basic_info`;
CREATE TABLE `t_expert_basic_info` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`name` VARCHAR(16) NOT NULL COMMENT '评标专家姓名',
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号(登录账号)',
	`password` CHAR(32) DEFAULT NULL COMMENT '登录密码',
	`profession` CHAR(11) DEFAULT NULL COMMENT '专业',
	`positional` CHAR(11) DEFAULT NULL COMMENT '职称',
	`level` CHAR(11) DEFAULT NULL COMMENT '级别',
	`working_years` INT(2) DEFAULT NULL COMMENT '从业年限',
	`is_idle` INT(1) DEFAULT '1' COMMENT '0-繁忙, 1-空闲',
	`circular_dt` TIMESTAMP  NOT NULL COMMENT '通知时间',
	`circular_dt_end` TIMESTAMP  NOT NULL COMMENT '通知结束时间',
	`circular_method` CHAR(11) DEFAULT NULL COMMENT '通知方式',
	`other_information` VARCHAR(8000) DEFAULT NULL COMMENT '其他信息',
	`inviter_type` INT(3) DEFAULT NULL COMMENT '邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构,4-平台',
	`inviter_id` BIGINT(11) DEFAULT NULL COMMENT '邀请人Id',
	`inviter_company_id` BIGINT(11) DEFAULT NULL COMMENT '邀请人机构ID',
	`state` INT(3) UNSIGNED COMMENT '1-拉取 2-完善信息 3-审核中 4-禁用 5-审核通过',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_forbidden` INT(1) DEFAULT '0' COMMENT '是否禁用: 0-启用,1-禁用',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评标专家:基本(登录)信息';


-- 评标专家 详细信息
DROP TABLE IF EXISTS `t_expert_detail_info`;
CREATE TABLE `t_expert_detail_info` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `expert_id` bigint(11) unsigned DEFAULT NULL COMMENT '专家基础信息表ID',
  `company_name` varchar(64) DEFAULT NULL COMMENT '公司名称',
  `company_address` varchar(128) DEFAULT NULL COMMENT '公司地址',
  `uniform_credit_code` varchar(64) DEFAULT NULL COMMENT '统一信用代码',
  `public_bank_name` varchar(32) DEFAULT NULL COMMENT '对公银行名称',
  `public_ban_account_number` varchar(32) DEFAULT NULL COMMENT '对公银行账号',
  `extended_field` varchar(128) DEFAULT NULL COMMENT '扩展字段',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '最后修改时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除'
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='评标专家:审核所需详细信息';

-- 评标专家 附件
DROP TABLE IF EXISTS `t_expert_attachment`;
CREATE TABLE  `t_expert_attachment`(
    `id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`expert_id` BIGINT(11) UNSIGNED COMMENT '招标(采购)代理机构 ID',
	`certificate_type` varchar(64) DEFAULT NULL COMMENT '附件类型',
	`certificate_file_path` varchar(200) NOT NULL COMMENT '附件url',
	`certificate_number` varchar(64) DEFAULT NULL COMMENT '附件号码',
	`certificate_name` varchar(64) DEFAULT NULL COMMENT '附件对应证书名称',
	`create_at` datetime NOT NULL COMMENT '创建时间',
	`update_at` datetime NOT NULL COMMENT '最后修改时间',
	`is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评标专家:附件表';



-- ##############################    招投标业务表   ##########################################


-- 招标流程：项目表
DROP TABLE IF EXISTS `t_project_basic_info`;
CREATE TABLE `t_project_basic_info` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`project_code` varchar(32) DEFAULT NULL COMMENT '项目编号',
	`project_name` varchar(64) NOT NULL COMMENT '项目名称',
	`project_description` varchar(1024) COMMENT '项目描述',
	`total_project_investment` decimal(18,2) NOT NULL COMMENT '项目总投资 元',
	`source_of_investment` INT(1) NOT NULL COMMENT '投资来源 0：国有投资 1：私有投资 2：国有占主体投资',
	`project_address` varchar(256) NOT NULL COMMENT '项目地址',
	`project_memo` TEXT COMMENT '项目备注',
	`purchaser_id` BIGINT(11) NOT NULL COMMENT '采购商(法人)ID',
  `operate_id` bigint(11) NOT NULL COMMENT '操作人ID',
	`creator` VARCHAR(16) NOT NULL COMMENT '创建人姓名',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:项目信息表';

-- 项目人员指派关系表：不同的项目对应的指派的员工
DROP TABLE IF EXISTS `t_project_employee_relation`;
CREATE TABLE `t_project_employee_relation` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '项目主键ID',
  `project_name` varchar(64) NOT NULL COMMENT '项目名字',
  `creater_id` bigint(11) NOT NULL COMMENT '创建项目人ID',
  `creater_name` varchar(64) NOT NULL COMMENT '创建项目人姓名',
  `purchaser_id` bigint(32) NOT NULL COMMENT '采购法人ID',
  `executive_id` bigint(11) unsigned NOT NULL COMMENT '指派项目经理ID',
  `executive_name` varchar(64) NOT NULL COMMENT '指派项目经理姓名',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `notes` varchar(64) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='项目人员指派关系表：不同的项目对应的指派的员工';



-- 招标流程：预告   表
DROP TABLE IF EXISTS `t_bidding_preview`;
CREATE TABLE `t_bidding_preview` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`project_code` varchar(32) NOT NULL COMMENT '项目编号',
	`project_name` varchar(64) NOT NULL COMMENT '项目名称',
	`project_id` BIGINT(11) NOT NULL COMMENT '项目ID',
	`preview_title` varchar(64) NOT NULL COMMENT '预告标题',
	`preview_memo` varchar(64) NOT NULL COMMENT '预告内容',
	`purchaser_id` BIGINT(11) NOT NULL COMMENT '采购商(法人)ID',
	`status` VARCHAR(64) DEFAULT 'created' COMMENT '状态  创建 created 发布release  失效invalid',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`creator` VARCHAR(16) NOT NULL COMMENT '创建人姓名',
   `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
 	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程：预告表';


-- 招标流程:采购项目    表（10.6）
DROP TABLE IF EXISTS `t_purchase_project_basic_info`;
CREATE TABLE `t_purchase_project_basic_info` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`project_id` BIGINT(64) NOT NULL COMMENT '项目ID',
	`project_name` varchar(64) NOT NULL COMMENT '项目名称',
	`purchase_project_name` varchar(32) NOT NULL COMMENT '采购项目名称',
	`purchase_project_code` varchar(32) DEFAULT NULL COMMENT '采购项目编号',
	`purchase_start_time` DATETIME NOT NULL COMMENT '采购项目开始时间',
	`purchase_end_time` DATETIME NOT NULL COMMENT '采购项目结束时间',
	`is_state_designation` INT(1) DEFAULT '0' COMMENT '是否国家指定必须招标:0是，1不是',
	`purchase_project_budgetary_amount` decimal(18,2) NOT NULL COMMENT '采购项目预算金额',
	`purchase_mode` VARCHAR(64)  COMMENT '采购方式 招标采购:selective_tendering 询比采购:  竞价采购: 谈判采购: 直接采购: 框架协议采购 :',
	`purchase_category` VARCHAR(64)  COMMENT '采购分类 劳务分包labor_subcontract 专业分包professional_subcontracting 设备租赁 货物采购 服务采购 工程采购',
	`purchase_type` VARCHAR(64) COMMENT '采购类型 36种 13种  根据采购分类来',
	`purchase_range` INT(1) DEFAULT '0' COMMENT '可见范围 0：全平台 1：供应商私库',
	`purchase_project_status` VARCHAR(64) COMMENT '采购项目状态 已创建 进行中 已结束 流标',
	`is_adjust` INT(1) DEFAULT '0' COMMENT '是否允许调价:0-不允许,1-允许',
	`is_other_agency` INT(1) DEFAULT '0' COMMENT '是否全权委托招标代理机构(0:不全权委托,1:全权委托)',
		`is_end` INT(1) DEFAULT '0' COMMENT '是否结束',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`creator` VARCHAR(16) NOT NULL COMMENT '创建人姓名',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
 	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:采购项目表';


-- 招标流程: 采购项目参与者   表
--  增加类型用户区分代理机构和采购人
DROP TABLE IF EXISTS `t_purchase_project_participant`;
CREATE TABLE `t_purchase_project_participant` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`purchase_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`user_id` BIGINT(11) NOT NULL COMMENT '参与者ID',
	`user_name` varchar(32) NOT NULL COMMENT '参与者姓名',
	`user_phone` varchar(32) NOT NULL COMMENT '参与者电话',
	`user_agency_id` BIGINT(11) NOT NULL COMMENT '参与者机构ID',
	`agency_name` varchar(32) NOT NULL COMMENT '参与者机构名称',
	`participant_type` int(1) NOT NULL COMMENT '参与者类型 招标代理机构2 采购人4',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`creator` VARCHAR(16) NOT NULL COMMENT '创建人姓名',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:采购项目参与者表';


-- 招标流程: 供应商项目参与者表（10.3）
DROP TABLE IF EXISTS `t_supplier_project_participant`;
CREATE TABLE `t_supplier_project_participant` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`purchase_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
  `bids_id` BIGINT(11) NOT NULL COMMENT  '标段ID',
	`user_id` BIGINT(11) NOT NULL COMMENT '参与者ID',
	`user_name` varchar(32) NOT NULL COMMENT '参与者姓名',
	`user_phone` varchar(32) NOT NULL COMMENT '参与者电话',
	`supplier_id` BIGINT(11) NOT NULL COMMENT '供应商机构ID',
	`companyName` varchar(32) NOT NULL COMMENT '供应商机构名称',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`creator` VARCHAR(16) NOT NULL COMMENT '创建人姓名',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:供应商项目参与者表（10';


-- 招标流程: 采购项目参与者权限   表
DROP TABLE IF EXISTS `t_purchase_project_participant_permission`;
CREATE TABLE `t_purchase_project_participant_permission` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`participant_id` BIGINT(11) NOT NULL COMMENT '采购项目参与者ID',
	`user_id` BIGINT(11) NOT NULL COMMENT '参与者ID',
	`participant_type` int(1) NOT NULL COMMENT '参与者类型 招标代理机构2 采购人4',
	`action_state` int(1) DEFAULT '0' NOT NULL COMMENT '0:暂未到达此步 1待办 2已完成 -1 打回到此步',
	`step_type` VARCHAR(64) DEFAULT NULL COMMENT '流程步骤类型 用来区分是具体哪个流程步骤 发布公告 发布招标文件',
	`purchase_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`participant_permission` VARCHAR(32) NOT NULL COMMENT '项目参与者权限 批复reply 经办agent 审核auditing 负责人person_liable' ,
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`creator` VARCHAR(16) NOT NULL COMMENT '创建人姓名',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:采购项目参与人权限表';



-- 招标流程: 委托招标代理机构   表
DROP TABLE IF EXISTS `t_purchase_project_agent_company_info`;
CREATE TABLE `t_purchase_project_agent_company_info` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`purchase_project_id`  BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`agent_agency_id`  BIGINT(11) NOT NULL COMMENT '代理机构ID',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`creator` VARCHAR(16) NOT NULL COMMENT '创建人姓名',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:委托招标代理机构表';


-- 招标流程: 采购项目标段   表
DROP TABLE IF EXISTS `t_purchase_project_bids`;
CREATE TABLE `t_purchase_project_bids` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`purchase_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`purchase_project_name` varchar(32) NOT NULL COMMENT '采购项目名称',
	`purchase_project_code` varchar(32) DEFAULT NULL COMMENT '采购项目编号',
	`project_id` BIGINT(11) NOT NULL COMMENT '项目ID',
	`project_name` varchar(64) NOT NULL COMMENT '项目名称',
	`project_code` varchar(32) NOT NULL COMMENT '项目编号',
	`bid_code` varchar(64) NOT NULL COMMENT '标段编号',
	`bid_name` varchar(64) NOT NULL COMMENT '标段名称',
	`bid_budgetary_amount` decimal(18,2) NOT NULL COMMENT '预算金额',
	`guarantee_payment` DECIMAL(5,2) DEFAULT 0.00 COMMENT '保证金金额',
	`bid_file_path` varchar(256) NOT NULL COMMENT '标段文件路径',
	`bid_memo` TEXT COMMENT '标段描述',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`creator` VARCHAR(16) NOT NULL COMMENT '创建人姓名',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:采购项目标段';



-- 投标流程:提交预审信息   表   update 多字段
DROP TABLE IF EXISTS `t_pretrial_message`;
CREATE TABLE `t_pretrial_message` (
  `id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
  `purchase_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
  `release_announcement_id` BIGINT(11) NOT NULL COMMENT '公告ID',
  `bid_id` BIGINT(11) NOT NULL COMMENT '标段ID',
  `company_id` BIGINT(11) NOT NULL COMMENT '公司ID',
  `status` VARCHAR(64) NOT NULL COMMENT '是否通过: review-审核中,noPass-未通过,pass-通过',
  `content` VARCHAR(1024) NOT NULL COMMENT '信息',
  `operate_id` BIGINT(11) NOT NULL COMMENT  '操作人ID',
  `creator` varchar(16) NOT NULL COMMENT '创建人姓名',
  `create_at` DATETIME NOT NULL COMMENT '创建时间',
  `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
  `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投标流程:提交预审信息';


-- 投标流程:预审文件  表
DROP TABLE IF EXISTS `t_pretrial_file`;
CREATE TABLE `t_pretrial_file` (
  `id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
  `pretrial_message_id` BIGINT(11) NOT NULL COMMENT '预审信息ID',
  `file_path` VARCHAR(256) NOT NULL COMMENT '文件路径',
  `file_name` VARCHAR(256) NOT NULL COMMENT '文件名',
  `operate_id` BIGINT(11) NOT NULL COMMENT  '操作人ID',
  `creator` varchar(16) NOT NULL COMMENT '创建人姓名',
  `create_at` DATETIME NOT NULL COMMENT '创建时间',
  `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
  `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投标流程:预审文件';


-- 发布招标公告  表    update
DROP TABLE IF EXISTS `b_release_announcement`;
CREATE TABLE `b_release_announcement` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`procurement_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`auditor_id` BIGINT(11) UNSIGNED COMMENT '审核人ID',
	`replies_id` BIGINT(11) UNSIGNED COMMENT '批复人ID',
	`bidding_documents_url` VARCHAR(256) DEFAULT NULL COMMENT '招标公告附件url',
  `bidding_start` DATETIME NOT NULL COMMENT '招标公告开始时间',
	`bidding_end` DATETIME NOT NULL COMMENT '招标公告结束时间',
  `defecation_start` datetime NOT NULL COMMENT '澄清开始时间',
  `defecation_end` datetime NOT NULL COMMENT '澄清结束时间',
	`title` varchar(256) DEFAULT NULL COMMENT '标题',
	`announcement_content` TEXT COMMENT '公告评语',
	`process_status` VARCHAR(64)  DEFAULT 'not_submit' COMMENT '审核 auditing, 批复 reply, 待发布wait_release,已发布 released, 未提交not_submit, 失效invalid',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:发布招标公告';



-- #发售招标文件  表
DROP TABLE IF EXISTS `b_sale_documents`;
CREATE TABLE `b_sale_documents` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`procurement_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`auditor_id` BIGINT(11) UNSIGNED COMMENT '审核人ID',
	`replies_id` BIGINT(11) UNSIGNED COMMENT '批复人ID',
	`bidding_documents_up_url` VARCHAR(256) DEFAULT NULL COMMENT '招标文件附件上传url',
	`bidding_documents_download_url` VARCHAR(256) DEFAULT NULL COMMENT '招标文件附件下载url',
  `is_under_line` INT(1) DEFAULT '1' COMMENT '发售方式: 0-线下,1-线上,3-线上线下 ',
  `bidding_end_time` DATETIME NOT NULL COMMENT '投标文件递交截止时间',
  `bidding_bond_end_time` DATETIME NOT NULL COMMENT '投标保证金截止时间',
 	`bid_opening_time` DATETIME NOT NULL COMMENT '开标时间',
 	`bid_opening_place` VARCHAR(64) NOT NULL COMMENT  '开标地点',
  `clarification_problem_end_time` DATETIME NOT NULL COMMENT '澄清问题时间',
	`decryption_method` INT(1) NOT NULL COMMENT  '解密方式 0 CA锁',
	`process_status` VARCHAR(64)  DEFAULT 'not_submit' COMMENT '审核 auditing, 批复 reply, 待发布wait_release,已发布 released, 未提交not_submit, 失效invalid',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:发售招标文件';


-- #发售招标文件-线下发售   表
DROP TABLE IF EXISTS `b_tender_documents_place_sale`;
CREATE TABLE `b_tender_documents_place_sale` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`procurement_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`b_issue_documents_id` BIGINT(11) NOT NULL COMMENT '发售招标文件表主键ID   ',
	`sale_time_start`  DATETIME NOT NULL COMMENT '发售开始时间',
	`sale_time_end`  DATETIME NOT NULL COMMENT '发售截止时间',
	`place`VARCHAR(64) DEFAULT NULL COMMENT '发售地点',
	`price` DECIMAL(5,2) DEFAULT 0.00 COMMENT '金额',
	`contacts_name`VARCHAR(32) DEFAULT NULL COMMENT '联系人',
	`contact_number` VARCHAR(32) DEFAULT NULL COMMENT '联系电话',
	`remarks` VARCHAR(32) DEFAULT NULL COMMENT '备注',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:发售招标文件-线下发售';



-- #发售招标文件 - 标段保证金表
DROP TABLE IF EXISTS `b_bids_guarantee_amount`;
CREATE TABLE `b_bids_guarantee_amount` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`procurement_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`b_issue_documents_id` BIGINT(11) NOT NULL COMMENT '发售招标文件表主键ID',
	`tender_guarantee_amount` DECIMAL(12,2) DEFAULT 0.00 COMMENT '投标保证金',
	`bids_name` VARCHAR(64) DEFAULT NULL COMMENT '标段名称',
	`bids_id` BIGINT(11) NOT NULL COMMENT  '标段ID',
	`bids_code` VARCHAR(64) NOT NULL COMMENT  '标段编号',
  `receivables`VARCHAR(64) NOT NULL COMMENT  '收款单位',
  `bank_account` VARCHAR(64) NOT NULL COMMENT  '开户行帐号',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:发售招标文件-标段保证金';


-- #发售招标文件- 标段保证金支付记录   表
DROP TABLE IF EXISTS `b_bid_opening_pay`;
CREATE TABLE `b_bid_opening_pay` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`project_id` BIGINT(11) NOT NULL COMMENT '项目id',
  `procurement_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
  `bid_id` BIGINT(11) NOT NULL COMMENT '标段id',
	`bids_guarantee_amount_id` BIGINT(11) NOT NULL COMMENT '标段保证金ID',
	`tenderer_id` BIGINT(11) NOT NULL COMMENT '投标人ID',
	`tenderer_company_id`BIGINT(11) NOT NULL COMMENT '投标人单位ID',
	`tenderer_name`VARCHAR(64) NOT NULL COMMENT  '投标人姓名',
	`tenderer_company_name`VARCHAR(64) NOT NULL COMMENT '投标人单位',
	`amount_money_time` DATETIME NOT NULL COMMENT '付款时间',
	`amount_money` DECIMAL(5,2) DEFAULT 0.00 COMMENT '到账金额',
	`payment_name` VARCHAR(64) NOT NULL COMMENT  '付款人姓名',
	`payment_account_number`VARCHAR(64) NOT NULL COMMENT'支付账户',
	`payment_id` BIGINT(11) UNSIGNED COMMENT '付款人ID',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_back` INT(1) DEFAULT '0' COMMENT '是否退款: 0-否,1-是',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:开标 ';



-- #发售招标文件-评标标准设定   表
DROP TABLE IF EXISTS `b_evaluation_tender_standard`;
CREATE TABLE `b_evaluation_tender_standard` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`procurement_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`bids_id` BIGINT(11) NOT NULL COMMENT  '标段ID',
	`file_path` VARCHAR(256) NOT NULL COMMENT '评标方法文件url',
	`memo` TEXT COMMENT '评标方法描述',
	`standard_type` VARCHAR(64) COMMENT '评标方法类型 商务评标 技术评标',
	`type_score` int(11) NOT NULL COMMENT '方法总分数',
	`process_status` VARCHAR(64)  DEFAULT 'not_submit' COMMENT '审核 auditing, 批复 reply, 待发布wait_release,已发布 released, 未提交not_submit, 失效invalid',
	`auditor_id` BIGINT(11) UNSIGNED COMMENT '审核人ID',
	`replies_id` BIGINT(11) UNSIGNED COMMENT '批复人ID',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:评标标准设定';


-- #发售招标文件-评标标准：废除条款 表
DROP TABLE IF EXISTS `b_tender_abolish_clause`;
CREATE TABLE `b_tender_abolish_clause` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`evaluation_tender_standard_id` BIGINT(11) NOT NULL COMMENT '评标标准设定表ID',
	`template_id` BIGINT(11) NOT NULL COMMENT '废标条款模板ID',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:评标标准设定-废除条款';



-- #发售招标文件-评标标准：废除条款模板 表
DROP TABLE IF EXISTS `b_tender_abolish_clause_template`;
CREATE TABLE `b_tender_abolish_clause_template` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`file_path` VARCHAR(256) NOT NULL COMMENT '废除条款模板 url',
	`clause_name` VARCHAR(128) NOT NULL COMMENT '废除条款模板名称',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:评标标准设定-废除条款模板';




-- #发售招标文件-问题答复表 update
DROP TABLE IF EXISTS `b_answer_question`;
CREATE TABLE `b_answer_question` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`procurement_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`questioner_id` BIGINT(11) UNSIGNED COMMENT '提问人ID',
	`question_type`VARCHAR(64) NOT NULL COMMENT '问题类型（公告-announcement,招标文件-bidFile,评标-bidEvaluation）',
	`questioner_name`VARCHAR(64) NOT NULL COMMENT '提问人姓名',
	`type_id` BIGINT(11) UNSIGNED COMMENT '类型ID',
	`problem` TEXT COMMENT  '问题',
	`answer_id` BIGINT(11) UNSIGNED COMMENT '回答问题人Id',
	`answer_name` VARCHAR(64) NOT NULL COMMENT  '回答问题人姓名',
	`answer` TEXT COMMENT '回答内容',
	`status` VARCHAR(64) DEFAULT 'wait_reply' COMMENT  '问题状态 待回复 wait_reply 已回复 replied',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:问题答复';




-- 投标流程:投标文件   表
DROP TABLE IF EXISTS `t_tender_file`;
CREATE TABLE `t_tender_file` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tender_message_id` bigint(11) NOT NULL COMMENT '提交招标文件ID',
  `file_path` varchar(256) NOT NULL COMMENT '文件路径',
  `file_name` varchar(16) NOT NULL COMMENT '文件名',
  `operate_id` bigint(11) NOT NULL COMMENT '操作人ID',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '最后修改时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投标流程:投标文件';

-- 投标流程:提交投标文件   表
DROP TABLE IF EXISTS `t_tender_message`;
CREATE TABLE `t_tender_message` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `purchase_project_id` bigint(11) NOT NULL COMMENT '采购项目ID',
  `release_announcement_id` bigint(11) NOT NULL COMMENT '公告ID',
  `bids_id` BIGINT(11) NOT NULL COMMENT  '标段ID',
  `company_id` bigint(11) NOT NULL COMMENT '公司ID',
  `company_name` varchar(64) NOT NULL COMMENT '公司名称',
  `delegator` varchar(16) NOT NULL COMMENT '授权委托人',
  `identit_card` varchar(16) NOT NULL COMMENT '授权委托人身份证',
  `bailment_path` varchar(256) NOT NULL COMMENT '委托书记录',
  `bid_appendix` varchar(256) NOT NULL COMMENT '投标附录',
  `ip` varchar(64) DEFAULT NULL COMMENT 'ip',
  `operate_id` bigint(11) NOT NULL COMMENT '操作人ID',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '最后修改时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投标流程:提交投标文件';


-- 投标流程:开标记录   表
DROP TABLE IF EXISTS `t_opening_record`;
CREATE TABLE `t_opening_record` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `purchase_project_id` bigint(11) NOT NULL COMMENT '采购项目ID',
  `tender_message_id` bigint(11) NOT NULL  COMMENT '提交投标文件ID 关联委托人信息',
  `bids_id` BIGINT(11) NOT NULL COMMENT  '标段ID',
  `supplier_company_id` bigint(11) NOT NULL COMMENT '投标单位名称ID(供应商)',
  `supplier_company_name` varchar(64) NOT NULL COMMENT '投标单位名称(供应商名称)',
  `is_pay_bond` int(1) NOT NULL COMMENT '是否缴纳保证金 0 否 1是 ',
  `is_sign` int(1) NOT NULL COMMENT '是否签到 0 否 1是',
  `is_bidding_qualified` int(1) NOT NULL COMMENT '标书封装检查是否合格 0 否 1是',
  `is_bidding_refuse` int(1) NOT NULL COMMENT '是否拒收标书 0 否 1是',
  `bidding_refuse_reason` VARCHAR(1024) NOT NULL COMMENT '拒收理由',
  `status` int(1)  NOT NULL COMMENT '状态 0不正常 1正常 ',
  `operate_id` bigint(11) NOT NULL COMMENT '操作人ID',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL  COMMENT '最后修改时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投标流程:开标记录';


-- 投标流程:公示开标记录   表（范围）
DROP TABLE IF EXISTS `t_opening_record_publicity`;
CREATE TABLE `t_opening_record_publicity` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `bid_announcement_id` bigint(11) NOT NULL  COMMENT '唱标ID',
  `bids_id` BIGINT(11) NOT NULL COMMENT  '标段ID',
  `start_time` datetime NOT NULL  COMMENT '公示开始时间',
  `end_time` datetime NOT NULL  COMMENT '公示结束时间',
  `auditor_id` BIGINT(11) UNSIGNED COMMENT '审核人ID',
  `replies_id` BIGINT(11) UNSIGNED COMMENT '批复人ID',
  `process_status` VARCHAR(64)  DEFAULT 'not_submit' COMMENT '审核 auditing, 批复 reply, 待发布wait_release,已发布 released, 未提交not_submit, 失效invalid',
  `operate_id` bigint(11) NOT NULL COMMENT '操作人ID',
  `create_at` datetime NOT NULL  COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '最后修改时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投标流程:公示开标记录';


-- 投标流程:唱标记录   表
DROP TABLE IF EXISTS `t_bid_announcement`;
CREATE TABLE `t_bid_announcement` (
  `id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
  `purchase_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
  `bids_id` BIGINT(11) NOT NULL COMMENT  '标段ID',
  `file_path` varchar(256) NOT NULL COMMENT '唱标信息附件',
  `operate_id` bigint(11) NOT NULL COMMENT '操作人ID',
  `creator` varchar(16) NOT NULL COMMENT '创建人姓名',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '最后修改时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投标流程:唱标记录表';



-- #发售招标文件-组建评委会  表
DROP TABLE IF EXISTS `b_assessment_committee`;
CREATE TABLE `b_assessment_committee` (
  `id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
  `procurement_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
  `total_number` INT(1) NOT NULL COMMENT '总人数',
  `platform_experts_number` INT(1) NOT NULL COMMENT '平台专家数量',
  `owner_specialists_number` INT(1) NOT NULL COMMENT '招标方专家数量',
  `auditor_id` BIGINT(11) UNSIGNED COMMENT '审核人ID',
  `replies_id` BIGINT(11) UNSIGNED COMMENT '批复人ID',
  `process_state` INT(1) UNSIGNED COMMENT '0-审核, 1-批复, 2-通过, 3-保存等待',
  `operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
  `create_at` DATETIME NOT NULL COMMENT '创建时间',
  `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
  `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:组建评委员会';


-- # 发售招标文件-组建评委会 标段对应专家 表
DROP TABLE IF EXISTS `b_assessment_committee_bid`;
CREATE TABLE `b_assessment_committee_bid` (
  `id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
  `committee_id` BIGINT(11) NOT NULL COMMENT '委员会ID',
  `bids_id` BIGINT(11) NOT NULL COMMENT  '标段ID',
  `bids_name` VARCHAR(64) NOT NULL COMMENT '标段名称',
  `professional_number` INT(1) NOT NULL COMMENT '专业人数',
  `professional_name` VARCHAR(64) NOT NULL COMMENT '专业名称',
  `professional_level` VARCHAR(64) NOT NULL COMMENT '专业级别',
  `operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
  `create_at` DATETIME NOT NULL COMMENT '创建时间',
  `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
  `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:组建评委员会 标段对应专家';


-- #发售招标文件-组建评委会专家   表
DROP TABLE IF EXISTS `b_assessment_committee_expert`;
CREATE TABLE `b_assessment_committee_expert` (
  `id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
  `procurement_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
  `bids_id` BIGINT(11) NOT NULL COMMENT  '标段ID',
  `committee_bid_id` BIGINT(11) NOT NULL COMMENT '标段专家对应主键',
  `notice_time` DATETIME NOT NULL COMMENT '通知时间',
  `notice_mode` VARCHAR(64) NOT NULL COMMENT '通知方式',
  `expert_area` VARCHAR(64) NOT NULL COMMENT '专家区域',
  `expert_id` BIGINT(11) NOT NULL COMMENT '专家ID',
  `expert_name` VARCHAR(64) NOT NULL COMMENT  '专家姓名',
  `operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
  `create_at` DATETIME NOT NULL COMMENT '创建时间',
  `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
  `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:组建评委员会专家';



-- #发售招标文件-评标专家签到   表
DROP TABLE IF EXISTS `b_expert_sign`;
CREATE TABLE `b_expert_sign` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`expert_id` BIGINT(11) NOT NULL COMMENT '评标专家ID',
	`bids_id` BIGINT(11) NOT NULL COMMENT  '标段ID',
	`procurement_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`is_leader` INT(1) DEFAULT '0' COMMENT '是否为组长 0 否 1 是',
  `operate_id` bigint(11) NOT NULL COMMENT '操作人ID',
  `update_at` datetime NOT NULL COMMENT '最后修改时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:评标专家签到';


-- 招标流程: 专家评审   表
DROP TABLE IF EXISTS `b_expert_score`;
CREATE TABLE `b_expert_score` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`bids_id` BIGINT(11) NOT NULL COMMENT  '标段ID',
	`bids_code` VARCHAR(64) NOT NULL COMMENT  '标段编号',
	`procurement_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`supplier_id` bigint(11) unsigned DEFAULT NULL COMMENT '供应商(法人)ID',
	`supplier_company_name` varchar(64) DEFAULT NULL COMMENT '供应商公司名称',
  `status` int(1) DEFAULT '0' NOT NULL COMMENT '状态 0未评分 1已评分',
	`standard_type` VARCHAR(64) NOT NULL COMMENT '评标方法类型 商务评标 技术评标',
	`tech_type_score` DOUBLE(3,2) COMMENT '技术评标分数',
	`commerce_type_score` DOUBLE(3,2) COMMENT '商务评标分数',
	`final_score` DOUBLE(3,2)  COMMENT '最终评标分数',
	`expert_id` BIGINT(11) NOT NULL COMMENT '评标专家ID',
	`expert_name` VARCHAR(64) NOT NULL COMMENT  '专家姓名',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:专家评审';

-- 招标流程: 评审报告  表
DROP TABLE IF EXISTS `b_expert_score_report`;
CREATE TABLE `b_expert_score_report` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`memo` TEXT COMMENT '评分报告',
	`file_path` VARCHAR(256) NOT NULL COMMENT '评标报告url',
	`bids_id` BIGINT(11) NOT NULL COMMENT  '标段ID',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:评审报告';


-- 投标流程:供应商签到   表  update
DROP TABLE IF EXISTS `t_supplier_sign`;
CREATE TABLE `t_supplier_sign` (
  `id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
  `procurement_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
  `bids_id` BIGINT(11) NOT NULL COMMENT '标段ID',
  `bids_name` VARCHAR(64) NOT NULL COMMENT '标段名称',
  `company_id` BIGINT(11) NOT NULL COMMENT '签到人机构Id',
  `company_name`VARCHAR(64) NOT NULL COMMENT '签到人公司名称',
  `person_name`VARCHAR(64) NOT NULL COMMENT '签到人姓名',
  `identit_card` varchar(64) NOT NULL COMMENT '身份证',
  `cellphone` VARCHAR(64) NOT NULL COMMENT '签到人手机号',
  `create_at` DATETIME NOT NULL COMMENT '创建时间',
  `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
  `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投标流程:供应商签到表';

-- 发起招标表
DROP TABLE IF EXISTS `t_purchase_project_begin`;
CREATE TABLE `t_purchase_project_begin` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`packet_mode` VARCHAR(64)  COMMENT '发包方式 open公开 invite邀请',
	`is_prequalification` INT(1) DEFAULT '0' COMMENT '是否资格预审 0否 1是',
	`purchase_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`purchase_project_name` varchar(32) NOT NULL COMMENT '采购项目名称',
	`purchase_project_code` varchar(32) NOT NULL COMMENT '采购项目编号',
	`project_id` BIGINT(11) NOT NULL COMMENT '项目ID',
	`project_name` varchar(64) NOT NULL COMMENT '项目名称',
	`project_code` varchar(64) NOT NULL COMMENT '项目编码',
	`purchase_place` varchar(64) NOT NULL COMMENT '采购地点',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`creator` VARCHAR(16) NOT NULL COMMENT '创建人姓名',
    `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
 	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购项目：发起招标表 ';

-- 招标流程:中标   表
DROP TABLE IF EXISTS `t_win_bid` ;
CREATE TABLE `t_win_bid` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `project_id` bigint(11) NOT NULL COMMENT '项目id',
  `project_name` varchar(64) NOT NULL COMMENT '项目名称',
  `project_code` varchar(64) NOT NULL COMMENT '项目编号',
  `procurement_project_id` bigint(11) NOT NULL COMMENT '采购项目id',
  `procurement_project_name` varchar(64) NOT NULL COMMENT '采购项目名称',
  `bid_id` bigint(11) NOT NULL COMMENT '标段id',
  `bid_name` varchar(64) NOT NULL COMMENT '标段名称',
  `bid_code` varchar(64) NOT NULL COMMENT '标段编号',
  `purchaser_id` bigint(11) unsigned DEFAULT NULL COMMENT '采购人(法人)ID',
  `purchaser_monety` decimal(18,2) DEFAULT NULL COMMENT '采购人中标价格',
  `file_path` varchar(256) NOT NULL COMMENT '中标通知书路径',
  `supplier_id` bigint(11) unsigned DEFAULT NULL COMMENT '供应商Id',
  `operate_id` bigint(11) NOT NULL COMMENT '操作人ID',
  `process_status` VARCHAR(64)  DEFAULT 'not_submit' COMMENT '审核 auditing, 批复 reply, 待发布wait_release,已发布 released, 未提交not_submit, 失效invalid',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:中标表';


-- 招标流程:服务费    表
DROP TABLE IF EXISTS `t_service_money_pay_record` ;

CREATE TABLE `t_service_money_pay_record` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `money_pay_id` bigint(11) NOT NULL COMMENT '中标服务费表ID',
  `guarantee_payment_real` decimal(18,2) NOT NULL COMMENT '实付服务费金额',
  `operater_id` bigint(11) NOT NULL COMMENT '操作人ID',
  `operater_name` varchar(64) NOT NULL COMMENT '操作人姓名',
  `creator` varchar(16) NOT NULL COMMENT '创建人姓名',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '最后修改时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:服务费表';


-- 投标流程:服务费支付    表
DROP TABLE IF EXISTS `t_service_money_pay` ;
CREATE TABLE `t_service_money_pay` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `procurement_project_id` bigint(11) NOT NULL COMMENT '采购项目ID',
  `bid_id` bigint(11) NOT NULL COMMENT '标段Id',
  `bid_name` varchar(64) NOT NULL COMMENT '标段名称',
  `bid_money` decimal(18,2) NOT NULL COMMENT '中标金额',
  `service_money` decimal(18,2) NOT NULL COMMENT '应缴纳平台服务费',
  `status` int(1) DEFAULT '0' COMMENT '缴纳状态(0:未缴纳，1:已缴纳)',
  `company_id` bigint(11) NOT NULL COMMENT '中标机构ID',
  `company_name` varchar(64) NOT NULL COMMENT '中标机构名称',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '最后修改时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投标流程:服务费支付表';




-- 招标流程:中标提名       表
DROP TABLE IF EXISTS `t_win_bid_nominate`;
CREATE TABLE `t_win_bid_nominate` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`purchaser_id` BIGINT(11) UNSIGNED COMMENT '采购人(法人)ID',
	`purchaser_name` VARCHAR(64) NOT NULL COMMENT '建设单位',
	`agency_name` VARCHAR(64)  NOT NULL COMMENT '项目名称',
	`agency_phone` VARCHAR(64)  NOT NULL COMMENT '项目名称',
	`is_power_Agency` int(1) DEFAULT '0' COMMENT '是否委托: 0-否,1-是',
	`project_name` VARCHAR(64) NOT NULL COMMENT '报建项目名称',
	`project_code` VARCHAR(64) NOT NULL COMMENT '报建编号',
	`purchase_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`bid_id` BIGINT(11) NOT NULL COMMENT '标段ID',
	`bid_name` VARCHAR(64) NOT NULL COMMENT '标段名称',
	`bid_code` VARCHAR(64)  NOT NULL COMMENT '标段号',
	`first_supplierId` BIGINT(11)  NOT NULL COMMENT '第一中标人ID',
	`first_companyName` VARCHAR(64) NOT NULL COMMENT '第一中标人',
	`first_price` decimal(18,2)  COMMENT '第一中标人报价',
	`two_supplierId` BIGINT(11)  NOT NULL COMMENT '第二中标人ID',
	`two_price` decimal(18,2)  COMMENT '第二中标人报价',
	`two_companyName` VARCHAR(64) NOT NULL COMMENT '第二中标人公司名称',
	`three_supplierId` BIGINT(11)  NOT NULL COMMENT '第三中标人ID',
	`three_price` decimal(18,2)  COMMENT '第三中标人报价',
	`three_companyName` VARCHAR(20) NOT NULL COMMENT '第三中标人公司名称',
	`open_start` DATETIME NOT NULL COMMENT '公开开始时间',
	`open_end` DATETIME NOT NULL COMMENT '公开结束时间',
	`file_path` VARCHAR(256) DEFAULT NULL COMMENT '中标公示附件',
	`process_status` VARCHAR(64)  DEFAULT 'not_submit' COMMENT '审核 auditing, 批复 reply, 待发布wait_release,已发布 released, 未提交not_submit, 失效invalid',
	`operate_id` bigint(11) NOT NULL COMMENT '操作人ID',
	`create_at` datetime NOT NULL COMMENT '创建时间',
	`update_at` datetime NOT NULL COMMENT '最后修改时间',
	`is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:中标提名表';


-- #发售招标文件-评标标准因素   表
DROP TABLE IF EXISTS `b_technology_tender_standard`;
CREATE TABLE `b_technology_tender_standard` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`evaluation_tender_standard_id` BIGINT(11) NOT NULL COMMENT '评标标准设定表ID',
	`evaluation_factors` VARCHAR(64) NOT NULL COMMENT '评审因素',
	`explain` TEXT COMMENT '说明',
  `dividing_range_start` VARCHAR(64) NOT NULL COMMENT '分值开始范围',
	`dividing_range_end` VARCHAR(64) NOT NULL COMMENT '分值结束范围',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:评标标准因素';




-- 招标流程:下载招标文件    表
DROP TABLE IF EXISTS `t_purchase_project_file_download` ;
CREATE TABLE `t_purchase_project_file_download` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `purchase_project_id` bigint(11) NOT NULL COMMENT '采购项目ID',
  `purchaser_id` bigint(11) NOT NULL COMMENT '采购商(法人)ID',
  `purchase_file_name` varchar(64) NOT NULL COMMENT '招标文件名',
  `file_payment` decimal(18,2) NOT NULL COMMENT '下载金额：元',
  `operate_id` bigint(11) NOT NULL COMMENT '操作人ID',
  `creator` varchar(16) NOT NULL COMMENT '创建人姓名',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '最后修改时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:下载招标文件表';


-- 招标流程:下载招标文件付费    表
DROP TABLE IF EXISTS `t_purchase_project_file_pay` ;
CREATE TABLE `t_purchase_project_file_pay` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `purchase_project_file_id` bigint(11) NOT NULL COMMENT '下载招标文件ID',
  `file_payment_real` decimal(18,2) NOT NULL COMMENT '实付金额：元',
  `company_id` bigint(11) NOT NULL COMMENT '下载机构ID',
  `operate_id` bigint(11) NOT NULL COMMENT '操作人ID',
  `creator` varchar(16) NOT NULL COMMENT '创建人姓名',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '最后修改时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:下载招标文件付费表';

-- ### 资格预审/资格后审

-- #发售招标文件-供应商数量
DROP TABLE IF EXISTS `b_suppliers_number`;
CREATE TABLE `b_suppliers_number` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`procurement_project_id` BIGINT(11) NOT NULL COMMENT '采购项目ID',
	`bids_id` BIGINT(11) NOT NULL COMMENT '标段ID',
  `supplier_company_id` BIGINT(11) NOT NULL COMMENT '供应商机构Id',
	`auditor_id` BIGINT(11) UNSIGNED COMMENT '审核人ID',
	`replies_id` BIGINT(11) UNSIGNED COMMENT '批复人ID',
	`bids_name` VARCHAR(64) NOT NULL COMMENT '标段名',
  `supplier_company_name` VARCHAR(64) NOT NULL COMMENT '供应商公司名称',
  `bids` VARCHAR(64) NOT NULL COMMENT '投标书地址',
	`process_state` INT(1) UNSIGNED COMMENT '0-审核, 1-批复, 2-通过, 3-保存等待',
	`operate_id`  BIGINT(11) NOT NULL COMMENT '操作人ID',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:供应商数量';

DROP TABLE IF EXISTS `b_sign_up`;
CREATE TABLE `b_sign_up` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `project_id` bigint(11) NOT NULL COMMENT '项目ID',
  `procurement_project_id` bigint(11) NOT NULL COMMENT '采购项目ID',
  `bids_id` varchar(256) DEFAULT NULL COMMENT '标段ID',
  `bids_name` varchar(256) NOT NULL COMMENT '标段名称',
  `supplier_id` bigint(11) NOT NULL COMMENT '供应商ID',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '最后修改时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报名表';

DROP TABLE IF EXISTS `b_invitation`;
CREATE TABLE `b_invitation` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `project_id` bigint(11) NOT NULL COMMENT '项目ID',
  `procurement_project_id` bigint(11) NOT NULL COMMENT '采购项目ID',
  `bids_id` varchar(256) DEFAULT NULL COMMENT '标段ID',
  `bids_name` varchar(256) NOT NULL COMMENT '标段名称',
  `content` varchar(256) NOT NULL COMMENT '邀请内容',
  `purchaser_id` bigint(11) NOT NULL COMMENT '采购人ID',
  `supplier_id` bigint(11) NOT NULL COMMENT '供应商ID',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '最后修改时间',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='招标流程:采购人邀请供应商参加采购项目';


-- #项目流程表
DROP TABLE if exists `t_project_procedure` ;
CREATE TABLE `t_project_procedure` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `project_id` bigint(11) NOT NULL COMMENT '项目ID',
  `purchase_project_id` bigint(11) NOT NULL COMMENT '采购项目ID',
  `procedure_code` varchar(64) NOT NULL COMMENT '流程编码',
  `operate_type` varchar(64) NOT NULL COMMENT '用户类别（supplier,purchaser）',
  `creator` varchar(16) DEFAULT NULL COMMENT '创建人姓名',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '最后修改时间',
  `is_end` int(1) DEFAULT '0' COMMENT '是否删除: 0-进行中,1-结束',
  `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目流程表';

CREATE TABLE `sys_dictionary` (
  `dict_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `text` varchar(50) DEFAULT '' COMMENT '用于其他字段显示',
  `value` varchar(50) DEFAULT '' COMMENT '字典value',
  `path` varchar(50) DEFAULT '' COMMENT '路径枚举',
  `seq` float unsigned zerofill DEFAULT NULL COMMENT '排序',
  `type` varchar(20) DEFAULT '' COMMENT '字典分类',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='数据字典，使用 路径枚举策略';
