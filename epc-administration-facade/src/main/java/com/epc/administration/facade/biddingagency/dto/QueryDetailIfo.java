package com.epc.administration.facade.biddingagency.dto;

import com.epc.common.QueryRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 01
 */
@Data
public class QueryDetailIfo  extends QueryRequest implements Serializable {
    private static final long serialVersionUID = 5533344554793829363L;
    /**
     * 条件
     */
    private String where;
    /**
     * 状态
     */
    private Integer status;
}
