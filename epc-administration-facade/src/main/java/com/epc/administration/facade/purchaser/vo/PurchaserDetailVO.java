package com.epc.administration.facade.purchaser.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-03 21:35
 * <p>@Author : luozhixin
 * <p>PurchaserDetailVO
 */
@Data
public class PurchaserDetailVO extends PurchaserVO implements Serializable {
    private static final long serialVersionUID = 8013013325692539114L;

    @ApiModelProperty("公司地址")
    private  String companyAddress;
    @ApiModelProperty("省份")
    private String province;
    @ApiModelProperty("市区")
    private String city;
    @ApiModelProperty("区域")
    private String area;
    @ApiModelProperty(value = "身份证正面照片url")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "身份证反面照片url")
    private String legalIdCardOther;
    @ApiModelProperty(value = "营业执照照片url")
    private String businessLicense;
    @ApiModelProperty(value = "资格证书集合")
    private List<AttachmentVO> attachmentVOS;
}
