package com.epc.administration.facade.admin.dto;

import com.epc.common.QueryRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-29 21:21
 * <p>@Author : luozhixin
 * <p>QueryUserDTO
 */
@Data
public class QueryUserDTO extends QueryRequest implements Serializable {
    private static final long serialVersionUID = -2256323475337896434L;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 部门id
     */
    private Long deptId;
}
