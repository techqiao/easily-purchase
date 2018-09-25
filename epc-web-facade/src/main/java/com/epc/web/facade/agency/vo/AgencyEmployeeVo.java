package com.epc.web.facade.agency.vo;

import lombok.Data;

@Data
public class AgencyEmployeeVo {
    /**
     * 员工id
     */
    private String userId;
    /**
     * 员工姓名
     */
    private String userName;
    /**
     *员工手机
     */
    private String cellphone;
    /**
     * 公司id
     */
    private String companyId;
    /**
     * 老板name
     */
    private String bossName;
    /**
     * 公司名
     */
    private String companyName;
}
