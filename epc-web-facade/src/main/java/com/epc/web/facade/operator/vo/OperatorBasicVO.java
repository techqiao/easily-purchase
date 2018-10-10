package com.epc.web.facade.operator.vo;

import com.epc.web.facade.supplier.handle.QualificationCertificate;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class OperatorBasicVO implements Serializable {
    private static final long serialVersionUID = 2041338696895334089L;


    /**
     * 主键ID
     */
//    private Long id;

    /**
     * 手机号
     */
    private String cellphone;

    /**
     * 运营商员工姓名
     */
    private String name;

    //state
    private Integer state;
    /**
     * 用户角色:0-法人,1-管理员,2-普通员工
     */
    private Integer role;

    /**
     * 创建时间
     */
    private String createAt;

    /**
     * 最后修改时间
     */
    private String updateAt;


    private Long operatorId;

    private String companyName;

    //公司地址
    private String companyAddress;

    private String uniformCreditCode;

    private String publicBankName;

    private String publicBanAccountNumber;

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

    private List<QualificationCertificate> qcs;

//    private List<Attachment> atts;

}
