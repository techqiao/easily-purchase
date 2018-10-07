package com.epc.web.facade.purchaser.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
* @Description:    运营商录入采购人
* @Author:          linzhixiang
* @CreateDate:     2018/9/13 10:00
* @UpdateUser:     linzhixiang
* @UpdateDate:     2018/9/13 10:00
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Data
@ApiModel(value = "HandlePurchaser", description = "采购人员信息")
public class HandlePurchaser {
    /**
     * 采购人机构id
     */

    private long purchaserId;
    /**
     * 采购人员工姓名
     */

    private String name;

    /**
     * 手机号
     */
    private String cellPhone;
    /**
     * 用户角色
     */
    private Integer role;
}
