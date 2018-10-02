package com.epc.web.service.domain.expert;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TExpertAttachment implements Serializable {

    private Long id;


    private Long expertId;


    private String certificateType;


    private String certificateFilePath;


    private String certificateNumber;

    private String certificateName;


    private Date createAt;

    private Date updateAt;


    private Integer isDeleted;


    private static final long serialVersionUID = 1L;



}