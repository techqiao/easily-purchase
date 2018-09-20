package com.epc.web.client.controller.bidding.query.answerQuestion;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author linzhixiang
 */
@Data
@ApiModel(value = "ClientAnswerQuestionDTO",description = "根据公告Id查看问答情况")
public class ClientAnswerQuestionDTO extends PagerParam {

    @ApiModelProperty(value = "公告Id")
    private Long id;

    @ApiModelProperty(value = "公告名称")
    private String noticeName;

}