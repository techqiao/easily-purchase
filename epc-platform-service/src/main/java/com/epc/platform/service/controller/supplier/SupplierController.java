package com.epc.platform.service.controller.supplier;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.supplier.SupplierUserService;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.common.QueryRequest;
import com.epc.common.Result;
import com.epc.platform.service.controller.admin.BaseController;
import com.epc.platform.service.domain.operator.TOperatorDetailInfo;
import com.epc.platform.service.domain.supplier.TSupplierDetailInfo;
import com.epc.platform.service.service.supplier.SupplierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>Description : 供应商控制器
 * <p>Date : 2018-09-10  18:08
 * <p>@author : wjq
 */
@Api(value = "供应商服务", description = "供应商服务")
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
     * 供应商资料删除
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result<Boolean> deleteSupplierDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return supplierService.deleteSupplierDetailInfo(queryDetailIfo);
    }

    /**
     * 供应商资料查询
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result<TOperatorDetailInfo> querySupplierDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return supplierService.querySupplierDetailInfo(queryDetailIfo);
    }

    /**
     * 供应商资料模糊查询
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result<List<TOperatorDetailInfo>> selectSupplierDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return supplierService.selectSupplierDetailInfo(queryDetailIfo);
    }

    /**
     * 查询所有的供应商 分页展示
     * @param queryRequest
     * @return
     */
    @Override
    public Result selectAllSupplierByPage(@RequestBody QueryRequest queryRequest) {
        PageHelper.startPage(queryRequest.getPageNum(),queryRequest.getPageSize());
        List<TSupplierDetailInfo> tSupplierDetailInfos = supplierService.selectAllSupplierByPage();
        PageInfo<TSupplierDetailInfo> pageInfo = new PageInfo<>(tSupplierDetailInfos);
        return Result.success(getDataTable(pageInfo));
    }
}
