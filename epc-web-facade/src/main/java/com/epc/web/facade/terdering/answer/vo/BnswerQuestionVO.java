package com.epc.web.facade.terdering.answer.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-02 11:31
 * <p>@Author : luozhixin
 * <p>BnswerQuestionVO
 */
@Data
public class BnswerQuestionVO implements Serializable {
    private static final long serialVersionUID = 130202476018829543L;
    private String name;
    private String meno;
    private String answer;

}
