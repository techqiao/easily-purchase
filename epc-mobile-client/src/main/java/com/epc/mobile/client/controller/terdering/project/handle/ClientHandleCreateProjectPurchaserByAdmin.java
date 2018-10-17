package com.epc.mobile.client.controller.terdering.project.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ClientHandleCreateProjectPurchaserByAdmin",description = "创建采购项目")
public class ClientHandleCreateProjectPurchaserByAdmin {

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



    /**
     *  所属项目ID
     */
    @ApiModelProperty(value = "所属项目ID")
    private Long projectId;
    /**
     * 采购项目名字
     */
    @ApiModelProperty(value = "采购项目名字")
    private String projectPurchaserName;

    /**
     * 经办人的id
     */
    @ApiModelProperty(value = "经办人的id")
    private Long executiveId;

    /**
     * 经办人的姓名
     */
    @ApiModelProperty(value = "经办人的姓名")
    private String executiveName;

    //批复人id
    @ApiModelProperty(value = "批复人id")
    private Long approvalId;
    //批复人名字
    @ApiModelProperty(value = "批复人名字")
    private String approvalName;

    //审核 人
    @ApiModelProperty(value = "审核 人")
    private Long checkId;
    //审核 人 姓名
    @ApiModelProperty(value = "审核 人 姓名")
    private String checkName;

    @ApiModelProperty(value = "备注")
    private String notes;




}
