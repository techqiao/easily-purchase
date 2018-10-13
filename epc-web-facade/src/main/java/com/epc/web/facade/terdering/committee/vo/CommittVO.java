package com.epc.web.facade.terdering.committee.vo;

import com.epc.web.facade.terdering.committee.dto.CommittExpertDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 返回抽取的专家列表
 * @Author: linzhixiang
 * @Date: 2018/10/12
 */ 
@Data
@ApiModel("返回抽取的专家列表")
public class CommittVO implements Serializable {
    @ApiModelProperty("标段id")
    private Long bidId;
    @ApiModelProperty("标段下的专家")
    private List<CommittExpertDTO> ExpertList;
}
