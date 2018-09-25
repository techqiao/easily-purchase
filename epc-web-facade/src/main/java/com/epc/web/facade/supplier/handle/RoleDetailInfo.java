package com.epc.web.facade.supplier.handle;


import lombok.Data;

/**
 * <p>Description : 角色完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : wjq
 */
@Data
public class RoleDetailInfo {

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

    //角色
    private String systemRole;

    //供应商id
    private Long supplierId;

    //法人姓名
    private String name;

    //公司名字
    private String companyName;

    //信用号码
    private String uniformCreditCode;

    //对公银行名称
    private String publicBankName;
    //对公银行号码
    private String publicBanAccountNumber;

    //资质证书url
    private String qualificationCertificate;
    private String qualificationCertificateNumber;

    //营业执照照片url
    private String businessLicense;
    private String businessLicenseNumber;

    //法人身份证正面照片url
    private String legalIdCardPositive;
    private String legalIdCardPositiveNumber;


    //法人身份证反面照片url
    private String legalIdCardOther;

    //带公章的授权书照片url
    private String certificateOfAuthorization;
    private String certificateOfAuthorizationNumber;

   // 经办人(运营商员工)手持身份证正面照片url
    private String operatorIdCardFront;
    private String operatorIdCardFrontNumber;

}
