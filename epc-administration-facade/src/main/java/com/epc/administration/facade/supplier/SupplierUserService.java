package com.epc.administration.facade.supplier;


import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.common.QueryRequest;
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
     Result<Boolean> createSupplierUserInfo(@RequestBody UserBasicInfo userBasicInfo);

    /**
     * 供应商完善资料
     * @param supplierHandle 附件信息
     * @return
     */
    @PostMapping(value = "insertSupplierDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertSupplierDetailInfo(@RequestBody SupplierHandle supplierHandle);

    /**
     * 删除供应商资料
     * @param queryDetailIfo
     * @return
     */
    @PostMapping(value = "deleteSupplierDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result<Boolean> deleteSupplierDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 根据id查询供应商详情
     * @param queryDetailIfo
     * @return
     */
    @PostMapping(value = "querySupplierDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result querySupplierDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 根据模糊name查询供应商详情
     * @param queryDetailIfo
     * @return
     */
    @PostMapping(value = "selectSupplierDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result selectSupplierDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 查询所有供应商 ，分页展示
     * @param queryRequest
     * @return
     */
    @PostMapping(value = "selectAllSupplierByPage" ,consumes = "application/json; charset=UTF-8")
    Result selectAllSupplierByPage(@RequestBody QueryRequest queryRequest);

}
