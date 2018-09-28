package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

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
@ApiModel(value = "ClientHandleCreatePurchaserByOperator", description = "运营商添加采购人员信息")
public class ClientHandleCreatePurchaserByOperator {

    @ApiModelProperty(value = "运营商的主键id")
    @NotEmpty(message = "ClientHandleCreatePurchaserByOperator.id.null")
    private Long id;

    @ApiModelProperty(value = "采购人姓名")
    @NotEmpty(message = "ClientHandleCreatePurchaserByOperator.name.null")
    private String name;

    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "ClientHandleCreatePurchaserByOperator.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "统一信用代码")
    private String uniformCreditCode;

    @ApiModelProperty(value = "营业执照照片url")
    private String businessLicense;

    @ApiModelProperty(value = "法人身份证正面照片url")
    private String legalIdCardPositive;

    @ApiModelProperty(value = "法人身份证反面照片url")
    private String legalIdCardOther;

    @ApiModelProperty(value = "带公章的授权书照片url")
    private String certificateOfAuthorization;

    @ApiModelProperty(value = "经办人(运营商员工)手持身份证正面照片url")
    private String operatorIdCardFront;

    @ApiModelProperty(value = "资质证书url")
    private String qualificationCertificate;

    @ApiModelProperty(value = "对公银行名称")
    private String publicBankName;

    @ApiModelProperty(value = "对公银行账号")
    private String publicBankCount;



}
