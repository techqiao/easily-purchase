package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* @Description: 答疑列表
* @Author: linzhixiang
* @Date: 2018/9/18 
*/
@Data
public class QueryAnswerQuestionListVO implements Serializable {

    private static final long serialVersionUID = 3150403019447676651L;
    /**
     * 记录Id
     */
    private Long id;

    /**
     * 提问人
     */
    private String questionerName;

    /**
     * 回答人
     */
    private String answerName;

    /**
     * 问题
     */
    private String problem;

    /**
     * 创建时间
     */
    private Date createAt;


}
