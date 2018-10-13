package com.epc.web.client.controller.bidding.query.notice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @Description: 招标文件信息
 * @Author: linzhixiang
 * @Date: 2018/10/12
 */ 
@Data
@ApiModel("招标文件信息")
public class ClientPretrialMessageDTO implements Serializable {
    private static final long serialVersionUID = 2624695886806409270L;
    @ApiModelProperty("公告id")
    @NotEmpty(message = " noticeId is not null")
    private  Long noticeId;

}
