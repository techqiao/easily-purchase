package com.epc.web.facade.terdering.project.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleCreateProjectByAdmin implements Serializable {
    private static final long serialVersionUID = -8171927598256356072L;

    /**
     * CREATE TABLE `t_project_employee_relation` (
     *   `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '项目主键ID',
     *   `project_name` varchar(64) NOT NULL COMMENT '项目名字',
     *   `creater_id` BIGINT(11) NOT NULL COMMENT '创建项目人ID',
     *   `creater_name` varchar(64) DEFAULT NULL COMMENT '创建项目人姓名',
     *   `purchaser_id` BIGINT(32) DEFAULT NULL COMMENT '采购法人ID',
     *   `executive_id` BIGINT(11) unsigned DEFAULT NULL COMMENT '指派项目人负责人ID',
     *   `state` int(1) DEFAULT '0' COMMENT '当前项目状态,0-未接受, 1-已接受',
     *   `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     *   `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='项目人员指派关系表：不同的项目对应的指派的员工';
     */

    /**
     * 项目名字
     */
    private String projectName;
    /**
     * 当前指派人id(管理员id或是法人id)
     */
    private Long createrId;

    /**
     * 当前的角色 role(是法人还是管理员)
     */
    private Integer role;

    /**
     * 创建项目人 姓名
     */
    private String createrName;


    /**
     * 指派人的id(指派某个员工s)
     */
    private Long executiveId;

    /**
     * 指派人的姓名(指派某个员工s)
     */
    private String executiveName;




}
