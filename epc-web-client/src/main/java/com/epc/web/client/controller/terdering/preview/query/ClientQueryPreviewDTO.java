package com.epc.web.client.controller.terdering.preview.query;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 18:18
 * <p>@Author : luozhixin
 * <p>ClientQueryPreviewDTO
 */
@Data
public class ClientQueryPreviewDTO extends PagerParam implements Serializable {

    private static final long serialVersionUID = -1588904142238429653L;

    @ApiModelProperty("项目编号")
    @NotEmpty(message = "ClientQueryPreviewDTO.previewId.null")
    private Long previewId;


}
