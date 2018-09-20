package com.epc.web.facade.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 运营商修改员工信息
 */
@Data
public class HandleOperatorUpdateEmployeeById implements Serializable {

    private static final long serialVersionUID = 7782843166198100959L;
    /**
     * 要修改员工的id
     */
    private Long id;

    /**
     * 要修改员工的名字
     */
    private String name;

    /**
     * 要修改员工的电话
     */
    private String cellphone;

    /**
     * 要修改员工的状态
     */
    private  Integer isDeleted;


}
