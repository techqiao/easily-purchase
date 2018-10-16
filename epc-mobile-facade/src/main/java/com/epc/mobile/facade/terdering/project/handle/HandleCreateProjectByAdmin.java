package com.epc.mobile.facade.terdering.project.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleCreateProjectByAdmin implements Serializable {
    private static final long serialVersionUID = -8171927598256356072L;

    /**
     * CREATE TABLE `t_purchaser_basic_info` (
     *   `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
     *   `name` varchar(16) NOT NULL COMMENT '采购人员工姓名',
     *   `cellphone` char(11) NOT NULL COMMENT '手机号',
     *   `password` char(32) NOT NULL COMMENT '登录密码',
     *   `purchaser_id` bigint(11) unsigned DEFAULT NULL COMMENT '采购人(法人)ID',
     *   `inviter_type` int(3) DEFAULT NULL COMMENT '邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构，4-平台',
     *   `inviter_id` bigint(11) DEFAULT NULL COMMENT '邀请人Id',
     *   `inviter_company_id` bigint(11) DEFAULT NULL COMMENT '邀请人机构ID',
     *   `state` int(3) unsigned DEFAULT NULL COMMENT '1-拉取 2-完善信息 3-审核中 4-禁用 5-审核通过',
     *   `role` int(2) DEFAULT NULL COMMENT '用户角色:0-法人,1-管理员,2-普通员工',
     *   `create_at` datetime NOT NULL COMMENT '创建时间',
     *   `update_at` datetime NOT NULL COMMENT '最后修改时间',
     *   `is_forbidden` int(1) DEFAULT '0' COMMENT '是否禁用: 0-启用,1-禁用',
     *   `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='采购人:法人及其员工基本(登录)信息';
     */

    private Integer loginRole;
    private Long loginId;
    private Long bossId;
    private String name;



    /**
     * 项目名字
     */
    private String projectName;


    /**
     * 指派人的id(指派某个员工s)
     */
    private Long executiveId;

    /**
     * 指派人的姓名(指派某个员工s)
     */
    private String executiveName;


    private String notes;
}
