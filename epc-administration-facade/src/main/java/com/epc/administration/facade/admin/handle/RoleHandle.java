package com.epc.administration.facade.admin.handle;


import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 09:46
 * <p>@Author : luozhixin
 */
@Data
public class RoleHandle implements Serializable {
    private static final long serialVersionUID = -6141001495978320281L;
    private String memo;
    private String name;
    private Long[] resourceIds;

}
