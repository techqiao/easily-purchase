package com.epc.web.service.controller.purchaser;


import com.epc.common.Result;
import com.epc.web.facade.expert.Handle.HandleExpert;
import com.epc.web.facade.purchaser.FacadePurchaserService;
import com.epc.web.facade.purchaser.dto.*;
import com.epc.web.facade.purchaser.handle.*;
import com.epc.web.facade.purchaser.vo.*;
import com.epc.web.service.controller.BaseController;
import com.epc.web.service.service.purchaser.PurchaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>Description : 供应商控制器
 * <p>Date : 2018-09-10  18:08
 */
@RestController
public class PurchaserController extends BaseController implements FacadePurchaserService {

    @Autowired
    PurchaserService purchaserService;


    @Override
    public Result<Boolean> createPurchaserUserInfo(@RequestBody HandlePurchaser handleEmployee) {
        return purchaserService.createPurchaserUserInfo(handleEmployee);
    }

    @Override
    public Result<Boolean> enableOrDisablePurchaserEmployee(@RequestBody HandleTrustList trustList) {

        return purchaserService.enableOrDisablePurchaserEmployee(trustList);
    }

    @Override
    public Result<Boolean> updatePurchaserEmployeeRole(@RequestBody HandleTrustList trustList) {
        return purchaserService.updatePurchaserEmployeeRole(trustList);
    }

    @Override
    public Result<Boolean> updatePurchaserEmployeeInfo(@RequestBody HandlePurchaserDto handlePurchaser) {

        return purchaserService.updatePurchaserEmployeeInfo(handlePurchaser);
    }

    @Override
    public Result<List<PurchaserEmplyeeVo>> queryEmplyee(@RequestBody HandleEmployeeDto employeeDto) {

        return purchaserService.queryEmplyee(employeeDto);
    }

    @Override
    public Result<Boolean> createExpertUserInfo(@RequestBody HandleExpert handleExpert) {

        return purchaserService.createExpertUserInfo(handleExpert);
    }

    @Override
    public Result<Boolean> completePurchaserExpertInfo(@RequestBody HandleExpertDto expertDto) {
        return purchaserService.completePurchaserExpertInfo(expertDto);
    }

    @Override
    public Result<Boolean> deletePurchaserExpert(@RequestBody HandleTrustList trustList) {

        return purchaserService.deletePurchaserExpert(trustList);
    }

    @Override
    public Result<List<PurchaserExpertVo>> queryExperts(@RequestBody QueryExpertDto dto) {

        return purchaserService.queryExperts(dto);
    }

    @Override
    public Result<Boolean> createAgencyUserInfo(@RequestBody HandleAgnecy handleAgnecy) {
        return purchaserService.createAgencyUserInfo(handleAgnecy);
    }

    @Override
    public Result<Boolean> updateAgencyDetail(@RequestBody HandleAgnecy handleAgnecy) {

        return purchaserService.updateAgencyDetail(handleAgnecy);
    }

    @Override
    public Result<Boolean> updateTrustListForAgency(@RequestBody HandleTrustList trustList) {

        return purchaserService.updateTrustListForAgency(trustList);
    }

    @Override
    public Result<List<PurchaserAgencyVo>> queryAgenciesByCriteria(@RequestBody QueryAgencyDto agencyDto) {
        return purchaserService.queryAgenciesByCriteria(agencyDto);
    }

    @Override
    public Result<Boolean> createSupplierByPurchaser(@RequestBody HandleSupplierDto handleOperator) {

        return purchaserService.createSupplierByPurchaser(handleOperator);
    }

    @Override
    public Result<Boolean> updateSupplierDetail(@RequestBody PurchaserHandleSupplierDto dto) {
        return purchaserService.updateSupplierDetail(dto);
    }

    @Override
    public Result<Boolean> updateTrustListForSupplier(@RequestBody HandleTrustList trustList) {
        return purchaserService.updateTrustListForSupplier(trustList);
    }

    @Override
    public Result<List<PurchaserSupplierVo>> querySupplierByCriterias(@RequestBody QuerySupplierDto supplierDto) {
        return purchaserService.querySupplierByCriterias(supplierDto);
    }

    @Override
    public Result<Boolean> updatePurchaserDetail(@RequestBody HandleRegisterPurchaser handlePurchaser) {
        return purchaserService.updatePurchaserDetail(handlePurchaser);
    }

    @Override
    public Result<PurchaserEmplyeeVo> queryEmployeeDto(@RequestBody QueryDto dto) {
        return purchaserService.queryEmployeeDto(dto);
    }

    @Override
    public Result<Boolean> updateRole(Long id, Integer role) {
        return purchaserService.updateRole(id, role);
    }

    @Override
    public Result<SupplierDetailVo> querySuppliersDto(@RequestBody QueryDto dto) {
        return purchaserService.querySuppliersDto(dto);
    }

    @Override
    public Result<PurchaserExpertDetailVo> queryExpertDetailById(@RequestBody QueryDto dto) {
        return purchaserService.queryExpertDetailById(dto);
    }

    @Override
    public Result<PurchaserAgencyDetailVo> queryAgencyDetailById(@RequestBody QueryDto dto) {
        return purchaserService.queryAgencyDetailById(dto);

    }

    @Override
    public Result<Boolean> deletePurchaserEmployee(@PathVariable("id") Long id) {
        return purchaserService.deletePurchaserEmployee(id);
    }


    @Override
    public Result selectPurchaserProjectStatus(@RequestBody RoleProjectProcessDetail detail) {
        //获得页面显示size
        Integer pageSize = detail.getPageSize() == null || detail.getPageSize() <= 0 ? 10 : detail.getPageSize();
        //获得页码
        Integer pageNum = detail.getPageNum() == null || detail.getPageNum() <= 0 ? 0 : detail.getPageNum() - 1;
        //查询结果,先依据查询条件从缓存中取
        String listKey = detail.getStepType() + detail.getUserType() + detail.getId();
        List<?> targetList = super.getList(listKey);
        if (CollectionUtils.isEmpty(targetList)) {
            targetList = (List) purchaserService.selectPurchaserProjectStatus(detail).getData();
            if (CollectionUtils.isEmpty(targetList)) {
                return Result.success("没有符合条件的信息");
            }
            super.setList(listKey, targetList);
        }
        //获得size大小
        int size = targetList.size();
        //获得开始的index和结束的index
        int fromIndex = pageNum * 10 > (size - 1) ? (size - 1) : pageNum * 10;
        int toIndex = fromIndex + pageSize > (size - 1) ? (size - 1) : fromIndex + pageSize;
        //返回截取的list
        List pageList = targetList.subList(fromIndex, toIndex + 1);
        return Result.success(super.getDataList(pageList, size));
    }

    ;


    @Override
    public Result<Boolean> updateExpertState(Long id, Integer state) {
        return purchaserService.updateEmployeeState(id, state);
    }


    @Override
    public Result queryEmployee(Long userId) {
        return purchaserService.queryEmployee(userId + "");
    }

}
