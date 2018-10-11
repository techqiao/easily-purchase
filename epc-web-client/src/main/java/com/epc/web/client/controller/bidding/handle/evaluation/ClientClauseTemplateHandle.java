package com.epc.web.client.controller.bidding.handle.evaluation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-11 22:02
 * <p>@Author : luozhixin
 */
@Data
public class ClientClauseTemplateHandle implements Serializable {
    private static final long serialVersionUID = -3307206236523123222L;


    /**
     *废除条款模板url
     */
    @ApiModelProperty(value ="废除条款模板url" )
    private  String filePath;
    /**
     *废除条款模板名称
     */
    @ApiModelProperty(value ="废除条款模板名称" )
    private String clauseName;
}
