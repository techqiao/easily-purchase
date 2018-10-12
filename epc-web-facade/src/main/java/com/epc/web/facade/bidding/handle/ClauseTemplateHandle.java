package com.epc.web.facade.bidding.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-11 22:04
 * <p>@Author : luozhixin
 */
@Data
public class ClauseTemplateHandle implements Serializable {
    private static final long serialVersionUID = -8555777929472702921L;

    /**
     *废除条款模板url
     */
    private  String filePath;
    /**
     *废除条款模板名称
     */
    private String clauseName;
}
