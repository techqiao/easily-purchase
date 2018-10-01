package com.epc.administration.facade.purchaser;


import com.epc.administration.facade.purchaser.dto.QueryDetailIfo;
import com.epc.administration.facade.purchaser.handle.ExaminePurchaserHandle;
import com.epc.administration.facade.purchaser.handle.PurchaserForbiddenHandle;
import com.epc.administration.facade.purchaser.handle.PurchaserHandle;
import com.epc.administration.facade.purchaser.handle.UserBasicInfo;
import com.epc.administration.facade.purchaser.vo.PurchaserVO;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 采购人接口
 * @date 2018-09-14 09:35:58
 * @author lzx
 */
public interface PurchaserUserService {


    /**
     * 采购人注册
     * @param userBasicInfo 基本信息
     * @return
     */
    @PostMapping(value = "createPurchaserUserInfo", consumes = "application/json; charset=UTF-8")
     Result<Boolean> createPurchaserUserInfo(UserBasicInfo userBasicInfo);

    /**
     * 采购人完善资料
     * @param purchaserHandle 附件信息
     * @return
     */
    @PostMapping(value = "insertPurchaserDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertPurchaserDetailInfo(@RequestBody PurchaserHandle purchaserHandle);

    /**
     * 修改采购人资料
     * @param purchaserHandle 附件信息
     * @return
     */
    @PostMapping(value = "updatePurchaserDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updatePurchaserDetailInfo(@RequestBody PurchaserHandle purchaserHandle);

    /**
     * 删除采购人资料
     * @param whereId
     * @return
     */
    @GetMapping(value = "deletePurchaserDetailInfo" )
    Result<Boolean> deletePurchaserDetailInfo(@RequestParam("whereId") Long whereId);

    /**
     * 根据id查询采购人详情
     * @param whereId
     * @return
     */
    @GetMapping(value = "queryPurchaserDetailInfo")
    Result queryPurchaserDetailInfo(@RequestParam("whereId") Long whereId);


    /**
     * 查询所有采购人 ，分页展示
     * @param queryDetailIfo
     * @return
     */
    @PostMapping(value = "selectAllPurchaserByPage" ,consumes = "application/json; charset=UTF-8")
    Result<Map<String, Object>> selectAllPurchaserByPage(@RequestBody QueryDetailIfo queryDetailIfo);


    /**
     * 审核采购人
     * @param examinePurchaserHandle
     * @return
     */
    @PostMapping(value = "examinePurchaser",consumes ="application/json; charset=UTF-8" )
    Result examinePurchaser(ExaminePurchaserHandle examinePurchaserHandle);

    /**
     * 启用锁定采购人
     * @param purchaserForbiddenHandle
     * @return
     */
    @PostMapping(value = "forbiddenPurchaserUser" ,consumes ="application/json; charset=UTF-8"  )
    Result<Boolean> forbiddenPurchaserUser(PurchaserForbiddenHandle purchaserForbiddenHandle);
}
