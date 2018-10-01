package com.epc.web.client.remoteApi.agency;

import com.epc.common.Result;
import com.epc.web.facade.agency.FacadeAgencyService;
import com.epc.web.facade.agency.dto.AgencyExpertDto;
import com.epc.web.facade.agency.dto.AgencyEmployeeDto;
import com.epc.web.facade.agency.dto.AgencySupplierDto;
import com.epc.web.facade.agency.handle.HandleAgency;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import com.epc.web.facade.agency.vo.AgencyEmployeeVo;
import com.epc.web.facade.agency.vo.AgencyExpertVo;
import com.epc.web.facade.agency.vo.AgencySupplierVo;
import com.epc.web.facade.loginuser.dto.RegisterDto;

import java.util.HashMap;
import java.util.List;

/**
 *@Author :winlin
 *@Description :
 *@Date:2018/9/15
 */
public class AgencyHystrix implements FacadeAgencyService{
    @Override
    public Result insertEmployee(HandleEmployee employee) {
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
    public Result regesityAgency(HandleAgency agency) {
        return Result.hystrixError();
    }

    @Override
    public Result queryAgencies(HandleAgency agency) {
        return Result.hystrixError();
    }

    @Override
    public Result modifypassword(HandleAgency agency) {
        return Result.hystrixError();
    }

    @Override
    public Result completeInfo(HandleAgency agency) {
        return Result.hystrixError();
    }


    @Override
    public Result queryEmployee(AgencyEmployeeDto employee) {
        return Result.hystrixError();
    }

    @Override
    public Result queryEmployeeByCellphone(HashMap<String,String> map) {
        return Result.hystrixError();
    }

    @Override
    public Result queryEmployeeById(HashMap<String,Long> map) {
        return Result.hystrixError();
    }

    @Override
    public Result updateEmployeeBy(HandleEmployee employee) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<AgencyEmployeeVo>> queryAllEmployee(HashMap<String, Long> map) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<AgencySupplierVo>> querySupplierCriteria(AgencySupplierDto supplierDto) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<AgencyExpertVo>> queryExpertCriteria(AgencyExpertDto expertDto) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> completeAgencySupInfo(AgencySupplierDto supplierDto) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> completeAgencyExpertInfo(AgencyExpertDto expertDto) {
        return Result.hystrixError();
    }
}
