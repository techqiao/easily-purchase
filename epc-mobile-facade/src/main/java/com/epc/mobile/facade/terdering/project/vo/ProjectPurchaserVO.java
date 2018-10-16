package com.epc.mobile.facade.terdering.project.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value = "ProjectPurchaserVO",description = "采购项目表")
@Data
public class ProjectPurchaserVO {

    /**
     * CREATE TABLE `t_project_purchaser_employee_relation` (
     *   `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '采购项目主键ID',
     *   `project_id` bigint(11) NOT NULL COMMENT '所属项目ID',
     *   `project_purchaser_name` varchar(64) NOT NULL COMMENT '采购项目名字',
     *   `creater_id` bigint(11) NOT NULL COMMENT '创建项目人ID',
     *   `creater_name` varchar(64) DEFAULT NULL COMMENT '创建项目人姓名',
     *   `purchaser_id` bigint(32) DEFAULT NULL COMMENT '采购法人ID',
     *   `executive_id` bigint(11) unsigned DEFAULT NULL COMMENT '指派项目人负责人ID',
     *   `state` int(1) DEFAULT '0' COMMENT '当前项目状态,0-进行中, 1-已完成',
     *   `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     *   `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='采购项目人员指派关系表：不同的采购项目对应的指派的员工';
     */

    @ApiModelProperty(value = "所属项目ID")
    private Long id;

    @ApiModelProperty(value = "采购项目名字")
    private String projectPurchaserName;

    @ApiModelProperty(value = "创建项目人ID")
    private Long createrId;

    @ApiModelProperty(value = "创建项目人姓名")
    private String createName;

    @ApiModelProperty(value = "指派项目负责人id")
    private Long executiveId;

    @ApiModelProperty(value = "指派项目负责人名字")
    private String executiveName;

    @ApiModelProperty(value = "采购项目创建时间")
    private String createAt;

    @ApiModelProperty(value = "当前项目状态")
    private Integer state;

}
