package com.epc.web.facade.terdering.answer.query;

import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-03 16:32
 * <p>@Author : wjq
 */
@Data
public class QueryPublicityDTO {
    /**
     * 查询澄清公示类型 问题类型（公告-announcement,招标文件-bidFile,评标-bidEvaluation）
     */
    private String type;

}
