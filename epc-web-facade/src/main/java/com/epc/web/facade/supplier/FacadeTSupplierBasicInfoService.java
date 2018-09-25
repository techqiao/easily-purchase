package com.epc.web.facade.supplier;

import com.epc.common.Result;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleFindSupplierByInfo;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
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
    @PostMapping(value = "registerSupplier",consumes = "application/json;charset=UTF-8")
    Result<Boolean> registerSupplier(@RequestBody  HandleSupplierDetail handleSupplierDetail);

    /**
     * 根据员工的id来删除员工
     */
    @PostMapping(value = "deleteSupplierEmployeeById",consumes = "application/json;charset=UTF-8")
    Result<Boolean> deleteSupplierEmployeeById(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 根据员工的id来查询基本信息
     */
    @PostMapping(value = "findSupplierBasicById",consumes = "application/json;charset=UTF-8")
    Result<SupplierBasicInfoVO> findSupplierBasicById(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 员工查看 公司详情
     */
    @PostMapping(value = "findSupplierDetailByEmployee",consumes = "application/json;charset=UTF-8")
    Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 根据电话来查找一条记录,返回一个记录
     */
    @PostMapping(value = "findSupplierByCellphone",consumes = "application/json;charset=UTF-8")
    Result<SupplierBasicInfoVO> findSupplierByCellphone(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);


//    /**
//     * 查询用户信息，依据电话密码来查找这个人的详细信息
//     */
//    @GetMapping(value = "findByNameSupplier",consumes = "application/json;charset=UTF-8")
//    Result<SupplierBasicInfoVO> findByName(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 忘记密码
     */
    @PostMapping(value = "forgetPasswordSupplier",consumes = "application/json;charset=UTF-8")
    Result<Boolean> forgetPassword(@RequestBody HandleSupplierForgetPassword handleSupplierForgetPassword);



    /**
     * 供应商添加员工
     */
    @PostMapping(value = "createSupplierEmployee", consumes = "application/json;charset=UTF-8")
    Result<Boolean> createSupplierEmployee(@RequestBody HandlerSupplierAddEmployee handlerSupplierAddEmployee);


    /**
     * 供应商通过员工id来修改名字和手机号及状态是否可用
     */
    @PostMapping(value = "updateSupplierEmployeeById", consumes ="application/json;charset=UTF-8" )
    Result<Boolean> updateSupplierEmployeeById(@RequestBody HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById);


    /**
     *  模糊查询
     *  传入员工的姓名查询所有的员工列表
     */
    @PostMapping(value = "querySupplierEmployeeAll", consumes = "application/json;charset=UTF-8")
    Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 完善供应商信息
     */
    @PostMapping(value = "insertCompleteSupplierInfo",consumes ="application/json;charset=UTF-8" )
    Result<Boolean> insertCompleteSupplierInfo(@RequestBody RoleDetailInfo roleDetailInfo);


}
