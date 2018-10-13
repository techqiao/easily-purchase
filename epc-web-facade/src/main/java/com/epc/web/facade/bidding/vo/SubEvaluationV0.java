package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-12 10:55
 * <p>@Author : wjq
 */
@ApiModel("评标VO")
@Data
public class SubEvaluationV0 {
    @ApiModelProperty("招标文件附件下载url")
    private String biddingDocumentsDownloadUrl;
    @ApiModelProperty("评标标准设定")
    private List<EvaluationVO> evaluationV0List;
}
