package com.epc.administration.facade.operator;

import com.epc.administration.facade.operator.handle.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.*;


/**
 * <p>Description : 运营商接口
 * <p>Date : 2018-09-10  18:08
 * <p>@author : wjq
 */
public interface FacadeOperatorService {
    /**
     * 运营商注册
     * @param userBasicInfo 基本信息
     * @return
     */
    @PostMapping(value = "insertOperatorBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertOperatorBasicInfo(@RequestBody UserBasicInfo userBasicInfo);

    /**
     * 运营商完善资料
     * @param roleDetailInfo 附件信息
     * @return
     */
    @PostMapping(value = "insertOperatorDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertOperatorDetailInfo(@RequestBody RoleDetailInfo roleDetailInfo);


    /**
     * 删除运营商资料
     * @param
     * @return
     */
    @PostMapping(value = "deleteOperatorDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result<Boolean> deleteOperatorDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 根据id查询运营商详情
     * @param
     * @return
     */
    @PostMapping(value = "queryOperatorDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result queryOperatorDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 根据模糊name查询运营商详情
     * @param
     * @return
     */
    @PostMapping(value = "selectOperatorDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result selectOperatorDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);




}
