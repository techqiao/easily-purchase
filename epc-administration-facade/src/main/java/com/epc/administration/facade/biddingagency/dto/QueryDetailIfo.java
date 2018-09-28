package com.epc.administration.facade.biddingagency.dto;

import com.epc.administration.facade.biddingagency.handle.BaseDetailIfo;
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
    private static final long serialVersionUID = 5533344554793829363L;
    private String whereName;
    private Integer status;
}
