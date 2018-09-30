package com.epc.web.facade.terdering.bid.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ScoreAndPathVO implements Serializable {
    private static final long serialVersionUID = -4723503931152917282L;
    /**
     * 评分列表
     */
    private  List<ExpertScoreVO> scoreList;
    /**
     * 供应商附录列表
     */
    private  List<FilePathVO> fileList;
}
