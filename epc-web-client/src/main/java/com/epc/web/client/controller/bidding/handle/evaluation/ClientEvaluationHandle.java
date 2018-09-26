package com.epc.web.client.controller.bidding.handle.evaluation;



import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-25 13:40
 * <p>@Author : luozhixin
 * <p>ClientEvaluationHandle
 */
@Data
public class ClientEvaluationHandle {
    private static final long serialVersionUID = -2844846528104023743L;

    /**
     * 评标方法文件url
     */
    @ApiModelProperty(value = "评标方法文件url")
    @NotEmpty(message = "ClientEvaluationHandle.filePath.null")
    private String filePath;
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
     * 评标方法类型 商务评标 技术评标
     */
    @ApiModelProperty(value = "评标方法类型")
    private List<ClientStandardTypeHandle> standardType;

    /**
     * 废除条款
     */
    @ApiModelProperty(value = "评标方法文件url")
    private  List<ClientTechnologyHandle> tenderAbolishClauseList;


}
