package com.epc.web.facade.operator.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OperatorBasicInfoVO implements Serializable {

    private static final long serialVersionUID = -8975043822639313264L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 手机号
     */
    private String cellphone;

    /**
     * 运营商员工姓名
     */
    private String name;


    /**
     * 用户角色:0-法人,1-管理员,2-普通员工
     */
    private Integer role;

    /**
     * 创建时间
     */
    private String createAt;

    /**
     * 最后修改时间
     */
    private String updateAt;

    /**
     * 是否禁用
     */
    private Integer isForbidden;

}
