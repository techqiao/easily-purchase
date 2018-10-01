package com.epc.web.facade.operator.handle;


import lombok.Data;

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
     * 员工姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String cellphone;

    /**
     * 密码
     */
    private String password;





}
