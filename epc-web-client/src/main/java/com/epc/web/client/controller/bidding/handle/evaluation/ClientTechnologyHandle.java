package com.epc.web.client.controller.bidding.handle.evaluation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 评审因素
 * <p>Description : easilys
 * <p>Date : 2018-09-25 14:49
 * <p>@Author : luozhixin
 * <p>
 */
@Data
public class ClientTechnologyHandle {
    /**
     * 废标条款模板ID
     */
    @ApiModelProperty(value = "废标条款模板ID")
    private Long templateId;

}
