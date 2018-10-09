package com.epc.web.client.controller.operator.handle;

import com.epc.web.client.controller.supplier.handle.ClientQualificationCertificate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

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

@Api(value = "ClientHandleCreatePurchaserByOperator", description = "运营商添加采购人员信息")
@Data
public class ClientHandleCreatePurchaserByOperator {

    @ApiModelProperty(value = "运营商的主键id")
    @NotEmpty(message = "ClientHandleCreatePurchaserByOperator.id.null")
    private Long id;

//    @ApiModelProperty(value = "采购人姓名")
//    @NotEmpty(message = "ClientHandleCreatePurchaserByOperator.name.null")
//    private String name;

//    @ApiModelProperty(value = "手机号")
//    @NotEmpty(message = "ClientHandleCreatePurchaserByOperator.cellphone.null")
//    private String cellphone;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "统一信用代码")
    private String uniformCreditCode;

    @ApiModelProperty(value = "对公银行名称")
    private String publicBankName;

    @ApiModelProperty(value = "对公银行账号")
    private String publicBanAccountNumber;



    @ApiModelProperty(value = "营业执照照片url")
    private String businessLicense;
    @ApiModelProperty(value = "营业执照号码")
    private String businessLicenseNumber;

    @ApiModelProperty(value = "法人身份证正面照片url")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证号码")
    private String legalIdCardPositiveNumber;


    @ApiModelProperty(value = "法人身份证反面照片url")
    private String legalIdCardOther;

    @ApiModelProperty(value = "带公章的授权书照片url")
    private String certificateOfAuthorization;
    @ApiModelProperty(value = "带公章的授权书号码")
    private String certificateOfAuthorizationNumber;

    @ApiModelProperty(value = "经办人(运营商员工)手持身份证正面照片url")
    private String operatorIdCardFront;
    @ApiModelProperty(value = "经办人(运营商员工)手持身份证号码")
    private String operatorIdCardFrontNumber;

    //资质证书url
//    private String qualificationCertificate;
//    private String qualificationCertificateNumber;

    @ApiModelProperty(value = "资质证书s")
    private List<ClientQualificationCertificate> qcs;

//    @ApiModelProperty(value = "多个附件信息")
//    private List<ClientAttachment> atts;


}
