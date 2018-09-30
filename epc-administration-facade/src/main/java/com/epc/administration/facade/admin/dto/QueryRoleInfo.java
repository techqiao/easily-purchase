package com.epc.administration.facade.admin.dto;

import com.epc.common.QueryRequest;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryRoleInfo extends QueryRequest implements Serializable {
    private static final long serialVersionUID = 1355871455712683170L;
    /**
     * 角色名称
     */
    private String name;


}
