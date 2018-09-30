package com.epc.administration.facade.operator.dto;

import com.epc.common.QueryRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @author 01
 */
@ApiModel
@Data
public class QueryDetailIfo extends QueryRequest implements Serializable {
    private static final long serialVersionUID = -3855856242263856687L;
    private String where;
    private Integer status;


}
