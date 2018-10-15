package com.epc.web.client.controller.bidding.handle.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("投标记录")
public class ClientNoticeLoad {
    @ApiModelProperty("投标记录列表")
    private List<ClientNoticeFileLoad> clientNoticeFileLoad;
}
