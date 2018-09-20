package com.epc.web.client.remoteApi.agency;

import com.epc.common.Result;
import com.epc.web.facade.agency.FacadeAgencyService;
import com.epc.web.facade.agency.handle.HandleAgency;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

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

    @PostMapping(value = "regesityAgency", consumes = "application/json; charset=UTF-8")
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
    public Result proxySubjects() {
        return Result.hystrixError();
    }

    @Override
    public Result queryEmployee(HandleEmployee employee) {
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
}
