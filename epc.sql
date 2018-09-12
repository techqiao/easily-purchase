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
	`password` CHAR(32) NOT NULL COMMENT '登录密码',
	`name` VARCHAR(16) NOT NULL COMMENT '运营商员工姓名',
	`operator_id` BIGINT(11) UNSIGNED COMMENT '运营商(法人)ID',	
	`state` INT(2) UNSIGNED COMMENT '0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败',
	`role` INT(2) DEFAULT 'legalPerson' COMMENT '用户角色:0-法人,1-管理员,2-普通员工',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运营商:法人及其员工基本(登录)信息';

-- 运营商 详情
DROP TABLE IF EXISTS `t_operator_detail_info`;
CREATE TABLE `t_operator_detail_info` (
    `id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
    `operator_id` BIGINT(11) UNSIGNED COMMENT '运营商法人ID',
	`company_name` varchar(64) DEFAULT NULL COMMENT '公司名称',
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


--私库 运营商添加采购人
DROP TABLE IF EXISTS `t_operator_purchaser`;
CREATE TABLE `t_operator_purchaser` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号(登录账号)',
	`password` CHAR(32) NOT NULL COMMENT '登录密码',
	`state` INT(1) UNSIGNED COMMENT '0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败',
	`purchaser_id` BIGINT(11)  NOT NULL COMMENT '角色Id',
	`purchaser_name` VARCHAR(16) NOT NULL COMMENT '采购人姓名',
	`source` CHAR(32)  NOT NULL COMMENT '来源(public,private)',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` BIT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商-采购人:私库';

--私库 运营商添加供应商
DROP TABLE IF EXISTS `t_operator_supplier`;
CREATE TABLE `t_operator_supplier` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号(登录账号)',
	`password` CHAR(32) NOT NULL COMMENT '登录密码',
	`state` INT(1) UNSIGNED COMMENT '0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败',
	`supplier_id` BIGINT(11)  NOT NULL COMMENT '角色Id',
	`supplier_name` VARCHAR(16) NOT NULL COMMENT '供应商姓名',
	`source` CHAR(32)  NOT NULL COMMENT '来源(public,private)',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` BIT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商-采购人:私库';


-- 供应商 注册
DROP TABLE IF EXISTS `t_supplier_basic_info`;
CREATE TABLE `t_supplier_basic_info` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`name` VARCHAR(16) NOT NULL COMMENT '员工姓名', 
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号',
	`password` CHAR(32) NOT NULL COMMENT '登录密码',
	`supplier_id` BIGINT(11) UNSIGNED COMMENT '供应商(法人)ID',	
	`state` INT(1) UNSIGNED COMMENT '0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败',
	`role` INT(2) DEFAULT 'legalPerson' COMMENT '用户角色:0-法人,1-管理员,2-普通员工',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商:法人及其员工基本(登录)信息';

--供应商 详情
DROP TABLE IF EXISTS `t_supplier_detail_info`;
CREATE TABLE `t_supplier_detail_info` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID', 
	`supplier_id` BIGINT(11) UNSIGNED COMMENT '采购人(法人)ID',
	`company_name` varchar(64) DEFAULT NULL COMMENT '公司名称',
    `uniform_credit_code` varchar(64) DEFAULT NULL COMMENT '统一信用代码',
    `public_bank_name` varchar(32) DEFAULT NULL COMMENT '对公银行名称',
    `public_ban_account_number` varchar(32) DEFAULT NULL COMMENT '对公银行账号',
    `create_at` DATETIME NOT NULL COMMENT '创建时间',
    `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
    `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商:审核所需详细信息';



--供应商 附件
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
	`name` VARCHAR(16) NOT NULL COMMENT '采购人员工姓名', 
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号',
	`password` CHAR(32) NOT NULL COMMENT '登录密码',
	`purchaser_id` BIGINT(11) UNSIGNED COMMENT '采购人(法人)ID',	
	`state` INT(2) UNSIGNED COMMENT '审核状态:0-已注册,1-完善中,2-已提交,3-审核通过,4-审核失败',
	`role` INT(2) DEFAULT 'legalPerson' COMMENT '用户角色:0-法人,1-管理员,2-普通员工',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购人:法人及其员工基本(登录)信息';

-- 采购人 详情
DROP TABLE IF EXISTS `t_purchaser_detail_info`;
CREATE TABLE `t_purchaser_detail_info` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID', 
	`purchaser_id` BIGINT(11) UNSIGNED COMMENT '采购人(法人)ID',
	`company_name` varchar(64) DEFAULT NULL COMMENT '公司名称',
	`uniform_credit_code` varchar(64) DEFAULT NULL COMMENT '统一信用代码',
	`public_bank_name` varchar(32) DEFAULT NULL COMMENT '对公银行名称',
	`public_ban_account_number` varchar(32) DEFAULT NULL COMMENT '对公银行账号',
	`extended_field` varchar(128) DEFAULT NULL COMMENT '扩展字段',
    `create_at` DATETIME NOT NULL COMMENT '创建时间',
    `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
    `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购人:审核所需详细信息';

--私库：采购人--供应商
DROP TABLE IF EXISTS `t_purchaser_supplier`;
CREATE TABLE `t_purchaser_supplier` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号(登录账号)',
	`password` CHAR(32) NOT NULL COMMENT '登录密码',
	`state` INT(1) UNSIGNED COMMENT '0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败',
	`supplier_id` BIGINT(11)  NOT NULL COMMENT '角色Id',
	`supplier_name` VARCHAR(16) NOT NULL COMMENT '供应商名称',
	`source` CHAR(32)  NOT NULL COMMENT '来源(public,private)',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` BIT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购人-供应商:私库';


--私库：采购人--招标代理机构
DROP TABLE IF EXISTS `t_purchaser_agency`;
CREATE TABLE `t_purchaser_agency` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号(登录账号)',
	`password` CHAR(32) NOT NULL COMMENT '登录密码',
	`state` INT(1) UNSIGNED COMMENT '0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败',
	`supplier_id` BIGINT(11)  NOT NULL COMMENT '角色Id',
	`supplier_name` VARCHAR(16) NOT NULL COMMENT '招标代理机构名称',
	`source` CHAR(32)  NOT NULL COMMENT '来源(public,private)',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` BIT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购人-供应商:私库';

--私库：采购人--专家
DROP TABLE IF EXISTS `t_purchaser_expert`;
CREATE TABLE `t_purchaser_expert` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号(登录账号)',
	`password` CHAR(32) NOT NULL COMMENT '登录密码',
	`state` INT(1) UNSIGNED COMMENT '0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败',
	`supplier_id` BIGINT(11)  NOT NULL COMMENT '角色Id',
	`supplier_name` VARCHAR(16) NOT NULL COMMENT '专家姓名',
	`source` CHAR(32)  NOT NULL COMMENT '来源(public,private)',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` BIT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
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
	`name` VARCHAR(16) NOT NULL COMMENT '招标代理机构员工姓名',
	`agency_id` BIGINT(11) UNSIGNED COMMENT '招标(采购)代理机构 ID',		
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号',
	`password` CHAR(32) NOT NULL COMMENT '登录密码',
	`state` INT(2) UNSIGNED COMMENT '审核状态:0-已注册,1-完善中,2-已提交,3-审核通过,4-审核失败',
	`role` INT(2) DEFAULT 'legalPerson' COMMENT '用户角色:0-法人,1-管理员,2-普通员工',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
	`is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标(采购)代理机构:法人及其员工基本(登录)信息';


-- 招标(采购)代理机构 详情
DROP TABLE IF EXISTS `t_agency_detail_info`;
CREATE TABLE `t_agency_detail_info` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID', 
	`agency_id` BIGINT(11) UNSIGNED COMMENT '招标代理机构(法人)ID',
	`company_name` varchar(64) DEFAULT NULL COMMENT '公司名称',
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

-- 评标专家 注册
DROP TABLE IF EXISTS `t_expert_basic_info`;
CREATE TABLE `t_expert_basic_info` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
	`name` VARCHAR(16) NOT NULL COMMENT '评标专家姓名', 
	`cellphone` CHAR(11) NOT NULL COMMENT '手机号(登录账号)',
	`password` CHAR(32) NOT NULL COMMENT '登录密码',
	`expert_id` BIGINT(11) UNSIGNED COMMENT '采购人(法人)ID',
	`state` INT(1) UNSIGNED COMMENT '0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	`update_at` DATETIME NOT NULL COMMENT '最后修改时间',
    `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评标专家:基本(登录)信息';

-- 评标专家 详情
DROP TABLE IF EXISTS `t_expert_detail_info`;
CREATE TABLE `t_expert_detail_info` (
	`id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID', 
	`expert_id` BIGINT(11) UNSIGNED COMMENT '运营商法人ID',
	`company_name` varchar(64) DEFAULT NULL COMMENT '公司名称',
	`uniform_credit_code` varchar(64) DEFAULT NULL COMMENT '统一信用代码',
	`public_bank_name` varchar(32) DEFAULT NULL COMMENT '对公银行名称',
	`public_ban_account_number` varchar(32) DEFAULT NULL COMMENT '对公银行账号',
	`extended_field` varchar(128) DEFAULT NULL COMMENT '扩展字段',
    `create_at` DATETIME NOT NULL COMMENT '创建时间',
    `update_at` DATETIME NOT NULL COMMENT '最后修改时间',
    `is_deleted` INT(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评标专家:审核所需详细信息';

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


CREATE TABLE `t_project` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`purchaser_id` BIGINT(11) NOT NULL COMMENT '采购商(法人)ID',
	`name` VARCHAR(32) NOT NULL COMMENT '项目名称',
	`code` CHAR(32) NOT NULL COMMENT '项目编号',
	PRIMARY KEY(`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:项目信息';
DROP TABLE IF EXISTS `t_project`; 



CREATE TABLE `t_project_tender` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`project_id` BIGINT(11) NOT NULL COMMENT '项目ID',
	`title` VARCHAR(64) NOT NULL COMMENT '预告标题',
	`content` TEXT NOT NULL COMMENT '预告内容',
	`attachment_url` VARCHAR(128) DEFAULT NULL COMMENT '附件url',
	`creator` VARCHAR(16) NOT NULL COMMENT '创建人姓名',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:项目招标预告';
DROP TABLE IF EXISTS `t_project_tender`; 



--项目基本信息表：项目ID、采购商ID、项目名称、项目编号、项目介绍、项目投资总额、投资资金来源（国有投资、私有投资、国有占主体投资）、项目地址、项目分类、项目类型、经办人姓名、经办人联系方式、审核人姓名、审核人联系方式、是否委托代理机构、委托项目负责人、委托项目负责人联系方式、代理机构项目负责人、代理结构项目负责人联系方式、备注信息、创建时间、创建人、是否删除。


DROP TABLE IF EXISTS `t_purchase_project`; 


CREATE TABLE `t_project_evaluation` (
	`id` BIGINT(11) AUTO_INCREMENT COMMENT '主键ID',
	`purchaser_id` BIGINT(11) COMMENT '采购商(法人)ID',
	`supplier_id`BIGINT(11) COMMENT '供应商(法人)ID',
	`score` INT(1) NOT NULL COMMENT '评分',
	`content` TEXT COMMENT '评语',
	`creator` VARCHAR(16) NOT NULL COMMENT '创建人姓名',
	`create_at` DATETIME NOT NULL COMMENT '创建时间',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招标流程:采购项目评价';
DROP TABLE IF EXISTS `t_project_evaluation`; 

--采购项目评价表：评价ID、采购人ID、中标供应商名称、评分、评语、创建时间、创建人


