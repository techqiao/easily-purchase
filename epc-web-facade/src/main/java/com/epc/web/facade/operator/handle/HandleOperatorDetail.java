package com.epc.web.facade.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 运营商注册详情
 */
@Data
public class HandleOperatorDetail implements Serializable {

    private static final long serialVersionUID = 4284847845112939775L;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 统一信用代码
     */
    private String uniformCreditCode;

    /**
     * 营业执照照片url
     */
    private String businessLicense;

    /**
     * 法人身份证正面照片url
     */
    private String legalIdCardPositive;

    /**
     * 法人身份证反面照片url
     */
    private String legalIdCardOther;

    /**
     * 带公章的授权书照片url
     */
    private String certificateOfAuthorization;

    /**
     * 经办人(运营商员工)手持身份证正面照片url
     */
    private String operatorIdCardFront;

    /**
     * 资质证书url
     */
    private String qualificationCertificate;

    /**
     * 对公银行名称
     */
    private String publicBankName;

    /**
     * 对公银行账号
     */
    private String publicBanAccountNumber;

    /**
     * 手机号
     */
    private String cellPhone;

    /**
     * 密码
     */
    private String password;







}
