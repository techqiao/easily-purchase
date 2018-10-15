package com.epc.web.facade.supplier.query;

import com.epc.common.QueryRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-04 13:31
 * <p>@Author : luozhixin
 * <p>QuerywithPageHandle
 */
@Data
public class QuerywithPageHandle extends QueryRequest implements Serializable {
    private static final long serialVersionUID = 6599949161649152523L;
    private String projectName;
    private String status;
    /**
     * 用户id
     */
    private Long userId;
    private Long bossId;
}
