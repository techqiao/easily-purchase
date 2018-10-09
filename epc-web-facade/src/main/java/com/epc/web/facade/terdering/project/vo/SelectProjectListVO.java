package com.epc.web.facade.terdering.project.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SelectProjectListVO implements Serializable {
    private static final long serialVersionUID = 2760593257448286862L;

    private Long id;

    private String projectName;

    private Long createrId;

    private String createrName;

    private Long purchaserId;

    private Long executiveId;

    private String executiveName;

    private Integer isDeleted;

    private String createAt;

    private String updateAt;

    private String notes;



}
