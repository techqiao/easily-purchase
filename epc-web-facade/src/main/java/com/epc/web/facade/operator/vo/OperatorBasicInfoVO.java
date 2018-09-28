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

//    /**
//     * 登录密码
//     */
//    private String password;

    /**
     * 运营商员工姓名
     */
    private String name;

    /**
     * 运营商(法人)ID
     */
    private Long operatorId;

    /**
     * 0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     */
    private Integer state;

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
     * 是否删除: 0-存在,1-删除
     */
    private Integer isDeleted;

}
