package com.epc.web.facade.terdering.project.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SelectProjectPurchaserListVO implements Serializable {
    private static final long serialVersionUID = -1469985206029596701L;

    private Long id;

    private Long projectId;

    private Long purchaserId;

    private String projectPurchaserName;

    private Long executiveId;

    private String executiveName;

    private Long approvalId;

    private String approvalName;

    private Long checkId;

    private String checkName;

    private Integer state;

//    private Integer isDeleted;

    private String createAt;

    private String updateAt;

    private String notes;


}
