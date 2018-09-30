package com.epc.platform.service.controller.purchaser;

import com.epc.administration.facade.purchaser.PurchaserUserService;
import com.epc.administration.facade.purchaser.dto.QueryDetailIfo;
import com.epc.administration.facade.purchaser.handle.ExaminePurchaserHandle;
import com.epc.administration.facade.purchaser.handle.PurchaserForbiddenHandle;
import com.epc.administration.facade.purchaser.handle.PurchaserHandle;
import com.epc.administration.facade.purchaser.handle.UserBasicInfo;
import com.epc.administration.facade.purchaser.vo.PurchaserVO;
import com.epc.common.Result;
import com.epc.common.util.MD5Util;
import com.epc.platform.service.controller.admin.BaseController;
import com.epc.platform.service.domain.purchaser.TPurchaserDetailInfo;
import com.epc.platform.service.service.purchaser.PurchaserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.MD5;

import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-28 13:13
 * <p>@Author : luozhixin
 * <p>PurchaserController
 */
@RestController
public class PurchaserController extends BaseController implements PurchaserUserService {

    @Autowired
    private PurchaserService purchaserService;

    /**
     * 采购人注册
     * @param userBasicInfo 基本信息
     * @return
     */
    @Override
    public Result<Boolean> createPurchaserUserInfo(@RequestBody UserBasicInfo userBasicInfo) {
        return purchaserService.insertPurchaserUserInfo(userBasicInfo);
    }

    /**
     * 采购人完善资料
     * @param purchaserHandle 附件信息
     * @return
     */
    @Override
    public Result<Boolean> insertPurchaserDetailInfo(@RequestBody PurchaserHandle purchaserHandle) {
        return purchaserService.insertPurchaserDetailInfo(purchaserHandle);
    }

    /**
     * 删除采购人资料
     * @param whereId
     * @return
     */
    @Override
    public Result<Boolean> deletePurchaserDetailInfo(Long whereId) {
        return purchaserService.deletePurchaserDetailInfo(whereId);
    }

    /**
     * 根据id查询采购人详情
     * @param whereId
     * @return
     */
    @Override
    public Result<TPurchaserDetailInfo> queryPurchaserDetailInfo(Long whereId) {
        return purchaserService.queryPurchaserDetailInfo(whereId);
    }

    /**
     *  查询所有采购人 ，分页展示
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result selectAllPurchaserByPage(@RequestBody QueryDetailIfo queryDetailIfo) {
        PageHelper.startPage(queryDetailIfo.getPageNum(),queryDetailIfo.getPageSize());
        List<PurchaserVO> purchaserVOS = purchaserService.selectAllPurchaserByPage(queryDetailIfo);
        PageInfo<PurchaserVO> pageInfo = new PageInfo<>(purchaserVOS);
        return Result.success(getDataTable(pageInfo));
    }

    /**
     * 审核采购人
     * @param examinePurchaserHandle
     * @return
     */
    @Override
    public Result examinePurchaser(@RequestBody ExaminePurchaserHandle examinePurchaserHandle) {
        return purchaserService.examinePurchaser(examinePurchaserHandle);
    }


    /**
     * 启用锁定采购人
     * @param purchaserForbiddenHandle
     * @return
     */
    @Override
    public Result<Boolean> forbiddenPurchaserUser(@RequestBody PurchaserForbiddenHandle purchaserForbiddenHandle) {
        return purchaserService.forbiddenPurchaserUser(purchaserForbiddenHandle);
    }
}
