package com.epc.web.facade.agency;

import com.epc.common.Result;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author :winlin
 * @Description :代理商服务
 * @Date:2018/9/15
 */
public interface FacadeAgencyService {
    /**
     * 代理商新增员工
     *
     * @param employee
     * @return
     */
    @PostMapping(value = "insertEmployee", consumes = "application/json; charset=UTF-8")
    Result insertEmployee(@RequestBody HandleEmployee employee);

    /**
     * 代理商新增专家
     *
     * @param handleExpert
     * @return
     */
    @PostMapping(value = "insertExpert", consumes = "application/json; charset=UTF-8")
    public Result insertExpert( @RequestBody HandleExpert handleExpert);

    /**
     * 代理商新增供货商
     *
     * @param handleSupplier
     * @return
     */
    @PostMapping(value = "insertSupplier", consumes = "application/json; charset=UTF-8")
    public Result insertSupplier( @RequestBody HandleSupplier handleSupplier);
}
