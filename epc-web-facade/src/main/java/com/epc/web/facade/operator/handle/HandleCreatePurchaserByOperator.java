package com.epc.web.facade.operator.handle;

import com.epc.web.facade.supplier.handle.QualificationCertificate;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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


    //运营商员工id
//    private Long id;
    /**
     *  是什么角色
     */
//    private Integer systemRole;

    // 登陆时的用户角色
//    private Integer loginRole;

    // 当前 登陆人的法人 id
//    private Long bossId;



    //当前添加的采购人id    (从前端列表中获取)
    private Long supplierId;

    //采购人姓名
//    private String name;

    //手机号
//    private String cellphone;

    private String province;

    private String city;

    private String area;

    //公司地址
    private String companyAddress;

    //公司名称
    private String companyName;

    //统一信用代码
    private String uniformCreditCode;

    //对公银行名称
    private String publicBankName;

    //对公银行账号
    private String publicBanAccountNumber;


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

    //资质证书url
//    private String qualificationCertificate;
//    private String qualificationCertificateNumber;

    private List<QualificationCertificate> qcs;

//    private List<Attachment> atts;




}
