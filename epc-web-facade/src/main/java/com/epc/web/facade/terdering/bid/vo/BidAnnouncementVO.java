package com.epc.web.facade.terdering.bid.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "标段注释")
@Data
public class BidAnnouncementVO implements Serializable {
    private static final long serialVersionUID = -3189359100141232432L;
    @ApiModelProperty(value = "投标附录")
    private String bidAppendix;
    @ApiModelProperty(value = "公司ID")
    private Long companyId;
    @ApiModelProperty(value = "公司名称")
    private String companyName;

}
