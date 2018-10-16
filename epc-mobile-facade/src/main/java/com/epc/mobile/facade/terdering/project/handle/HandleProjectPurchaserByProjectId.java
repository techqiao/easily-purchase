package com.epc.mobile.facade.terdering.project.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleProjectPurchaserByProjectId implements Serializable {
    private static final long serialVersionUID = -9023265949172062601L;

    /**
     * 当前登陆人的id
     */
    private Long id;

    /**
     * 项目的id
     */
    private Long projectId;



}
