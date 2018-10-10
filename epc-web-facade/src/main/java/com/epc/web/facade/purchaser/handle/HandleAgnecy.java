package com.epc.web.facade.purchaser.handle;

import com.epc.web.facade.agency.handle.Attachement;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "HandleAgnecy", description = "录入代理机构")
@Data
public class HandleAgnecy implements Serializable {
    private static final long serialVersionUID = -319658786687249313L;

    /**
     * 用于接受数据库生成的的id
     */
    private Long agencyId;
    /**
     * 手机号
     */
    private String cellphone;
    /**
     * 密码
     */
    private String password;

    /**
     * 法人姓名
     */
    private String name;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 统一的信用代码
     */
    private String uniformCreditCode;
    /**
     * 对公银行name
     */
    private String publicBankName;
    /**
     * 对公银行账号
     */
    private String publicBankCount;

    /**
     * 操作人id
     */
    private long OperatorId;
    /**
     * 操作人公司的id
     */
    private long companyId;
    /**
     * 营业执照
     */
    private String businessLicense;
    /**
     * 身份证正面
     */
    private String legalIdCardPositive;
    /**
     * 身份证反面
     */
    private String legalIdCardOther;
    /**
     * 附件list
     */
    private List<Attachement> atts;
    /**
     * 公司地址
     */
    private String companyAddress;


    private String province;

    private String city;

    private String area;


//    @ApiModelProperty(value = "采购人Id")
//    private long userId;
//    @ApiModelProperty(value = "代理机构人员姓名")
//    private String name;
//    @ApiModelProperty(value = "公司名称")
//    private String companyName;
//    @ApiModelProperty(value = "统一信用代码")
//    private String uniformCreditCode;
//    @ApiModelProperty(value = "营业执照照片url")
//    private String businessLicense;
//    @ApiModelProperty(value = "法人身份证正面照片url")
//    private String legalIdCardPositive;
//    @ApiModelProperty(value = "法人身份证反面照片url")
//    private String legalIdCardOther;
//    @ApiModelProperty(value = "带公章的授权书照片url")
//    private String certificateOfAuthorization;
//    @ApiModelProperty(value = "经办人(运营商员工)手持身份证正面照片url")
//    private String operatorIdCardFront;
//    @ApiModelProperty(value = "资质证书url")
//    private String qualificationCertificate;
//    @ApiModelProperty(value = "对公银行名称")
//    private String publicBankName;
//    @ApiModelProperty(value = "对公银行账号")
//    private String publicBankCount;
//    @ApiModelProperty(value = "手机号")
//    @NotEmpty(message = "HandlePurchaser.cellPhone.null")
//    private String cellPhone;
//    @ApiModelProperty(value = "密码")
//    private String password;
//    @ApiModelProperty(value = "操作人Id")
//    private long OperatorId;
}
