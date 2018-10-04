package com.epc.administration.facade.admin.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 10:06
 * <p>@Author : luozhixin
 */
@Data
public class ResourceHandle implements Serializable {

    private static final long serialVersionUID = -7264200621807471114L;
    /**
     * 资源名称
     */
    private String name ;
    /**
     * 资源属性 page：页面 button 按钮
     */
    private String type ;
    /**
     * 资源的父级id
     */
    private Long parentId;
    /**
     * 资源标题
     */
    private String title;
    /**
     * 资源路径
     */
    private String url;


}
