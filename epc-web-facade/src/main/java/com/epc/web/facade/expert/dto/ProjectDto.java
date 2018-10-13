package com.epc.web.facade.expert.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *@author :winlin
 *@date:2018/10/9
 */
@Data
public class ProjectDto implements Serializable {
    private static final long serialVersionUID = 3392058889160690567L;
    private  Long expertId;

    private String projectName;

    private  String purchaserName;
    /**
     * 0 进行中,1 已结束 -1 未开始
     */
    private Integer isEnd;

    /**
     * 采购项目id
     */
    private List<Long> projectIds;
}
