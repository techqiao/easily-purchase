package com.epc.mobile.facade.terdering.project.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleDeleteProjectAdmin implements Serializable {
    private static final long serialVersionUID = 727162765924169144L;


    private Integer loginRole;



    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 是否删除
     */
    private Integer isDeleted;

}
