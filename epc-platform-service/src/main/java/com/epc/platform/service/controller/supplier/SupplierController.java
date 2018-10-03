package com.epc.platform.service.controller.supplier;

import com.epc.administration.facade.supplier.SupplierUserService;
import com.epc.administration.facade.supplier.dto.QueryDetailIfo;
import com.epc.administration.facade.supplier.handle.ExamineSupplierHandle;
import com.epc.administration.facade.supplier.handle.SupplierForbiddenHandle;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.administration.facade.supplier.handle.UserBasicInfo;
import com.epc.administration.facade.supplier.vo.SupplierUserVO;
import com.epc.common.Result;
import com.epc.platform.service.controller.admin.BaseController;
import com.epc.platform.service.domain.operator.TOperatorDetailInfo;
import com.epc.platform.service.service.supplier.SupplierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * <p>Description : 供应商控制器
 * <p>Date : 2018-09-10  18:08
 * <p>@author : wjq
 */
@RestController
public class SupplierController extends BaseController implements SupplierUserService {
    @Autowired
    private SupplierService supplierService;

    /**
     * 供应商注册
     * @param userBasicInfo 基本信息
     * @return
     */
    @Override
    public Result<Boolean> createSupplierUserInfo(@RequestBody UserBasicInfo userBasicInfo) {
        return supplierService.insertSupplierUserInfo(userBasicInfo);
    }

    /**
     * 供应商资料补全
     * @param supplierHandle 附件信息
     * @return
     */
    @Override
    public Result<Boolean> insertSupplierDetailInfo(@RequestBody SupplierHandle supplierHandle) {
        return supplierService.insertSupplierDetailInfo(supplierHandle);
    }

    /**
     * 修改供应商资料
     * @param supplierHandle 附件信息
     * @return
     */
    @Override
    public Result<Boolean> updateSupplierDetailInfo(SupplierHandle supplierHandle) {
        return supplierService.updateSupplierDetailInfo(supplierHandle);
    }

    /**
     * 供应商资料删除
     * @param whereId
     * @return
     */
    @Override
    public Result<Boolean> deleteSupplierDetailInfo(@RequestParam("whereId") Long whereId) {
        return supplierService.deleteSupplierDetailInfo(whereId);
    }

    /**
     * 供应商资料查询
     * @param id
     * @return
     */
    @Override
    public Result<TOperatorDetailInfo> querySupplierDetailInfo(@RequestParam("whereId") Long id) {
        return supplierService.querySupplierDetailInfo(id);
    }

    /**
     * 查询所有的供应商 分页展示
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result<Map<String, Object>> selectAllSupplierByPage(@RequestBody QueryDetailIfo queryDetailIfo) {
        PageHelper.startPage(queryDetailIfo.getPageNum(),queryDetailIfo.getPageSize());
        List<SupplierUserVO> supplierUserVOS = supplierService.selectAllSupplierByPage(queryDetailIfo);
        PageInfo<SupplierUserVO> pageInfo = new PageInfo<>(supplierUserVOS);
        return Result.success(getDataTable(pageInfo));
    }

    /**
     * 审核供应商
     * @param examineSupplierHandle
     * @return
     */
    @Override
    public Result examineSupplier(@RequestBody ExamineSupplierHandle examineSupplierHandle) {
        return supplierService.examineSupplier(examineSupplierHandle);
    }

    /**
     * 禁用启用供应商
     * @param supplierForbiddenHandle
     * @return
     */
    @Override
    public Result<Boolean> forbiddenSupplierUser(SupplierForbiddenHandle supplierForbiddenHandle) {
        return supplierService.forbiddenSupplierUser(supplierForbiddenHandle);
    }
}
