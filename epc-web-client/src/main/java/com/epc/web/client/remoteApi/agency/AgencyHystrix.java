package com.epc.web.client.remoteApi.agency;

import com.epc.common.Result;
import com.epc.web.facade.agency.FacadeAgencyService;
import com.epc.web.facade.agency.dto.*;
import com.epc.web.facade.agency.handle.HandleAgency;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import com.epc.web.facade.agency.vo.AgencyEmployeeVo;
import com.epc.web.facade.agency.vo.AgencyExpertDetailVo;
import com.epc.web.facade.agency.vo.AgencyExpertVo;
import com.epc.web.facade.agency.vo.AgencySupplierVo;
import com.epc.web.facade.purchaser.dto.QueryDto;
import com.epc.web.facade.purchaser.handle.HandleTrustList;

import java.util.HashMap;
import java.util.List;

/**
 * @Author :winlin
 * @Description :
 * @Date:2018/9/15
 */
public class AgencyHystrix implements FacadeAgencyService {
    @Override
    public Result insertEmployee(HandleEmployee employee) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> enableOrDisableAgencyEmployee(HandleTrustList trustList) {
        return Result.hystrixError();
    }


    @Override
    public Result insertExpert(HandleExpert handleExpert) {
        return Result.hystrixError();
    }

    @Override
    public Result insertSupplier(HandleSupplier handleSupplier) {
        return Result.hystrixError();
    }


    @Override
    public Result completeInfo(HandleAgency agency) {
        return Result.hystrixError();
    }

    @Override
    public Result<AgencyEmployeeVo> queryEmployeeById(QueryDto dto) {
        return Result.hystrixError();
    }


    @Override
    public Result queryEmployee(AgencyEmployeeDto employee) {
        return Result.hystrixError();
    }


    @Override
    public Result updateEmployeeBy(HandleEmployee employee) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateAgencyEmployeeRoleById(HandleTrustList trustList) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> completeAgencySupInfo(AgencySupplierDto supplierDto) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<AgencySupplierVo>> querySupplierCriteria(SupplierDto supplierDto) {
        return Result.hystrixError();
    }

    @Override
    public Result<AgencySupplierVo> queryAgencySupplierDetail(QueryDto dto) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> completeAgencyExpertInfo(AgencyExpertDto expertDto) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> deleteAgencyExpertById(HandleTrustList trustList) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<AgencyExpertVo>> queryExpertCriteria(ExpertDto expertDto) {
        return Result.hystrixError();
    }

    @Override
    public Result<AgencyExpertDetailVo> queryExpertDetailById(QueryDto dto) {
        return Result.hystrixError();
    }
}
