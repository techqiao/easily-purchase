package com.epc.administration.client.controller.admin.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 10:06
 * <p>@Author : luozhixin
 */
@Data
public class ClientResourceHandle implements Serializable {

    private static final long serialVersionUID = -5280420654286651330L;
    @ApiModelProperty(value = "名称")
    @NotEmpty(message = "ClientResourceHandle.name.null")
    private String name ;
    @ApiModelProperty(value = "属性")
    @NotEmpty(message = "ClientResourceHandle.type.null")
    private String type ;
    @ApiModelProperty(value = "父id")
    @NotEmpty(message = "ClientResourceHandle.parentId.null")
    private Long parentId;
   @ApiModelProperty(value = "标题")
   @NotEmpty(message = "ClientResourceHandle.title.null")
    private String title;
   @ApiModelProperty(value = "路径")
   @NotEmpty(message = "ClientResourceHandle.url.null")
   private String url;


}
