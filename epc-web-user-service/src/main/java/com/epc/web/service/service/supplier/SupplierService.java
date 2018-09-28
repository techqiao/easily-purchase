package com.epc.web.service.service.supplier;


import com.epc.common.Result;
import com.epc.web.facade.operator.handle.HandleOperatorRole;
import com.epc.web.facade.operator.handle.HandleOperatorState;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleFindSupplierByInfo;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;

import java.util.List;


/**
 * @author donghuan
 */
public interface SupplierService {

    /**
     * 注册供应商
     */
    Result<Boolean> registerSupplier(HandleSupplierDetail handleSupplierDetail);

    /**
     *  由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号
     *  @author donghuan
     */
    Result<Boolean> addPasswordSupplier(HandleSupplierDetail handleSupplierDetail);

    /**
     * 根据员工id来删除一个员工
     */
    Result<Boolean> deleteSupplierEmployeeById(HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 根据员工的id来查询基本信息
     */
    Result<SupplierBasicInfoVO> findSupplierBasicById(HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 通过员工id 只 修改员工的状态
     */
    Result<Boolean> updateSupplierEmployeeByisDeleted(HandleSupplierEmployeeByisDeleted handleSupplierEmployeeByisDeleted);

    /**
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     * @author donghuan
     */
    Result<Boolean> updateSupplierEmployeeRoleById(HandleOperatorRole handleOperatorRole);


    /**
     * 根据电话来查找一条记录,返回一个真假值
     */
    Result<Boolean> findSupplierRecordByCellphone(HandleSupplierRecordByCellphone handleSupplierByCellphone);

    /**
     * 根据员工id来查询 公司详情
     */
    Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    Result<Boolean> updateSupplierEmployeeStateById(HandleOperatorState handleOperatorState);

    /**
     * 根据电话来查找一条记录,返回一个记录
     */
    Result<SupplierBasicInfoVO> findSupplierByCellphone(HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 查询用户信息，依据电话密码来查找这个人的详细信息
     */
//    Result<SupplierBasicInfoVO> findByName(HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 忘记密码
     */
    Result<Boolean> forgetPassword(HandleSupplierForgetPassword handleSupplierForgetPassword);

    /**
     *  供应商添加员工
     */
    Result<Boolean> createSupplierEmployee(HandlerSupplierAddEmployee handlerSupplierAddEmployee);

    /**
     * 供应商通过员工id来修改名字和手机号及状态是否可用
     */
    Result<Boolean> updateSupplierEmployeeById(HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById);

    /**
     *  模糊查询
     *  传入员工的姓名查询所有的员工列表
     */
    Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 由员工状态来查询出员工的列表:(你给我你的id, 我找出这个角色当中符合这个状态的所有员工)
     */
    Result<List<SupplierBasicInfoVO>> querySupplierEmployeeByisDeleted(HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 完善供应商信息
     */
    Result<Boolean> insertCompleteSupplierInfo(RoleDetailInfo roleDetailInfo);

}
