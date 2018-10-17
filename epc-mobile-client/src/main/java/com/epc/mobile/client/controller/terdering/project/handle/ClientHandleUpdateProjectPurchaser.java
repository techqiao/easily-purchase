package com.epc.mobile.client.controller.terdering.project.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ClientHandleUpdateProjectPurchaser",description = "修改采购项目")
@Data
public class ClientHandleUpdateProjectPurchaser  {



    //当前 采购项目id
    @ApiModelProperty(value = "采购项目id")
    private Long projectPurchaserId;

    @ApiModelProperty(value = "采购项目名字")
    private String projectPurchaserName;

    @ApiModelProperty(value = "指派经办人ID")
    private Long executiveId;

    @ApiModelProperty(value = "指派经办人姓名")
    private String executiveName;

    @ApiModelProperty(value = "指派批复人ID")
    private Long approvalId;

    @ApiModelProperty(value = "指派批复人姓名")
    private String approvalName;

    @ApiModelProperty(value = "指派审核人ID")
    private Long checkId;

    @ApiModelProperty(value = "指派审核人姓名")
    private String checkName;

//    private Integer state;

//    private Integer isDeleted;


    @ApiModelProperty(value = "备注")
    private String notes;

}
