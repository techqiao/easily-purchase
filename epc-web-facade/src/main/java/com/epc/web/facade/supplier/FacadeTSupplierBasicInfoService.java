package com.epc.web.facade.supplier;

import com.epc.common.Result;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.facade.supplier.vo.SupplierDetailInfoVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @Description:    供应商添加员工
 * @Author:         donghuan
 */
public interface FacadeTSupplierBasicInfoService {

    /**
     * 注册供应商
     * @param handleSupplierDetail
     * @return
     */
    @PostMapping(value = "registerSupplier",consumes = "application/json;charset=UTF-8")
    Result<Boolean> registerSupplier(@RequestBody  HandleSupplierDetail handleSupplierDetail);

    /**
     * 查询用户信息，依据电话或者密码来查找这个人的详细信息
     * @param name
     * @param cellphone
     * @return
     */
    @PostMapping(value = "findByName",consumes = "application/json;charset=UTF-8")
    Result<SupplierDetailInfoVO> findByName(@RequestParam("name") String name,@RequestParam("cellphone") String cellphone);

    /**
     * 忘记密码
     * @param handleSupplierForgetPassword
     */
    @PostMapping(value = "forgetPassword",consumes = "application/json;charset=UTF-8")
    Result<Boolean> forgetPassword(@RequestBody HandleSupplierForgetPassword handleSupplierForgetPassword);

    /*====================================================*/

    /**
     * 供应商添加员工
     * @param handlerSupplierAddEmployee
     * @return
     */
    @PostMapping(value = "createSupplierEmployee", consumes = "application/json;charset=UTF-8")
    Result<Boolean> createSupplierEmployee(@RequestBody HandlerSupplierAddEmployee handlerSupplierAddEmployee);


    /**
     * 供应商通过员工id来修改名字和手机号及状态是否可用
     * @param
     * @return
     */
    @PostMapping(value = "updateSupplierEmployeeById", consumes ="application/json;charset=UTF-8" )
    Result<Boolean> updateSupplierEmployeeById(@RequestBody HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById);


    /**
     *  模糊查询
     *  传入员工的姓名查询所有的员工列表
     * @return
     */
    @PostMapping(value = "querySupplierEmployeeAll", consumes = "application/json;charset=UTF-8")
    Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(@RequestBody HandleSupplierFindAllByName handleSupplierFindAllByName);


}
