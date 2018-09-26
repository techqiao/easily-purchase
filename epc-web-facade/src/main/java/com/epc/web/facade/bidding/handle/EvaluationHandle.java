package com.epc.web.facade.bidding.handle;


import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-25 13:20
 * <p>@Author : luozhixin
 * <p>EvaluationHandle
 */
@Data
public class EvaluationHandle implements Serializable {
    private static final long serialVersionUID = -2844846528104023743L;
    /**
     * 操作人id
     */
    private Long operateId;
    /**
     * 采购项目ID
     */
    private Long procurementProjectId;
    /**
     * 标段ID
     */
    private Long bidsId;
    /**
     * 评标方法文件url
     */
    private String filePath;
    /**
     * 废除条款
     */
    private  List<ClauseHandle> tenderAbolishClauseList;



}
