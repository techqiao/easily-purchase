package com.epc.web.facade.purchaser.handle;

import io.swagger.models.auth.In;
import lombok.Data;
/**
 *@author :winlin
 *@Description :
 *@param:
 *@return:
 *@date:2018/10/1
 */
@Data
public class HandleTrustList {
    /**
     * 角色唯一id
     */
    private Long id;
    /**
     * 黑白名单
     */
    private String trustOrNot;
    /**
     * 启用或禁用
     */
    private Integer  enableOrDisable;
    /**
     * 角色权限
     */
    private Integer role;
    /**
     * 删除
     */
    private Integer del;
}

