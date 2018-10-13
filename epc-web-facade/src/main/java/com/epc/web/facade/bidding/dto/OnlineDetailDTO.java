package com.epc.web.facade.bidding.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel("线上详情")
public class OnlineDetailDTO implements Serializable {

    @ApiModelProperty("招标公告url")
    private String announcementUrl;

    @ApiModelProperty("投标人须知")
    private String noticeBidderUrl;

    @ApiModelProperty("技术要求url")
    private String technicalRequirementUrl;

    @ApiModelProperty("合同主要条款url")
    private String termsContractUrl;

    @ApiModelProperty("评标标准url")
    private String evaluationUrl;
}
