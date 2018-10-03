package com.epc.web.facade.agency.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class SupplierDto implements Serializable {
    private static final long serialVersionUID = 2799471168650968935L;
    /**
     * 代理机构id
     */
    private Long agencyId;
    /**
     * 公司名称
     */
    private String companyName;
}
