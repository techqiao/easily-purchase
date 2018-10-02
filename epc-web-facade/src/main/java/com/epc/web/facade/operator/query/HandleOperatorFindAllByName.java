package com.epc.web.facade.operator.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Data
public class HandleOperatorFindAllByName implements Serializable {

    private static final long serialVersionUID = -5503378128453752419L;
    /**
     * 运营商的（法人）id
     */
    private Long operatorId;

    /**
     * 输入查询的员工名字
     */
    private String name;

    //role 角色
    private Integer role;

    //是否禁用
    private Integer isForbidden;

}
