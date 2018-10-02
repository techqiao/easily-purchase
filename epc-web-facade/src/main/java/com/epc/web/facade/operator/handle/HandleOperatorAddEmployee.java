package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorAddEmployee implements Serializable {

    private static final long serialVersionUID = -1222610669844392396L;
    /**
     * 要添加的员工名字
     */
    private String name;

    /**
     * 要添加的员工电话
     */
    private String cellphone;

    /**
     * 要添加的员工的密码
     */
    private String password;

    /**
     * 员工id(运营商id)
     */
    private Long id;

    /**
     * 员工的角色
     */
    private Integer role;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    /**
     * 运营商id
     */
    private Long operatorId;

    /**
     * 员工的审核状态，0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     */
    private Integer state;


}
