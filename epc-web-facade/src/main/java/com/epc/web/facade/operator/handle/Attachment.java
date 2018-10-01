package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * -- 采购人 附件表
 * DROP TABLE IF EXISTS `t_purchaser_attachment`;
 * CREATE TABLE  `t_purchaser_attachment`(
 *   `id` BIGINT(11) UNSIGNED AUTO_INCREMENT COMMENT '主键ID',
 * 	`purchaser_id` BIGINT(11) UNSIGNED COMMENT '采购人法人ID',
 * 	`certificate_type` varchar(64) DEFAULT NULL COMMENT '附件类型',
 * 	`certificate_file_path` varchar(200) NOT NULL COMMENT '附件url',
 * 	`certificate_number` varchar(64) DEFAULT NULL COMMENT '附件号码',
 * 	`certificate_name` varchar(64) DEFAULT NULL COMMENT '附件对应证书名称',
 * 	`create_at` datetime NOT NULL COMMENT '创建时间',
 * 	`update_at` datetime NOT NULL COMMENT '最后修改时间',
 * 	`is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
 * 	PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购人:附件表';
 */

@Data
public class Attachment implements Serializable {
    private static final long serialVersionUID = 6578015408669319489L;



    //附件类型
    private String certificateType;
    //附件url
    private String certificateFilePath;
    //附件号码
    private String certificateNumber;
    //附件对应证件名称
    private String certificateName;





}
