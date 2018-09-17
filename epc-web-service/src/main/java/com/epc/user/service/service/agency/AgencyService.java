package com.epc.user.service.service.agency;

import com.epc.common.Result;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import org.springframework.stereotype.Service;

/**
 *@Author :winlin
 *@Description : 代理机构接口
 *@Date:2018/9/13
 */
public interface AgencyService {

    /**
     *@Author :winlin
     *@Description :新增员工
     *@Date:2018/9/13
     */
    public Result insertEmployee(HandleEmployee handleEmployee);
    /**
     *@Author :winlin
     *@Description :新增专家
     *@Date:2018/9/13
     */
    public Result insertExpert(HandleExpert handleExpert);

    /**
     *@Author :winlin
     *@Description :新增供应商
     *@Date:2018/9/13
     */
    public Result insertSupplier(HandleSupplier handleSupplier);
}
