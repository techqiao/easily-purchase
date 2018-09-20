package com.epc.web.facade.terdering.answer.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 14:21
 * <p>@Author : wjq
 */
@Data
public class FacadeAnswerQuestionVO implements Serializable {
    private static final long serialVersionUID = -975682350779699922L;

    /**
     * 问题ID
     */
    private Long id;
    /**
     * 采购项目ID
     */
    private Long procurementProjectId;
    /**
     * 提问人ID
     */
    private Long questionerId;
    /**
     * 提问人姓名
     */
    private String questionerName;
    /**
     * 回答问题人Id
     */
    private Long answerId;
    /**
     * 回答问题人姓名
     */
    private String answerName;
    /**
     * 问题
     */
    private String problem;
    /**
     * 回答
     */
    private String answer;
    /**
     * 问题状态
     */
    private String status;
}
