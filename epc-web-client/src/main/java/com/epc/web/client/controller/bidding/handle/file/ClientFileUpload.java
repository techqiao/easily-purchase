package com.epc.web.client.controller.bidding.handle.file;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class ClientFileUpload implements Serializable {
    private static final long serialVersionUID = 6701570144170338443L;
    private List<ClientHandleFileUpload> fileList;
}
