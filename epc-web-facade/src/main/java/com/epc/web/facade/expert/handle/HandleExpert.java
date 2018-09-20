package com.epc.web.facade.expert.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
* @Description:  采购人录入专家信息
* @Param:
* @return:
* @Author: linzhixiang
* @Date: 2018/9/18
*/

@ApiModel(value = "HandleExpert", description = "专家信息")
public class HandleExpert {
    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "HandleOperator.cellPhone.null")
    private String cellPhone;
    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "HandleOperator.passWord.null")
    private String passWord;
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
    @ApiModelProperty(value = "通知时间")
    @NotEmpty(message = "HandleExpert.circularDt.null")
    private Date circularDt;
    @ApiModelProperty(value = "通知方式")
    @NotEmpty(message = "HandleExpert.circularMethod.null")
    private String circularMethod;
    @ApiModelProperty(value = "其他信息")
    @NotEmpty(message = "HandleExpert.otherInformation.null")
    private String otherInformation;

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPositional() {
        return positional;
    }

    public void setPositional(String positional) {
        this.positional = positional;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getCircularDt() {
        return circularDt;
    }

    public void setCircularDt(Date circularDt) {
        this.circularDt = circularDt;
    }

    public String getCircularMethod() {
        return circularMethod;
    }

    public void setCircularMethod(String circularMethod) {
        this.circularMethod = circularMethod;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }
}
