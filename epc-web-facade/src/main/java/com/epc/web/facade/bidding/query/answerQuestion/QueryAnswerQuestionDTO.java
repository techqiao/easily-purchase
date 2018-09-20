package com.epc.web.facade.bidding.query.answerQuestion;

import com.epc.common.PagerParam;

import java.io.Serializable;

/**
 * 公告对应的问答搜索
 * @author linzhixiang
 */
public class QueryAnswerQuestionDTO extends PagerParam implements Serializable {

    private static final long serialVersionUID = 5996739447754085950L;
    //采购项目ID
    private Long id;

    //采购项目名称
    private String noticeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }
}
