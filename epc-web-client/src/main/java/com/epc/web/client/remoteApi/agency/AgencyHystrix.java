package com.epc.web.client.remoteApi.agency;

import com.epc.common.Result;
import com.epc.web.facade.agency.FacadeAgencyService;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;

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
}
