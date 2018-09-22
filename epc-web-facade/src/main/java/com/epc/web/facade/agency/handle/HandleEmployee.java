package com.epc.web.facade.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "HandleEmployee",description = "代理机构员工信息")
public class HandleEmployee implements Serializable {

    private static final long serialVersionUID = -373772042506965841L;
    /**
     * 员工id
     */
    private Long id;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 机构id
     */
    private Long agencyId;

    /**
     * 手机号
     */
    private String cellphone;

    /**
     * 密码
     */
    private String password;
    /**
     * 状态启用或禁用
     */
    private Integer state;

    /**
     * 权限老板或员工
     */
    private Integer role;
    /**
     * 加入时间
     */
    private Date createAt;
    /**
     * 修改时间
     */
    private Date updateAt;

}
