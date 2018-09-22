package com.epc.web.facade.operator.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;


/**
 * @Description:    运营商信息录入
 * @Author:         linzhixiang
 * @CreateDate:     2018/9/13 9:56
 * @UpdateUser:     linzhixiang
 * @UpdateDate:     2018/9/13 9:56
 * @UpdateRemark:  修改内容
 * @Version:        1.0
 */

@Data
public class HandleOperator implements Serializable {
    private static final long serialVersionUID = -1601501922746938L;

    /**
     * 员工id
     */
    private Long id;
    /**
     * 员工姓名
     */
    private String userName;

    /**
     * 手机号
     */
    private String cellPhone;

    /**
     * 密码
     */
    private String passWord;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
