package com.epc.web.facade.terdering.answer.handle;

import lombok.Data;

/**
 * <p>Description : 回复问题
 * <p>Date : 2018-09-20 15:06
 * <p>@Author : wjq
 */
@Data
public class HandleReplyQuestion {
    /**
     * 回答内容
     */
    private String answer;
    /**
     * 问题ID
     */
    private Long id;

    /**
     * 操作人ID
     */
    private Long operateId;

    /**
     * 操作人姓名
     */
    private String operateName;
}
