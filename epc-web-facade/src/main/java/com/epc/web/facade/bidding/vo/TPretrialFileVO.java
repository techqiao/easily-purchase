package com.epc.web.facade.bidding.vo;

import lombok.Data;

/**
 * <p>Description : 查询文件列表返回
 * <p>Date : 2018-09-25 16:31
 * <p>@Author : luozhixin
 * <p>TPretrialFileVO
 */
@Data
public class TPretrialFileVO {



    /**
     * 供应商名称
     */
    private String companyName;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件名
     */
    private String fileName;

}
