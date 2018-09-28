package com.epc.web.client.controller.purchaser.handle;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "ClientHandPurchaserAttachment")
public class ClientHandPurchaserAttachment implements Serializable {
    private static final long serialVersionUID = 6234707520843407054L;
    /**
     * 采购人id
     */
    private Long purchaseId;
}
