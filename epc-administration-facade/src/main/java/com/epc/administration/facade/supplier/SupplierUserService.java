package com.epc.administration.facade.supplier;


import com.epc.administration.facade.supplier.dto.QueryDetailIfo;
import com.epc.administration.facade.supplier.handle.ExamineSupplierHandle;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.administration.facade.supplier.handle.UserBasicInfo;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
     Result<Boolean> createSupplierUserInfo(UserBasicInfo userBasicInfo);

    /**
     * 供应商完善资料
     * @param supplierHandle 附件信息
     * @return
     */
    @PostMapping(value = "insertSupplierDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertSupplierDetailInfo(@RequestBody SupplierHandle supplierHandle);

    /**
     * 删除供应商资料
     * @param whereId
     * @return
     */
    @GetMapping(value = "deleteSupplierDetailInfo" )
    Result<Boolean> deleteSupplierDetailInfo(@RequestParam("whereId") Long whereId);

    /**
     * 根据id查询供应商详情
     * @param whereId
     * @return
     */
    @GetMapping(value = "querySupplierDetailInfo" )
    Result querySupplierDetailInfo(@RequestParam("whereId") Long whereId);


    /**
     * 查询所有供应商 ，分页展示
     * @param queryDetailIfo
     * @return
     */
    @PostMapping(value = "selectAllSupplierByPage" ,consumes = "application/json; charset=UTF-8")
    Result selectAllSupplierByPage(@RequestBody QueryDetailIfo queryDetailIfo);


    /**
     * 审核供应商
     * @param examineSupplierHandle
     * @return
     */
    @PostMapping(value = "examineSupplier",consumes ="application/json; charset=UTF-8" )
    Result examineSupplier(ExamineSupplierHandle examineSupplierHandle);
}
