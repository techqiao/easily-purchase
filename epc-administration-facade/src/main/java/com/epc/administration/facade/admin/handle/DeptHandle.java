package com.epc.administration.facade.admin.handle;


import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 10:38
 * <p>@Author : luozhixin
 */
@Data
public class DeptHandle implements Serializable {
    private static final long serialVersionUID = -4436239808687151630L;
    private String deptName;
    private Long parentId;

}
