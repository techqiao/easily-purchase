package com.epc.web.facade.supplier;

import com.epc.common.Result;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleFindSupplierByInfo;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    @PostMapping(value = "supplierRegister",consumes = "application/json;charset=UTF-8")
    Result<Boolean> registerSupplier(@RequestBody  HandleSupplierDetail handleSupplierDetail);

    /**
     * 根据员工的id来查询基本信息
     */
    @PostMapping(value = "fingSupplierBasicById",consumes = "application/json;charset=UTF-8")
    Result<SupplierBasicInfoVO> fingSupplierBasicById(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);

//    /**
//     * 根据员工id来查询 公司详情
//     */
//    Result<Boolean> findSupplierDetailByEmployee();

    /**
     * 根据电话来查找一条记录,返回一个记录
     */
    @PostMapping(value = "findSupplierByCellphone",consumes = "application/json;charset=UTF-8")
    Result<SupplierBasicInfoVO> findSupplierByCellphone(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);


    /**
     * 查询用户信息，依据电话或者密码来查找这个人的详细信息
     */
    @GetMapping(value = "supplierFindByName",consumes = "application/json;charset=UTF-8")
    Result<SupplierBasicInfoVO> findByName(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 忘记密码
     * @param handleSupplierForgetPassword
     */
    @PostMapping(value = "supplierForgetPassword",consumes = "application/json;charset=UTF-8")
    Result<Boolean> forgetPassword(@RequestBody HandleSupplierForgetPassword handleSupplierForgetPassword);



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
    Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 完善供应商信息
     */
    @PostMapping(value = "completeSupplierInfo",consumes ="application/json;charset=UTF-8" )
    Result<Boolean> insertCompleteSupplierInfo(@RequestBody RoleDetailInfo roleDetailInfo);


}
