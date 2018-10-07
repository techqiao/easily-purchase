package com.epc.web.facade.supplier.vo;

import com.epc.web.facade.operator.handle.Attachment;
import com.epc.web.facade.supplier.handle.QualificationCertificate;
import com.epc.web.facade.supplier.handle.RoleDetailInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SupplierAttachmentAndDetailVO implements Serializable {
    private static final long serialVersionUID = 4416477502214082289L;

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

    /**
     * CREATE TABLE `t_supplier_detail_info` (
     *   `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
     *   `supplier_id` bigint(11) unsigned DEFAULT NULL COMMENT '采购人(法人)ID',
     *   `company_name` varchar(64) DEFAULT NULL COMMENT '公司名称',
     *   `uniform_credit_code` varchar(64) DEFAULT NULL COMMENT '统一信用代码',
     *   `public_bank_name` varchar(32) DEFAULT NULL COMMENT '对公银行名称',
     *   `public_ban_account_number` varchar(32) DEFAULT NULL COMMENT '对公银行账号',
     *   `create_at` datetime DEFAULT NULL COMMENT '创建时间',
     *   `update_at` datetime DEFAULT NULL COMMENT '最后修改时间',
     *   `is_deleted` int(1) DEFAULT '0' COMMENT '是否删除: 0-存在,1-删除',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='供应商:审核所需详细信息';
     */

    private Long id;

    //供应商法人ID
    private Long supplierId;

    //法人姓名
    private String name;

    //法人电话
    private String cellphone;

    //state
    private Integer state;

    //role
    private Integer role;

    //附件信息
//    private RoleDetailInfo roleDetailInfo;

    //公司名称
    private String companyName;

    //统一信用代码
    private String uniformCreditCode;

    //对公银行名称
    private String publicBankName;

    //对公银行账号
    private String publicBanAccountNumber;

    //创建时间
    private String createAt;

    //最后修改时间
    private String updateAt;


    //资质证书url
//    private String qualificationCertificate;
//    private String qualificationCertificateNumber;

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

    private List<QualificationCertificate> qcs;

    //    private List<Attachment> atts;

}
