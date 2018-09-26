package com.epc.web.facade.bidding.handle;

import lombok.Data;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-26 21:27
 * <p>@Author : luozhixin
 * <p>StandardTypeHandle
 */
@Data
public class StandardTypeHandle {

    /**
     * 方法类型
     */
    private String standardType;
    /**
     * '评标方法描述'
     */
    private String memo;

    /**
     * 评标方法文件url
     */
    private String filePath;

    /**
     * 技术评标总分数
     */
    private Integer techTypeScore;
}
