package com.epc.web.facade.terdering.project.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleUpdateProjectAdmin implements Serializable {
    private static final long serialVersionUID = -916700918011881718L;

    private Integer loginRole;


    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目经理
     */
    private String executiveName;

    private Long executiveId;


    private String notes;



}
