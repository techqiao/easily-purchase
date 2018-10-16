package com.epc.mobile.facade.terdering.project.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleCreateProjectPurchaserByAdmin implements Serializable {
    private static final long serialVersionUID = 3091843061456247976L;

    /**
     * CREATE TABLE `t_project_purchaser_employee_relation` (
     *   `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '采购项目主键ID',
     *   `project_id` bigint(11) NOT NULL COMMENT '所属项目ID',
     *   `purchaser_id` bigint(32) NOT NULL COMMENT '采购法人ID',
     *   `project_purchaser_name` varchar(64) NOT NULL COMMENT '采购项目名字',
     *   `executive_id` bigint(11) unsigned NOT NULL COMMENT '指派经办人ID',
     *   `executive_name` varchar(64) NOT NULL COMMENT '指派经办人姓名',
     *   `approval_id` bigint(11) unsigned NOT NULL COMMENT '指派批复人ID',
     *   `approval_name` varchar(64) NOT NULL COMMENT '指派批复人姓名',
     *   `check_id` bigint(11) unsigned NOT NULL COMMENT '指派审核人ID',
     *   `check_name` varchar(64) NOT NULL COMMENT '指派审核人姓名',
     *   `state` int(1) DEFAULT '0' COMMENT '当前项目状态,0-进行中, 1-已完成',
     *   `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     *   `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
     *   `notes` varchar(64) DEFAULT NULL COMMENT '备用字段',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='采购项目人员指派关系表：不同的采购项目对应的指派的员工';
     */



//    private Integer loginRole;
    private Long loginId;
    private Long bossId;


    /**
     *  所属项目ID
     */
    private Long projectId;
    /**
     * 采购项目名字
     */
    private String projectPurchaserName;

    /**
     * 经办人的id(指派某个员工s)
     */
    private Long executiveId;

    /**
     * 经办人的姓名(指派某个员工s)
     */
    private String executiveName;

    //批复人id
    private Long approvalId;
    //批复人名字
    private String approvalName;

    //审核 人
    private Long checkId;
    //审核 人 姓名
    private String checkName;

    private String notes;




}
