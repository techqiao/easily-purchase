package com.epc.administration.facade.operator.dto;

import com.epc.common.QueryRequest;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 01
 */
@ApiModel
@Data
public class QueryDetailIfo extends QueryRequest implements Serializable {
    private static final long serialVersionUID = -3855856242263856687L;
    /**
     * 条件
     */
    private String where;
    /**
     * 状态
     */
    private Integer status;


}
