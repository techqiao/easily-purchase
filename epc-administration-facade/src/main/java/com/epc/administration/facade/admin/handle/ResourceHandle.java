package com.epc.administration.facade.admin.handle;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 10:06
 * <p>@Author : luozhixin
 */
public class ResourceHandle implements Serializable {

    private static final long serialVersionUID = -7264200621807471114L;
    private String name ;
    private String type ;
    private Long parentId;
    private String title;
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
        parentId = parentId;
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
        return "ResourceHandle{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", parentId=" + parentId +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
