package com.epc.web.facade.bidding.vo;

import com.epc.web.facade.bidding.dto.FileListDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class PretrialMessageVO implements Serializable {

    private static final long serialVersionUID = 1423008615238963440L;

    private Long id;

    private Long purchasProjectId;

    private Long releaseAnnouncementId;

    private Long companyId;

    private Long operateId;

    private String operateName;

    private String status;

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;

    private String content;

    private List<FileListDTO> fileList;

}
