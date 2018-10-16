package com.epc.web.facade.bidding.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 监控文件
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Data
public class HandleMonitoringFile implements Serializable {

    private static final long serialVersionUID = -3614878021944416043L;
    private Long projectId;

    private String fileType;

    private Long fileId;

    private String fileName;

    private String filePath;

    private String operateType;

    private Long operateId;

    private String operater;

    private Date createAt;

    private Date updateAt;

}
