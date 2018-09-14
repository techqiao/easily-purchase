package com.epc.web.facade.operator.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

@ApiModel(value = "HandleOperator", description = "运营商人员信息")
public class HandleOperator {
    /**
    * @Description:    运营商信息录入
    * @Author:         linzhixiang
    * @CreateDate:     2018/9/13 9:56
    * @UpdateUser:     linzhixiang
    * @UpdateDate:     2018/9/13 9:56
    * @UpdateRemark:  修改内容
    * @Version:        1.0
    */
    @ApiModelProperty(value = "员工姓名")
    @NotEmpty(message = "HandleOperator.userName.null")
    private String userName;
    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "HandleOperator.cellPhone.null")
    private String cellPhone;
    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "HandleOperator.passWord.null")
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    @Override
    public String toString() {
        return "HandleOperator{" +
                "userName='" + userName + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
