package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author linzhixiang
 */
@Data
@ApiModel(value = "获取标段列表及保证金支付情况")
public class QueryTenderMoneyRecordVO implements Serializable {
    private static final long serialVersionUID = 5929308159997874094L;
    @ApiModelProperty("采购项目Id")
    private Long procurementProjectId;
    @ApiModelProperty("发售招标文件记录Id")
    private Long id;
    @ApiModelProperty("投标保证金截止时间")
    private Date biddingBondEndTime;
    @ApiModelProperty("标段ID")
    private Long bidsId;
    @ApiModelProperty("标段名称")
    private String bidsName;
    @ApiModelProperty("投标保证金")
    private BigDecimal tenderGuaranteeAmount;
    @ApiModelProperty("开户行帐号")
    private String bankAccount;
    @ApiModelProperty("收款单位")
    private String receivables;
    @ApiModelProperty("投标人单位ID")
    private Long tendererCompanyId;
    @ApiModelProperty("到账金额")
    private BigDecimal  amountMoney;
    @ApiModelProperty("创建时间")
    private Date createAt;
}
