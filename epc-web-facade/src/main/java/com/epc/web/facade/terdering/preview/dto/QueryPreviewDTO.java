package com.epc.web.facade.terdering.preview.dto;

import com.epc.common.PagerParam;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-9-20 17:53:16
 * <p>@Author : luozhixin
 */
@Data
public class QueryPreviewDTO extends PagerParam implements Serializable {

    private static final long serialVersionUID = -7605223737772855177L;
    private Long previewId;

    public Long getPreviewId() {
        return previewId;
    }

    public void setPreviewId(Long previewId) {
        this.previewId = previewId;
    }
}
