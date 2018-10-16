package com.epc.mobile.facade.terdering.project.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleDeleteProjectPurchaser implements Serializable {
    private static final long serialVersionUID = 2322965504064446613L;

//    private Long loginId;


    private Long projectPurchaserId;

    private Integer isDeleted;


}
