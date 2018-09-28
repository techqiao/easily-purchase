package com.epc.web.client.controller.terdering.preview.query;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-21 20:30
 * <p>@Author : luozhixin
 * <p>ClientQueryPreviewOneDTO
 */
public class ClientQueryPreviewOneDTO {
    @ApiModelProperty("项目编号")
    @NotEmpty(message = "ClientQueryPreviewOneDTO.previewId.null")
    private Long previewId;

    public Long getPreviewId() {
        return previewId;
    }

    public void setPreviewId(Long previewId) {
        this.previewId = previewId;
    }
}
