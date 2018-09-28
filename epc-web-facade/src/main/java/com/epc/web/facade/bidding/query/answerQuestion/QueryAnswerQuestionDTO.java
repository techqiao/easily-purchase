package com.epc.web.facade.bidding.query.answerQuestion;

import com.epc.common.PagerParam;
import lombok.Data;

import java.io.Serializable;

/**
 * 问答搜索
 * @author linzhixiang
 */
@Data
public class QueryAnswerQuestionDTO extends PagerParam implements Serializable {

    private static final long serialVersionUID = 5996739447754085950L;
    /**
     * 采购项目ID
     */
    private Long procurementProjectId;
    /**
     * 回答人姓名
     */
    private String answerName;

    /**
     * 问题类型
     */
    private String questionType;
    /**
     * 问题Id
     */
    private Long typeId;
    /**
     * 提问人Id
     */
    private Long questionerId;
    /**
     * 提问人姓名
     */
    private String questionerName;


}
