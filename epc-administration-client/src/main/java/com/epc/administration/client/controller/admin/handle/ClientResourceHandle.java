package com.epc.administration.client.controller.admin.handle;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 10:06
 * <p>@Author : luozhixin
 */
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ClientResourceHandle{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", parentId=" + parentId +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
