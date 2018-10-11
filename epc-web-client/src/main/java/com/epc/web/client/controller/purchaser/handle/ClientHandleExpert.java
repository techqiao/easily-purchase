package com.epc.web.client.controller.purchaser.handle;

import com.epc.web.client.controller.agency.handle.ClientAttachement;
import com.epc.web.facade.agency.handle.Attachement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
import java.util.List;

/**
* @Description:    采购人录入专家信息
* @Author:         linzhixiang
* @CreateDate:     2018/9/13 19:51
* @UpdateUser:     linzhixiang
* @UpdateDate:     2018/9/13 19:51
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Data
@ApiModel(value = "HandleExpert", description = "专家信息")
public class ClientHandleExpert {
    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "HandleOperator.cellPhone.null")
    private String cellPhone;
//    @ApiModelProperty(value = "密码")
//    @NotEmpty(message = "HandleOperator.passWord.null")
//    private String passWord;
    @ApiModelProperty(value = "专家姓名")
    @NotEmpty(message = "HandleExpert.name.null")
    private String name;
    @ApiModelProperty(value = "专业")
    @NotEmpty(message = "HandleExpert.profession.null")
    private String profession;
    @ApiModelProperty(value = "职称")
    @NotEmpty(message = "HandleExpert.positional.null")
    private String positional;
    @ApiModelProperty(value = "级别")
    @NotEmpty(message = "HandleExpert.level.null")
    private String level;
    @ApiModelProperty(value = "工作年限")
    private Integer workingYears;
    @ApiModelProperty(value = "通知时间")
    @NotEmpty(message = "HandleExpert.circularDt.null")
    private Date circularDt;
    @ApiModelProperty(value = "通知时间")
    @NotEmpty(message = "HandleExpert.circularDtEnd.null")
    private Date circularDtEnd;
    @ApiModelProperty(value = "通知方式")
    @NotEmpty(message = "HandleExpert.circularMethod.null")
    private String circularMethod;
    @ApiModelProperty(value = "其他信息")
    @NotEmpty(message = "HandleExpert.otherInformation.null")
    private String otherInformation;
    /**
     * 专家附件
     */
    @ApiModelProperty(value = "法人身份证正面照片url")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    private String legalIdCardOther;
    @ApiModelProperty(value = "附件")
    private List<ClientAttachement> atts;



}
