package com.epc.web.client.controller.bidding.handle.evaluation;



import com.epc.web.facade.bidding.handle.TechnologyHandle;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-25 13:40
 * <p>@Author : luozhixin
 * <p>ClientEvaluationHandle
 */
@Data
public class ClientEvaluationHandle {

    /**
     * 采购项目ID
     */
    @ApiModelProperty(value = "采购项目ID")
    @NotEmpty(message = "ClientEvaluationHandle.procurementProjectId.null")
    private Long procurementProjectId;

    /**
     * 标段ID
     */
    @ApiModelProperty(value = "标段ID")
    @NotEmpty(message = "ClientEvaluationHandle.bidsId.null")
    private Long bidsId;

    /**
     * 审核人ID
     */
    @ApiModelProperty(value = "审核人ID")
    @NotEmpty(message = "ClientEvaluationHandle.auditorId.null")
    private Long auditorId;

    /**
     * 批复人ID
     */
    @ApiModelProperty(value = "批复人ID")
    @NotEmpty(message = "ClientEvaluationHandle.repliesId.null")
    private Long repliesId;

    /**
     * 评标办法
     */
    @ApiModelProperty(value = "评标办法 list集合")
    @NotEmpty(message = "ClientEvaluationHandle.priceBidEvaluationMethod.null")
    private List priceBidEvaluationMethod;

    /**
     * 评审因素
     */
    @ApiModelProperty(value = "评审因素 办法名对应因素 Map<String,List<ClientTechnologyHandle>>集合")
    @NotEmpty(message = "ClientEvaluationHandle.clientTechnologyHandle.null")
    private List<ClientTechnologyHandle> technologyHandleList;

    /**
     * 废除条款
     */
    @ApiModelProperty(value = "废除条款")
    private  String tenderAbolishClause;
}
