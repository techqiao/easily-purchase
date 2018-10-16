package com.epc.mobile.facade.terdering.project.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleSelectProjectPurchaserList implements Serializable {
    private static final long serialVersionUID = -4873872513059770135L;

    private Long loginId;


    //项目名字
//    private String projectName;
    //项目id;
    private Long projectId;




}
