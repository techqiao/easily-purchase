package com.epc.administration.facade.operator.Supplier;


import com.epc.administration.facade.operator.handle.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 供应商接口
 * @date 2018-09-14 09:35:58
 * @author lzx
 */
public interface SupplierUserService {


    /**
     * 供应商注册注册
     * @param userBasicInfo 基本信息
     * @return
     */
    @PostMapping(value = "createSupplierUserInfo", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> createSupplierUserInfo(UserBasicInfo userBasicInfo);

    /**
     * 供应商完善资料
     * @param roleDetailIfo 附件信息
     * @return
     */
    @PostMapping(value = "insertOperatorDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertOperatorDetailInfo(@RequestBody RoleDetailIfo roleDetailIfo);


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
