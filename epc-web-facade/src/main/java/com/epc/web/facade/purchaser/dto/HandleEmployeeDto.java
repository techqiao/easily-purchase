package com.epc.web.facade.purchaser.dto;

import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
@Data
public class HandleEmployeeDto implements Serializable {
    private static final long serialVersionUID = -6304204697577649059L;
    /**
     * 机构id
     */
    private Long purchaseId;
    /**
     * 员工姓名
     */
    private String name;

}
