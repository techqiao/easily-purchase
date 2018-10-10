package com.epc.web.facade.supplier.handle;


import lombok.Data;

import java.util.List;

/**
 * <p>Description : 角色完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : wjq
 */
@Data
public class RoleDetailInfo {

//    //系统 角色
//    private Integer systemRole;
//
//    // 登陆时的用户角色
//    private Integer loginRole;

    //员工（供应商id）0
    private Long supplierId;

    //法人姓名
//    private String name;

    //法人电话
    private String cellphone;

    //state
    private Integer state;

    //role
    private Integer role;


    //公司名字 0
    private String companyName;

    //公司地址
    private String companyAddress;

    //信用号码 0
    private String uniformCreditCode;

    //对公银行名称 0
    private String publicBankName;
    //对公银行号码 0
    private String publicBanAccountNumber;

    //创建时间
    private String createAt;

    //最后修改时间
    private String updateAt;



    //营业执照照片url
    private String businessLicense;
    private String businessLicenseNumber;
    private String businessLicenseName;
    private String businessLicenseType;

    //法人身份证正面照片url
    private String legalIdCardPositive;
    private String legalIdCardPositiveNumber;
    private String legalIdCardPositiveName;
    private String legalIdCardPositiveType;



    //法人身份证反面照片url
    private String legalIdCardOther;
    private String legalIdCardOtherName;
    private String legalIdCardOtherType;

    //带公章的授权书照片url
    private String certificateOfAuthorization;
    private String certificateOfAuthorizationNumber;
    private String certificateOfAuthorizationName;
    private String certificateOfAuthorizationType;

   // 经办人(运营商员工)手持身份证正面照片url
    private String operatorIdCardFront;
    private String operatorIdCardFrontNumber;
    private String operatorIdCardFrontName;
    private String operatorIdCardFrontType;

    //资质证书url
//    private String qualificationCertificate;
//    private String qualificationCertificateNumber;

    private List<QualificationCertificate> qcs;

//    private List<Attachment> atts;

}
