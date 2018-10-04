package com.epc.web.service.domain.question;

import java.io.Serializable;

public class BAnswerQuestionWithBLOBs extends BAnswerQuestion implements Serializable {
    private String problem;

    private String answer;

    private static final long serialVersionUID = 1L;

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem == null ? null : problem.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", problem=").append(problem);
        sb.append(", answer=").append(answer);
        sb.append("]");
        return sb.toString();
    }
}