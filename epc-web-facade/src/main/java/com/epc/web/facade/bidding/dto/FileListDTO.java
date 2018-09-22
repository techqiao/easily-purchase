package com.epc.web.facade.bidding.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FileListDTO implements Serializable {

    private static final long serialVersionUID = 5654812284762647152L;
    private Long id;
    private String fileName;
    private String filePath;
}
