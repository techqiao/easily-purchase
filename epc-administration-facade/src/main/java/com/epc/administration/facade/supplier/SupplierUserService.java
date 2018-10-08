package com.epc.administration.facade.supplier;


import com.epc.administration.facade.supplier.dto.QueryDetailIfo;
import com.epc.administration.facade.supplier.handle.ExamineSupplierHandle;
import com.epc.administration.facade.supplier.handle.SupplierForbiddenHandle;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.administration.facade.supplier.handle.UserBasicInfo;
import com.epc.administration.facade.supplier.vo.SupplierAttachmentVO;
import com.epc.administration.facade.supplier.vo.TWinBidVO;
import com.epc.common.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 供应商接口
 * @date 2018-09-14 09:35:58
 * @author lzx
 */
public interface SupplierUserService {
    /**
     * 供应商注册注册
     * @param userBasicInfo 基本信息
     * @return Result
     */
    @PostMapping(value = "createSupplierUserInfo", consumes = "application/json; charset=UTF-8")
     Result<Boolean> createSupplierUserInfo(@RequestBody UserBasicInfo userBasicInfo);

    /**
     * 供应商完善资料
     * @param supplierHandle 附件信息
     * @return Result
     */
    @PostMapping(value = "insertSupplierDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertSupplierDetailInfo(@RequestBody SupplierHandle supplierHandle);

    /**
     * 修改供应商资料
     *
     * @param supplierHandle 附件信息
     * @return Result
     */
    @PostMapping(value = "updateSupplierDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateSupplierDetailInfo(@Param("supplierHandle")@RequestBody SupplierHandle supplierHandle);

    /**
     * 删除供应商资料
     * @param whereId
     * @return Result
     */
    @GetMapping(value = "deleteSupplierDetailInfo" )
    Result<Boolean> deleteSupplierDetailInfo(@RequestParam("whereId") Long whereId);

    /**
     * 根据id查询供应商详情
     * @param whereId
     * @return Result
     */
    @GetMapping(value = "querySupplierDetailInfo" )
    Result<SupplierAttachmentVO> querySupplierDetailInfo(@RequestParam("whereId") Long whereId);

    /**
     * 查询所有供应商 ，分页展示
     * @param queryDetailIfo
     * @return Result<Map<String, Object>>
     */
    @PostMapping(value = "selectAllSupplierByPage" ,consumes = "application/json; charset=UTF-8")
    Result<Map<String, Object>> selectAllSupplierByPage(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 审核供应商
     * @param examineSupplierHandle
     * @return  Result
     */
    @PostMapping(value = "examineSupplier",consumes ="application/json; charset=UTF-8" )
    Result examineSupplier(@RequestBody ExamineSupplierHandle examineSupplierHandle);

    /**
     * 启用禁用供应商
     * @param supplierForbiddenHandle
     * @return Boolean
     */
    @PostMapping(value = "clientSupplierForbiddenHandle",consumes ="application/json; charset=UTF-8")
    Result<Boolean> forbiddenSupplierUser( @RequestBody SupplierForbiddenHandle supplierForbiddenHandle);

    /**
     * 供应商考评中标业绩列表
     * @param queryDetailIfo
     * @return List<TWinBidVO>
     */
    @PostMapping(value = "supplierReviewWinningBid",consumes = "application/json; charset=UTF-8")
    Result<List<TWinBidVO>> supplierReviewWinningBid(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 供应商考评 奖惩
     * @param queryDetailIfo
     * @return Result
     */
    @PostMapping(value = "supplierReviewRewardAndPunishment",consumes = "application/json; charset=UTF-8")
    Result supplierReviewRewardAndPunishment(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 供应商考评 履约记录
     * @param queryDetailIfo
     * @return Result
     */
    @PostMapping(value = "supplierReviewRecordOfPerformance",consumes = "application/json; charset=UTF-8")
    Result supplierReviewRecordOfPerformance(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 根据ID 查供应商考评 履约记录详情
     * @param id
     * @return Result
     */
    @GetMapping("supplierReviewRecordOfPerformanceDetail")
    Result supplierReviewRecordOfPerformanceDetail(@RequestParam("id") Long id);
}
