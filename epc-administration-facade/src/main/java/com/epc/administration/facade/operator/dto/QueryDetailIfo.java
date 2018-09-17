package com.epc.administration.facade.operator.dto;

import com.epc.administration.facade.operator.handle.BaseDetailIfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

@ApiModel
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
