package com.epc.administration.facade.operator.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @author 01
 */
@ApiModel
public class QueryDetailIfo implements Serializable {
    private static final long serialVersionUID = -3855856242263856687L;
    private Long whereid;
    private String where;

    public Long getWhereid() {
        return whereid;
    }

    public void setWhereid(Long whereid) {
        this.whereid = whereid;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    @Override
    public String toString() {
        return "ClientQueryDetailIfo{" +
                "whereid=" + whereid +
                ", where='" + where + '\'' +
                '}';
    }
}
