package com.epc.web.client.controller.bidding.query.notice;

import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author linzhixiang
 */
@Data
@ApiModel(value = "QueryNoticeDetail",description = "根据Id查看公告详情")
public class ClientNoticeDetailDTO{

    @ApiModelProperty(value = "公告Id")
    private  Long noticeId;

}
