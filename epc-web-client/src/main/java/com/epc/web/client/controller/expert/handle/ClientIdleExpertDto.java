package com.epc.web.client.controller.expert.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
@Data
@ApiModel(value = "ClientIdleExpertDto",description = "专家的空闲状态信息")
public class ClientIdleExpertDto implements Serializable {
    private static final long serialVersionUID = 987011761666523124L;
    @ApiModelProperty(value = "专家id")
    private Long expertId;
    @ApiModelProperty(value = "是否空闲 0-繁忙, 1-空闲")
    private Integer idle;
}
