package com.epc.web.facade.agency.dto;

import com.epc.common.constants.Const;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AgencyEmployeeDto implements Serializable {
    private static final long serialVersionUID = 3208364220370798206L;

    /**
     * 机构id
     */
    private Long agencyId;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 员工手机
     */
    private String cellphone;
    /**
     * 员工状态
     */
    private Integer state;
    /**
     * 员工权限
     */
    private Integer role;
    /**
     * 员工id
     */
    private Long employeeId;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 禁用或启用
     */
    private Integer isForbbiden;
    /**
     * 是否删除
     */
    private Integer isDelete= Const.IS_DELETED.NOT_DELETED;
}
