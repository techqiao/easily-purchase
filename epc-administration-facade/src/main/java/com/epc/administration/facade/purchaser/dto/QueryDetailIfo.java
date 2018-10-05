package com.epc.administration.facade.purchaser.dto;

import com.epc.common.QueryRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 01
 */
@Data
public class QueryDetailIfo  extends QueryRequest implements Serializable {
    private static final long serialVersionUID = 739475132750641686L;
    /**
     * 条件
     */
    private String where;
    /**
     * 状态
     */
    private Integer status;
}
