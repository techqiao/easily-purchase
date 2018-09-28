package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;

/**
* @Description:    运营商录入采购人
* @Author:          linzhixiang
* @CreateDate:     2018/9/13 10:00
* @UpdateUser:     linzhixiang
* @UpdateDate:     2018/9/13 10:00
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Data
public class HandleCreatePurchaserByOperator implements Serializable {
    private static final long serialVersionUID = 5221353786072352076L;

    //运营商的主键id
    private Long id;

    //采购人姓名
    private String name;

    //手机号
    private String cellphone;

    //来源
    private String source;

    //公司名称
    private String companyName;

    //统一信用代码
    private String uniformCreditCode;

    //营业执照照片url
    private String businessLicense;

    //法人身份证正面照片url
    private String legalIdCardPositive;

    //法人身份证反面照片url
    private String legalIdCardOther;

    //带公章的授权书照片url
    private String certificateOfAuthorization;

    //经办人(运营商员工)手持身份证正面照片url
    private String operatorIdCardFront;

    //资质证书url
    private String qualificationCertificate;

    //对公银行名称
    private String publicBankName;

    //对公银行账号
    private String publicBankCount;



}
