package com.epc.web.facade.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

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
     * 创建的时间
     */
    private Date createAt;

    /**
     * 修改的时间
     */
    private Date updateAt;

    /**
     * 用户的角色，0-法人,1-管理员,2-普通员工
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
