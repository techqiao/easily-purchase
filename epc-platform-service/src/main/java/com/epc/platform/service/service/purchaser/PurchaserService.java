package com.epc.platform.service.service.purchaser;

import com.epc.administration.facade.purchaser.dto.QueryDetailIfo;
import com.epc.administration.facade.purchaser.handle.ExaminePurchaserHandle;
import com.epc.administration.facade.purchaser.handle.PurchaserForbiddenHandle;
import com.epc.administration.facade.purchaser.handle.PurchaserHandle;
import com.epc.administration.facade.purchaser.handle.UserBasicInfo;
import com.epc.administration.facade.purchaser.vo.PurchaserVO;
import com.epc.common.Result;
import com.epc.platform.service.domain.purchaser.TPurchaserDetailInfo;

import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-28 13:14
 * <p>@Author : luozhixin
 * <p>PurchaserService
 */
public interface PurchaserService {
    /**
     * 采购人注册
     * @param userBasicInfo
     * @return
     */
    Result insertPurchaserUserInfo(UserBasicInfo userBasicInfo);
    /**
     * 采购人完善资料
     * @param purchaserHandle
     * @return
     */
    Result<Boolean> insertPurchaserDetailInfo(PurchaserHandle purchaserHandle);

    /**
     *  删除采购人资料
     * @param whereId
     * @return
     */
    Result<Boolean> deletePurchaserDetailInfo( Long whereId);

    /**
     * 根据id查询采购人详情
     * @param id
     * @return
     */
    Result<TPurchaserDetailInfo> queryPurchaserDetailInfo(Long id);

    /**
     * 查询所有采购人 ，分页展示
     * @param queryDetailIfo
     * @return
     */
    List<PurchaserVO> selectAllPurchaserByPage(QueryDetailIfo queryDetailIfo);

    /**
     * 审核供应商
     * @param examinePurchaserHandle
     * @return
     */
    Result<Boolean> examinePurchaser(ExaminePurchaserHandle examinePurchaserHandle);

    /**
     * 启用锁定供应商
     * @return
     */
    Result<Boolean> forbiddenPurchaserUser(PurchaserForbiddenHandle purchaserForbiddenHandle);
}
