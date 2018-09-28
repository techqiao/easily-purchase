package com.epc.administration.facade.reviewexpert.dto;

import com.epc.administration.facade.reviewexpert.handle.BaseDetailIfo;
import com.epc.common.QueryRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @author 01
 */
@Data
public class QueryDetailIfo  extends QueryRequest implements Serializable {
    private static final long serialVersionUID = -2700386072907969847L;
    private String whereName;
    private Integer status;

}
