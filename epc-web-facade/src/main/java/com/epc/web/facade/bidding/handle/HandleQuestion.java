package com.epc.web.facade.bidding.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleQuestion implements Serializable {

    private static final long serialVersionUID = 2633674461364958202L;
    private Long questionerId;

    private String questionerName;

    private String problem;

    private String title;

    public Long getQuestionerId() {
        return questionerId;
    }

    public void setQuestionerId(Long questionerId) {
        this.questionerId = questionerId;
    }

    public String getQuestionerName() {
        return questionerName;
    }

    public void setQuestionerName(String questionerName) {
        this.questionerName = questionerName;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
