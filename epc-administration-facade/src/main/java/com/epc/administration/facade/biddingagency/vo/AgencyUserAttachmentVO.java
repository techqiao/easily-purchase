package com.epc.administration.facade.biddingagency.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 09:30
 * <p>@Author : luozhixin
 * <p>AgencyUserAttachmentVO
 */
@Data
public class AgencyUserAttachmentVO extends BiddingAgencyVO implements Serializable {

    private static final long serialVersionUID = 6869267792661617405L;

    @ApiModelProperty("附件集合")
    private List<AgencyAttachmentVO> agencyAttachmentVOS;
    @ApiModelProperty(value = "身份证正面照片url")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "身份证反面照片url")
    private String legalIdCardOther;
    @ApiModelProperty(value = "营业执照照片url")
    private String businessLicense;

}
