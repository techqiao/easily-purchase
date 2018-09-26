package com.epc.administration.client.controller.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @author 01
 * @date  2018-9-19 15:59:54
 */
@ApiModel
public class ClientQueryDetailIfo implements Serializable {
    private static final long serialVersionUID = 4260891879711559835L;
    @ApiModelProperty(value = "ID")
    @NotEmpty(message = "ClientQueryDetailIfo.whereid.null")
    private Long whereid;
    @ApiModelProperty(value = "公司名称")
    @NotEmpty(message = "ClientQueryDetailIfo.where.null")
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
