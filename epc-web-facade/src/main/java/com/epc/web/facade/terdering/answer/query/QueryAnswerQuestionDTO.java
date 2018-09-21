package com.epc.web.facade.terdering.answer.query;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description :QueryAnswerQuestionDTO
 * <p>Date : 2018-09-20 14:41
 * <p>@Author : wjq
 */
@Data
public class QueryAnswerQuestionDTO extends PagerParam implements Serializable {
    private static final long serialVersionUID = 6046205431271246959L;
    /**
     * 采购项目ID
     */
    private Long procurementProjectId;
    /**
     * 提问人姓名
     */
    private String questionerName;

    /**
     * 问题状态 待回复 wait_reply 已回复 replied
     */
    private String status;

}
