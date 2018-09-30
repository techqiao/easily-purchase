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
    private String name ;
    private String type ;
    private Long parentId;
    private String title;
    private String url;


}
