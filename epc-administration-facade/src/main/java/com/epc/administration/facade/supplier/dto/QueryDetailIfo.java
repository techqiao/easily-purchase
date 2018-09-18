package com.epc.administration.facade.supplier.dto;

import com.epc.administration.facade.supplier.handle.BaseDetailIfo;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class QueryDetailIfo  extends BaseDetailIfo {
    @ApiModelProperty(value = "ID")
    @NotEmpty(message = "QueryDetailIfo.userId.null")
    private Long Id;
    @ApiModelProperty(value = "模糊名称")
    @NotEmpty(message = "QueryDetailIfo.where.null")
    private String where;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    @Override
    public String toString() {
        return "QueryDetailIfo{" +
                "Id=" + Id +
                ", where='" + where + '\'' +
                '}';
    }
}