package com.epc.mobile.facade.terdering.project.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleUpdateProjectPurchaser implements Serializable {
    private static final long serialVersionUID = -6046059318610742335L;



    //当前 采购项目id
    private Long projectPurchaserId;


    private String projectPurchaserName;

    private Long executiveId;

    private String executiveName;

    private Long approvalId;

    private String approvalName;

    private Long checkId;

    private String checkName;

//    private Integer state;

//    private Integer isDeleted;


    private String notes;

}
