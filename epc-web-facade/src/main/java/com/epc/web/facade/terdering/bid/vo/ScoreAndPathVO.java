package com.epc.web.facade.terdering.bid.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "供应商附录")
@Data
public class ScoreAndPathVO implements Serializable {
    private static final long serialVersionUID = -4723503931152917282L;
    @ApiModelProperty(value = "评分列表")
    private  List<ExpertScoreVO> scoreList;
    @ApiModelProperty(value = "供应商附录列表")
    private  List<FilePathVO> fileList;
}
