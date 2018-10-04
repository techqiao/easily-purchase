package com.epc.web.facade.terdering.preview.handle;


import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:18
 * <p>@Author : luozhixin
 * <p>PreviewHandle
 */
@Data
public class PreviewHandle implements Serializable {
    private String projectCode;
    private String projectName;
    private Long projectId;
    private String previewTitle;
    private String previewMemo;
    private Long purchaserId;
    private String creator;
    private Long setOperateId;
}
