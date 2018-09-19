package com.epc.web.client.controller.purchaser.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClientHandleRegisterPurchaser implements Serializable {
    private static final long serialVersionUID = 2008007322700666033L;
    private String cellphone;
    private String password;
}
