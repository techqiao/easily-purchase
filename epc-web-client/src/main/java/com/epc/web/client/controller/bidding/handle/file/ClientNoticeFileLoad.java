package com.epc.web.client.controller.bidding.handle.file;

import com.epc.web.facade.bidding.handle.BasePretriaFile;
import com.epc.web.facade.bidding.handle.Entrust;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("投标文件详情")
public class ClientNoticeFileLoad {
    @ApiModelProperty("投标文件记录id")
    private Long id;
    @ApiModelProperty("标段Id")
    private Long bidsId;
    @ApiModelProperty("标段名称")
    private String bidsName;
    @ApiModelProperty("委托人姓名")
    private String delegator;
    @ApiModelProperty("委托人身份证")
    private String identitCard;
    @ApiModelProperty("委托书路径")
    private String bailmentPath;
    @ApiModelProperty("投标附录路径")
    private String bidAppendix;
    @ApiModelProperty("投标文件列表")
    private List<BasePretriaFile> filePathList;
    @ApiModelProperty("委托书信息")
    private Entrust entrust;
}
