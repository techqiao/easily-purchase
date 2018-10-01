package com.epc.web.facade.purchaser.handle;

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
@ApiModel(value = "HandlePurchaser", description = "采购人员信息")
public class HandlePurchaser {
    @ApiModelProperty(value = "采购人Id")
    private long userId;
    @ApiModelProperty(value = "采购人姓名")
    @NotEmpty(message = "HandlePurchaser.name.null")
    private String name;
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
    @ApiModelProperty(value = "手机号")
    private String cellPhone;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "操作人Id")
    private long OperatorId;
    private Integer role;
}
