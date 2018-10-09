package com.epc.web.client.controller.terdering.preview.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-21 20:30
 * <p>@Author : luozhixin
 * <p>ClientQueryPreviewOneDTO
 */
@ApiModel("预告详情")
@Data
public class ClientQueryPreviewOneDTO {
    @ApiModelProperty("预告ID")
    @NotEmpty(message = "ClientQueryPreviewOneDTO.previewId.null")
    private Long previewId;
}
