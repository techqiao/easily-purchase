package com.epc.administration.facade.reviewexpert.dto;

import com.epc.administration.facade.reviewexpert.handle.BaseDetailIfo;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class QueryDetailIfo  extends BaseDetailIfo implements Serializable {
    private static final long serialVersionUID = -2700386072907969847L;
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
