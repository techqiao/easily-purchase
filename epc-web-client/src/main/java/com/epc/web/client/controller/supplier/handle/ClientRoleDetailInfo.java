package com.epc.web.client.controller.supplier.handle;


import lombok.Data;

/**
 * <p>Description : 角色完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : wjq
 */
@Data
public class ClientRoleDetailInfo {

    /**
     * CREATE TABLE `t_supplier_attachment` (
     *   `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
     *   `supplier_id` bigint(11) unsigned DEFAULT NULL COMMENT '运营商法人ID',
     *   `certificate_type` varchar(64) DEFAULT NULL COMMENT '附件类型',
     *   `certificate_file_path` varchar(200) NOT NULL COMMENT '附件url',
     *   `certificate_number` varchar(64) DEFAULT NULL COMMENT '附件号码',
     *   `certificate_name` varchar(64) DEFAULT NULL COMMENT '附件对应证书名称',
     *   `create_at` datetime NOT NULL COMMENT '创建时间',
     *   `update_at` datetime NOT NULL COMMENT '最后修改时间',
     *   `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商:附件信息';
     */

    private String systemRole;
    private Long userId;
    private String companyName;
    private String publicBankName;
    private String publicBanAccountNumber;
    private String qualificationCertificate;
    private String businessLicense;
    private String legalIdCardPositive;
    private String legalIdCardOther;
    private String certificateOfAuthorization;
    private String operatorIdCardFront;

}
